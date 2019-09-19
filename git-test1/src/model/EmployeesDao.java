package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeesDao {
	public int selectEmployeesCount() {
		int count = 0;
		final String sql = "SELECT COUNT(*) FROM employees";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.maria.jdbc.Driver");
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
		return count;
		}
	}

