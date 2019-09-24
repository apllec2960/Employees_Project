package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TitlesDao {
	
	//titles테이블의 중복값을 제거한 title을 출력하는 메소드
	public List<String> selectTitlesListDistinct(){
		List<String> list = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "SELECT DISTINCT title FROM titles";
		ResultSet rs = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
			stmt= conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("title"));
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
	
	
	//titles테이블의 행의 수를 구하는 메소드
	public int selectTitlesRowCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) cnt FROM titles";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}	
		return count;
}
}
