package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentsDao;
import vo.Departments;

@WebServlet("/departments/getDepartmentsList")
public class GetDepartmentsListServlet extends HttpServlet {
	private DepartmentsDao departmentsDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	departmentsDao = new DepartmentsDao();
	
	List<Departments> list = departmentsDao.selectDepartmentsList(); //list에 departments테이블의 데이터를 출력하는 메소드의 데이터를 저장
	
	request.setAttribute("list",list);
	//list에 객체list값을 저장하여 request에 보관..
	request.getRequestDispatcher("/WEB-INF/views/departments/departmentsList.jsp").forward(request, response);
	//WEB-INF/views/departments/DepartmentsList로 forward한다.
	}

}
