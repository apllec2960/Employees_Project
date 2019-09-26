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

/**
 * Servlet implementation class GetEmployeesListOrderByServlet
 */
@WebServlet("/employees/getEmployeesListOrderBy")
public class GetEmployeesListOrderByServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인이 안되있다면 로그인 페이지로.
		HttpSession session = request.getSession();//첫 요청할때 session을 받아옴.
		if(session.getAttribute("sessionEmpNo") == null) { //처음 접속이거나 로그인을 하지않았거나..
			response.sendRedirect(request.getContextPath()+"/login");//서버가 아닌 내가 요청하기 때문에 request.getContextPath().
			return;
		}
		
		String order = request.getParameter("order");
		System.out.println("GetEmployeesListOrderByServlet param order :" + order);
		
		employeesDao = new EmployeesDao();
		List<Employees> list = employeesDao.selectEmployeesListOrderBy(order);
		//employeesDao에 매개변수 order를 받는 selectEmployeesListOredrBy를 list에 복사.
		
		
		request.setAttribute("list", list);	//list 객체를 "list"에 저장하여 request보관.
		
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListOrderBy.jsp").forward(request, response);
		///WEB-INF/views/employees/employeesListOrderBy.jsp로 포워딩.
	}

}
