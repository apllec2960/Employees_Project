package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DBHelper;
import vo.Employees;

public class EmployeesDao {
	
	//로그인 정보값을 가져오는 메소드.
	//로그인 메소드
	public int login(Employees employees) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT emp_no, first_name, last_name FROM employees where first_name = ? and last_name=? and emp_no =?";
		String firstName = employees.getFirstName();
		String lastName = employees.getLastName();
		int empNo = employees.getEmpNo();
		int sessionEmp = 0;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql); 
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setInt(3, empNo);
			rs= stmt.executeQuery();
			//System.out.println("rs :" +rs);
			if(rs.next()) {
				sessionEmp = rs.getInt("emp_no");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, stmt, rs);
		}
		return sessionEmp;
	}
	
	//사원목록을 나타내는 페이지(10 페이징)
	public List<Employees> selectEmployeesListByPage(int currentPage, int rowPerPage){
		List<Employees> list = new ArrayList<Employees>();
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees LIMIT ?,?";
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			int beginRow = 0; // 시작페이지
			beginRow = (currentPage-1)*rowPerPage;
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employees e = new Employees();
				e.setEmpNo(rs.getInt("emp_no"));
				e.setBirthDate(rs.getString("birth_date"));
				e.setFirstName(rs.getString("first_name"));
				e.setLastName(rs.getString("last_name"));
				e.setGender(rs.getString("gender"));
				e.setHireDate(rs.getString("hire_date"));
				list.add(e);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, stmt, rs);
		}
		return list;
	}
	
	//성별별 수를 구하는 메소드 
	public List<Map<String, Object>> selectEmployeesCountByGender(){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT gender, COUNT(gender) cnt FROM employees GROUP BY gender";
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("gender", rs.getString("gender"));
				map.put("cnt", rs.getString("cnt"));
				list.add(map);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
		DBHelper.close(conn, stmt, rs);	
		
		}
		return list;
	}
	
	
	//시작값과 끝값을 입력받아  입력된 번호의 사원을 출력해주는 메소드
	public List<Employees> selectEmployeesListBetween(int begin, int end){
		System.out.println("selectEmployeesListByLimit param begin :" + begin +" end :"+ end);
		List<Employees> list = new ArrayList<Employees>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select emp_no, birth_date, first_name, last_name, gender, hire_date  from employees where emp_no between ? and ? order by emp_no asc";
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, begin);
			stmt.setInt(2, end);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//max값과 min값을 출력해주는 메소드 ( index페이지에 데이터베이스에 등록되어있는 사원번호 max min을 나타냄.)
	public static int selectEmpNo(String str) {
		int empNo = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = null;
		ResultSet rs =null;
		
		if(str.equals("max")) {
			sql = "SELECT MAX(emp_no) FROM employees";	//str이 max라면 employees최대값
		}else if(str.equals("min")){
			sql = "SElECT MIN(emp_no) FROM employees";	//str이 min이라면 최소값
		}
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
		if(rs.next()) {
			empNo = rs.getInt(1);
		}
		System.out.println("empNo"+empNo);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return empNo;
	}
	
	//정렬된 리스트를 보여주는 메소드 : 조건은 first_name
	public List<Employees> selectEmployeesListOrderBy(String order){
		List<Employees> list =new ArrayList<Employees>();
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = null;
		ResultSet rs = null;
		
		if(order.equals("asc")) {
			sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees ORDER BY first_name asc LIMIT 50";
		}else if(order.equals("desc")) {
			sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees ORDER BY first_name desc LIMIT 50";
		}
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, stmt, rs);
		}
		return list;
	}
	
	
	
	//리스트를 출력해주는 메소드이며, 매개변수 limit가 employeesList에서 출력하고자 하는 개수를 나타냄.
	public List<Employees> selectEmployeesListByLimit(int limit){
		System.out.println("selectEmployeesListByLimit param limit"+ limit);
		List<Employees> list = new ArrayList<Employees>();
		Connection conn =null;
		PreparedStatement stmt = null;
		String sql ="select emp_no, birth_date, first_name, last_name, gender, hire_date from employees limit ?";
		ResultSet rs = null;
		
		try {
			conn = DBHelper.getConnection();
			stmt =conn.prepareStatement(sql);
			stmt.setInt(1,limit);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.close(conn, stmt, rs);
		}
		return list;
	}
	
	
	//employees 테이블의 모든 사원의 수를 구해주는 메소드 
	public int selectEmployeesCount() {
		int count = 0;
		final String sql = "SELECT COUNT(*) FROM employees";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) { //iterator가 구현되어있는 객체.
				count = rs.getInt("COUNT(*)");
			}
		}catch(Exception e) {	//자바의 변수 생명주기는 { 블럭 } 내에서만.
			e.printStackTrace(); //예외 발생시 예외를 콘솔창에 출력해줌.
		}finally {
			DBHelper.close(conn, stmt, rs);
		}
		System.out.println(count);
		return count;
		}
	
	
	}

