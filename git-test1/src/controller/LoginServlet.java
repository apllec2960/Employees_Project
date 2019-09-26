package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeesDao;
import vo.Employees;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	//login get 방식일떄 / Login Form을 위한 메소드 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
	}
	
	//login post 방식일떄 /  Login action을 위한 메소드.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		//디버깅 ->단위 테스트
		System.out.println("firstName" + firstName);
		System.out.println("lastNmae" + lastName);
		System.out.println("empNo" + empNo);
		
		Employees employees = new Employees();
		employees.setFirstName(firstName);
		employees.setLastName(lastName);
		employees.setEmpNo(empNo);
		
		employeesDao = new EmployeesDao();
		int sessionEmpNo = employeesDao.login(employees);
		System.out.println("sesstionEmpNo : " +sessionEmpNo);
		
		if( sessionEmpNo == 0) {
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
			return;
		}
		
		//session 값을 불러옴.
		HttpSession session = request.getSession();
		System.out.println("session :" +session);
		
		session.setAttribute("sessionEmpNo", sessionEmpNo);
		response.sendRedirect("request.getContextPath()+/index");
		
	}

}