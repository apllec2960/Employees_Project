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
import vo.Departments;

public class DepartmentsDao {
	
	
		//Departments테이블의 dept_no, dept_name, count(dept_no)를 받아 부서별 인원수를 구해주는 메소드
		public List<Map<String, Object>> selectDepartmentsCountByDeptNo() {
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			Connection conn = null;
			PreparedStatement stmt = null;
			String sql = "select d.dept_no,d.dept_name, count(d.dept_no) cnt from dept_emp de inner join departments d on de.dept_no = d.dept_no where to_date = '9999-01-01' group by d.dept_no order by count(d.dept_no) desc";
			ResultSet rs = null;
			try {
				conn = DBHelper.getConnection();
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while(rs.next()) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("deptNo", rs.getString("d.dept_no"));
					map.put("deptName", rs.getString("d.dept_name"));
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
	
	//departments 테이블의 모든 사원의 수를 구해주는 메소드 
		public int selectDepartmentsRowCount() {
			int count = 0;
			final String sql = "SELECT COUNT(*) FROM departments";
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
	
	//Departments 테이블의 리스트를 출력하는 메소드
	public List<Departments> selectDepartmentsList() {
		List<Departments> list = new ArrayList<Departments>();
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql ="SELECT dept_no, dept_name FROM departments order by dept_no asc";
		ResultSet rs = null;
		
		try {
			conn = DBHelper.getConnection();
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
					DBHelper.close(conn, stmt, rs);
			}	
		return list;
	}
		
}
