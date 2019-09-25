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
 * Servlet implementation class GetEmployeesListByPageServlet
 */
@WebServlet("/employees/getEmployeesListByPage")
public class GetEmployeesListByPageServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1;	//현재페이지
		int rowPerPage = 10; 	//나타낼 행의 수
		int lastPage = 1;		//마지막 페이지
		
		//currentPage가 null값이면  처음 지정한 10으로 나타내고 아니라면 불러온 값을 currentPage에 저장.
		if(request.getParameter("currentPage")!=null) {	
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		System.out.println("GetEmployeesListByPageServlet param currentPage : "+ currentPage);
		
		
		employeesDao = new EmployeesDao();
		List<Employees> list = employeesDao.selectEmployeesListByPage(currentPage, rowPerPage); //
		
		int totalRow = employeesDao.selectEmployeesCount(); //totalRow = 전체 행의 수 , selectEmployeesCount() : employees테이블의 모든 행의 수를 구하는 메소드.
		if((totalRow%rowPerPage)==0) {
			lastPage = totalRow / rowPerPage;
		}else {
			lastPage = (totalRow/rowPerPage)+1;
		}
		System.out.println("GetEmployeesListByPageServlet param lastPage : "+ lastPage );
		
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage",lastPage);
		
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListByPage.jsp").forward(request, response);
		
		
		
		
		
	}
}
