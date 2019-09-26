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
 * Servlet implementation class GetEmployeesListByPageServlet
 */
@WebServlet("/employees/getEmployeesListByPage")
public class GetEmployeesListByPageServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1;	//현재페이지
		int rowPerPage = 10; 	//나타낼 행의 수
		int lastPage = 1;		//마지막 페이지
		
		// 로그인이 안되있다면 로그인 페이지로.
		HttpSession session = request.getSession();//첫 요청할때 session을 받아옴.
		if(session.getAttribute("sessionEmpNo") == null) { //처음 접속이거나 로그인을 하지않았거나..
			response.sendRedirect(request.getContextPath()+"/login");//서버가 아닌 내가 요청하기 때문에 request.getContextPath().
			return;
		}
		
		//currentPage가 null값이면  처음 지정한 10으로 나타내고 아니라면 불러온 값을 currentPage에 저장.
		if(request.getParameter("currentPage")!=null) {	
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		System.out.println("GetEmployeesListByPageServlet param currentPage : "+ currentPage);
		
		//리스트페이지에서 선택한 개수를 보여주기 위함. null값이 아니라면 입력된 값입력. 아니면 10저장.
		if(request.getParameter("rowPerPage")!=null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		System.out.println("GetEmployeesListByPageServlet param limit"+ rowPerPage);
		
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
		request.setAttribute("rowPerPage", rowPerPage);
		
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListByPage.jsp").forward(request, response);
		
		
		
		
		
	}
}
