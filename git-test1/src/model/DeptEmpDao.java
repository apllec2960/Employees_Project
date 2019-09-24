package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBHelper;

public class DeptEmpDao {
	//deptEmp 테이블의 행의수를 구하는 메소드
		public int selectDeptEmpRowCount() {
			int count = 0;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "SELECT COUNT(*) cnt FROM dept_emp";
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
