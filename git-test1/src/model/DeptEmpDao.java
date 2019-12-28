package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import vo.Departments;
import vo.DeptEmp;

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
		
		//deptEmp 부서별 인원수
		public List<DeptEmp> selectDeptEmp(){
			System.out.println("selectDeptEmp 실행 ");
			List<DeptEmp> list = new ArrayList<DeptEmp>();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql ="SELECT d.dept_name, COUNT(de.emp_no) as count FROM dept_emp de INNER JOIN departments d ON d.dept_no = de.dept_no GROUP BY d.dept_no"; 
					//"SELECT dept_no, COUNT(emp_no) as count FROM dept_emp GROUP BY dept_no";
			
			
			try {
				conn = DBHelper.getConnection();
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				
				System.out.println("rs"+rs);
				
				while(rs.next()) {
				DeptEmp deptEmp = new DeptEmp();
				deptEmp.setDepartments(new Departments());
				//deptEmp.setDeptNo(rs.getString("dept_no"));
				deptEmp.getDepartments().setDeptName(rs.getString("d.dept_name"));
				deptEmp.setCount(rs.getInt("count"));
				list.add(deptEmp);
				}
				System.out.println("deptEmp list"+list);
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				DBHelper.close(conn, stmt, rs);
			}
			return list;
		}
}
