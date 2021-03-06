
package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DepartmentsDao;
import model.DeptEmpDao;
import model.DeptManagerDao;
import model.EmployeesDao;
import model.SalariesDao;
import model.TitlesDao;

/**
 * Servlet implementation class IndexServle
 */
@WebServlet({"/","/index"})
public class IndexServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	private DepartmentsDao departmentsDao;
	private DeptEmpDao deptEmpDao;
	private DeptManagerDao deptManagerDao;
	private SalariesDao salariesDao;
	private TitlesDao titlesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/index URL 요청");
		
		// 로그인이 안되있다면 로그인 페이지로.
		HttpSession session = request.getSession();//첫 요청할때 session을 받아옴.
		if(session.getAttribute("sessionEmpNo") == null) { //처음 접속이거나 로그인을 하지않았거나..
			response.sendRedirect(request.getContextPath()+"/login");//서버가 아닌 내가 요청하기 때문에 request.getContextPath().
			return;
		}
		
		//employees 수를 가져옴
		employeesDao = new EmployeesDao();	//모델(Dao)을 호출해서 값을 가져옴.
		int employeesRowCount =  employeesDao.selectEmployeesCount(); //employees 사원의 모든 수를 employeesRowCount변수에 저장.
		System.out.println("employeesRowCount : "+employeesRowCount);
		request.setAttribute("employeesRowCount", employeesRowCount);
		
		//사원번호 조회(큰번호, 작은번호)
		int maxEmpNo = employeesDao.selectEmpNo("max");
		int minEmpNo = employeesDao.selectEmpNo("min");
		request.setAttribute("maxEmpNo", maxEmpNo);
		request.setAttribute("minEmpNo", minEmpNo);
		
		
		//departments 수를 가져옴
		departmentsDao = new DepartmentsDao();
		int departmentsRowCount = departmentsDao.selectDepartmentsRowCount();
		System.out.println("indexServlet departmentsRowCount : "+departmentsRowCount);
		request.setAttribute("departmentsRowCount", departmentsRowCount);
		
		//deptEmp 수를 가져옴
		deptEmpDao = new DeptEmpDao();
		int deptEmpRowCount = deptEmpDao.selectDeptEmpRowCount();
		System.out.println("indexServlet deptEmpRowCount : "+deptEmpRowCount);
		request.setAttribute("deptEmpRowCount", deptEmpRowCount);
		
		//deptManager 수를 가져옴
		deptManagerDao = new DeptManagerDao();
		int deptManagerRowCount = deptManagerDao.selectDeptManagerRowCount();
		System.out.println("indexServlet deptManagerRowCount : "+deptManagerRowCount);
		request.setAttribute("deptManagerRowCount",deptManagerRowCount);
		
		//salaries 수를 가져옴
		salariesDao = new SalariesDao();
		int salariesRowCount = salariesDao.selectSalariesRowCount();
		System.out.println("indexServlet salariesRowCount : "+salariesRowCount);
		request.setAttribute("salariesRowCount", salariesRowCount );
		
		//titles 수를 가져옴
		titlesDao = new TitlesDao();
		int titlesRowCount = titlesDao.selectTitlesRowCount();
		System.out.println("indexServlet titlesRowCount : "+titlesRowCount);
		request.setAttribute("titlesRowCount",titlesRowCount );
		
		
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request,response);
		 
	}

}
