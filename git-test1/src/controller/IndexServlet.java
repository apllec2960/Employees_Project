package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;

/**
 * Servlet implementation class IndexServle
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/index URL 요청");
		
		//EmployeesDao employeesDao = new EmployeesDao();
		this.employeesDao = new EmployeesDao();	//모델(Dao)을 호출해서 값을 가져옴.
		int employeesRowCount =  employeesDao.selectEmployeesCount(); //employees 사원의 모든 수를 employeesRowCount변수에 저장.
		System.out.println(employeesRowCount);
		// /WEB-INF/views/index.jsp
		/* 방법 1
		 * RequestDispatcher rd =
		 * request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		 * rd.forward(request,response);
		 */
		
		request.setAttribute("employeesRowCount", employeesRowCount);
		
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request,response);
		 
	}

}
