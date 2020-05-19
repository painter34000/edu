package co.yedam.app.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.yedam.app.common.ConnectionManager;

/*
 * DAO : Data Access Object (DB처리)
 */
public class DeptDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//싱글톤  : static 필드
	static DeptDAO instance;	
	public static DeptDAO getInstance() {
		if (instance == null)
			instance = new DeptDAO();
		return instance;
	}
	
	//등록
	public void deptInsert(DeptVO vo) {		
		try {
			conn = ConnectionManager.getConnnect();
			//트랙잭션 모드 변경(autocommit 해제)
			conn.setAutoCommit(false);
			String sql = " insert into hr.departments(department_id, "
				 	+    " department_name, manager_id, location_id)"
					+    " values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getDepartment_id());
			pstmt.setString(2, vo.getDepartment_name());
			pstmt.setString(3, vo.getManager_id());
			pstmt.setString(4, vo.getLocation_id());
			
			pstmt.executeUpdate();

			conn.commit();  //정상실행이면 커밋
			
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();  //에러나면 롤백
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//수정
	public void deptUpdate(DeptVO vo) {		
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " UPDATE hr.departments set      "
				 	+    " department_name = ?, "
				 	+    "        manager_id = ?,      "
				 	+    "        location_id = ?      "
				 	+    "  WHERE department_id = ?    ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getDepartment_name());
			pstmt.setString(2, vo.getManager_id());
			pstmt.setString(3, vo.getLocation_id());
			pstmt.setString(4, vo.getDepartment_id());
			pstmt.executeUpdate();			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//5. 연결해제 
			ConnectionManager.close(conn);
		}
	}
	
	//삭제
	public void deptDelete(String department_id) {		
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " DELETE FROM hr.departments  "
				 	+    "  WHERE department_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, department_id);
			pstmt.executeUpdate();			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//5. 연결해제 
			ConnectionManager.close(conn);
		}
	}
	
	//단건조회
	public DeptVO getDept(String department_id) {
		DeptVO vo = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql ="SELECT department_id, department_name, manager_id, location_id "
					+   "  FROM hr.departments"
					+   " WHERE department_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, department_id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new DeptVO();
				vo.setDepartment_id(rs.getString("department_id"));
				vo.setDepartment_name(rs.getString("department_name"));
				vo.setManager_id(rs.getString("manager_id"));
				vo.setLocation_id(rs.getString("location_id"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			//5. 연결해제 
			ConnectionManager.close(conn);
		}  
		return vo;
	}
	//전체조회
	public ArrayList<DeptVO> selectAll() {
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		DeptVO deptVO = null;
		try {
			conn = ConnectionManager.getConnnect();		
			String sql="select location_id,"
					       + " manager_id,"
					       + " department_name,"
					       + " department_id"
					       + " from hr.departments "
					       + " order by department_id ";
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next() ) {
				deptVO = new DeptVO();
				deptVO.setLocation_id(rs.getString(1));
				deptVO.setManager_id(rs.getString(2));
				deptVO.setDepartment_name(rs.getString(3));
				deptVO.setDepartment_id(rs.getString(4));
				list.add(deptVO);
			}
		} catch(Exception e) {
			System.out.print("selectAll: " + e.getMessage());
		} finally {
			//5. 연결해제 
			ConnectionManager.close(conn);
		}
		return list;
	}

	//전체조회
	public List<Map<String,Object>> selectAllMap() {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try {
			conn = ConnectionManager.getConnnect();			
			String sql = "select * from hr.departments";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			while(rs.next()) {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("departmentId", rs.getInt("department_id"));
				map.put("departmentName", rs.getString("department_name"));
				map.put("managerId", rs.getInt("manager_id"));
				map.put("locationId", rs.getBigDecimal("location_id"));
				list.add(map);
			}			
			//4. disconnect
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//5. 연결해제 
			ConnectionManager.close(conn);
		}
		return list;
	}
	

}
