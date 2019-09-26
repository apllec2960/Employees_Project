package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeesDao;
import vo.Employees;


@WebServlet("/employees/getEmployeesList")
public class GetEmployeesListServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인이 안되있다면 로그인 페이지로.
		HttpSession session = request.getSession();//첫 요청할때 session을 받아옴.
		if(session.getAttribute("sessionEmpNo") == null) { //처음 접속이거나 로그인을 하지않았거나..
			response.sendRedirect(request.getContextPath()+"/login");//서버가 아닌 내가 요청하기 때문에 request.getContextPath().
			return;
		}
		
		int limit = 10;	//보여줄 개수.
		if(request.getParameter("limit")!=null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		System.out.println("GetEmployeesListServlet param limit :"+ limit);
		employeesDao = new EmployeesDao();
		
		List<Employees> list = employeesDao.selectEmployeesListByLimit(limit);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesList.jsp").forward(request, response);
	}
}
