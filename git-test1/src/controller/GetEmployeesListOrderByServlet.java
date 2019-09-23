package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;
import vo.Employees;

/**
 * Servlet implementation class GetEmployeesListOrderByServlet
 */
@WebServlet("/employees/getEmployeesListOrderBy")
public class GetEmployeesListOrderByServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
