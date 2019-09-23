package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Employees;

public class EmployeesDao {
	
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
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
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
	
	
	
	//리스트를 출력해주는 메소드이며, 매개변수 limit가 employeesList에서 출력하고자 하는 개수를 나타냄.
	public List<Employees> selectEmployeesListByLimit(int limit){
		System.out.println("selectEmployeesListByLimit param limit"+ limit);
		List<Employees> list = new ArrayList<Employees>();
		Connection conn =null;
		PreparedStatement stmt = null;
		String sql ="select emp_no, birth_date, first_name, last_name, gender, hire_date from employees limit ?";
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
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
	
	
	//employees 테이블의 모든 사원의 수를 구해주는 메소드 
	public int selectEmployeesCount() {
		int count = 0;
		final String sql = "SELECT COUNT(*) FROM employees";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) { //iterator가 구현되어있는 객체.
				count = rs.getInt("COUNT(*)");
			}
		}catch(Exception e) {	//자바의 변수 생명주기는 { 블럭 } 내에서만.
			e.printStackTrace(); //예외 발생시 예외를 콘솔창에 출력해줌.
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace(); //예외 발생시 예외를 콘솔창에 출력해줌.
			}
		}
		System.out.println(count);
		return count;
		}
	
	
	}

