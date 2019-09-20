package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Departments;

public class DepartmentsDao {
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
