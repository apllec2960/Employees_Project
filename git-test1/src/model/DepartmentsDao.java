package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Departments;

public class DepartmentsDao {
	
	//departments 테이블의 모든 사원의 수를 구해주는 메소드 
		public int selectDepartmentsRowCount() {
			int count = 0;
			final String sql = "SELECT COUNT(*) FROM departments";
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
	
	//Departments 테이블의 리스트를 출력하는 메소드
	public List<Departments> selectDepartmentsList() {
		List<Departments> list = new ArrayList<Departments>();
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql ="SELECT dept_no, dept_name FROM departments order by dept_no asc";
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Departments departments = new Departments();
				departments.setDeptNo(rs.getString("dept_no"));
				departments.setDeptName(rs.getString("dept_name"));
				list.add(departments);
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
		
}
