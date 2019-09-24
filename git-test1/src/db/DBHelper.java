package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBHelper {
	
	//maria db와 연결시켜주는 메소드
	public static Connection getConnection() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employees","root","java1234");
		return conn;
	}
	
	//try-catch >> finally 코드를 출력해주는 메소드
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		
		if(rs != null) {
			try {
				rs.close();
			}catch(Exception e) {
				e.printStackTrace(); //예외 발생시 예외를 콘솔창에 출력해줌.
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			}catch(Exception e) {
				e.printStackTrace(); //예외 발생시 예외를 콘솔창에 출력해줌.
			}
		}
		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace(); //예외 발생시 예외를 콘솔창에 출력해줌.
			}
		}
		
	}
}
