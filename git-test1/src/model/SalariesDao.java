package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import db.DBHelper;


public class SalariesDao {
	
	//salaries테이블의 salary를 구하는 메소드 (count sum avg max min sdt)
	public Map<String,Long> selectSalariesStatistics(){
		Map<String, Long> map = new HashMap<String, Long>();
		Connection conn = null;
		PreparedStatement stmt =null;
		String sql ="SELECT COUNT(salary), SUM(salary), AVG(salary), MAX(salary), MIN(salary), STD(salary) FROM salaries";
		ResultSet rs = null;
		try {
		 conn =DBHelper.getConnection();
		 stmt = conn.prepareStatement(sql);
		 rs = stmt.executeQuery();
		 if(rs.next()) {
			 map.put("COUNT", rs.getLong("salary"));
			 map.put("SUM", rs.getLong("salary"));
			 map.put("AVG", rs.getLong("salary"));
			 map.put("MAX", rs.getLong("salary"));
			 map.put("MIN", rs.getLong("salary"));
			 map.put("STD", rs.getLong("salary"));
		 }
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, stmt, rs);
		}
		return map;
	}
	
	//salaries 테이블의 행의 수를 구하는 메소드
	public int selectSalariesRowCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) cnt FROM salaries";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, stmt, rs);
		}	
		return count;
}
}

