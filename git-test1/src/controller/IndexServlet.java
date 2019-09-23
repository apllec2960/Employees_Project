package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentsDao;
import model.DeptEmpDao;
import model.DeptManagerDao;
import model.EmployeesDao;
import model.SalariesDao;
import model.TitlesDao;

/**
 * Servlet implementation class IndexServle
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	private DepartmentsDao departmentsDao;
	private DeptEmpDao deptEmpDao;
	private DeptManagerDao deptManagerDao;
	private SalariesDao salariesDao;
	private TitlesDao titlesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/index URL 요청");
		
		//EmployeesDao employeesDao = new EmployeesDao();
		employeesDao = new EmployeesDao();	//모델(Dao)을 호출해서 값을 가져옴.
		int employeesRowCount =  employeesDao.selectEmployeesCount(); //employees 사원의 모든 수를 employeesRowCount변수에 저장.
		System.out.println("employeesRowCount : "+employeesRowCount);
		request.setAttribute("employeesRowCount", employeesRowCount);
		// /WEB-INF/views/index.jsp
		/* 방법 1
		 * RequestDispatcher rd =
		 * request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		 * rd.forward(request,response);
		 */
		departmentsDao = new DepartmentsDao();
		int departmentsRowCount = departmentsDao.selectDepartmentsRowCount();
		System.out.println("departmentsRowCount : "+departmentsRowCount);
		request.setAttribute("departmentsRowCount", departmentsRowCount);
		
		deptEmpDao = new DeptEmpDao();
		int deptEmpRowCount = deptEmpDao.selectDeptEmpRowCount();
		System.out.println("deptEmpRowCount : "+deptEmpRowCount);
		request.setAttribute("deptEmpRowCount", deptEmpRowCount);
		
		deptManagerDao = new DeptManagerDao();
		int deptManagerRowCount = deptManagerDao.selectDeptManagerRowCount();
		System.out.println("deptManagerRowCount : "+deptManagerRowCount);
		request.setAttribute("deptManagerRowCount",deptManagerRowCount);
		
		salariesDao = new SalariesDao();
		int salariesRowCount = salariesDao.selectSalariesRowCount();
		System.out.println("salariesRowCount : "+salariesRowCount);
		request.setAttribute("salariesRowCount", salariesRowCount );
		
		titlesDao = new TitlesDao();
		int titlesRowCount = titlesDao.selectTitlesRowCount();
		System.out.println("titlesRowCount : "+titlesRowCount);
		request.setAttribute("titlesRowCount",titlesRowCount );
		
		
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request,response);
		 
	}

}
