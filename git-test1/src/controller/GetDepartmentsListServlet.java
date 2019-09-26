package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DepartmentsDao;
import vo.Departments;

@WebServlet("/departments/getDepartmentsList")
public class GetDepartmentsListServlet extends HttpServlet {
	private DepartmentsDao departmentsDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	departmentsDao = new DepartmentsDao();
	
	// 로그인이 안되있다면 로그인 페이지로.
	HttpSession session = request.getSession();//첫 요청할때 session을 받아옴.
	if(session.getAttribute("sessionEmpNo") == null) { //처음 접속이거나 로그인을 하지않았거나..
		response.sendRedirect(request.getContextPath()+"/login");//서버가 아닌 내가 요청하기 때문에 request.getContextPath().
		return;
	}
	
	List<Departments> list = departmentsDao.selectDepartmentsList(); //list에 departments테이블의 데이터를 출력하는 메소드의 데이터를 저장
	
	request.setAttribute("list",list);
	//list에 객체list값을 저장하여 request에 보관..
	request.getRequestDispatcher("/WEB-INF/views/departments/departmentsList.jsp").forward(request, response);
	//WEB-INF/views/departments/DepartmentsList로 forward한다.
	}

}
