package co.yedam.app.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.yedam.app.common.ConnectionManager;

public class BoardDAO {

   public void BoardInsert(BoardVO vo) {
      Connection conn = null;
      PreparedStatement psmt = null;

      String sql = "insert into board (seq, title, contents, regdt, id, fileName) values ((select nvl(max(seq),0)+1 from board), ?, ?, sysdate, ?, ?)";

      conn = ConnectionManager.getConnnect();
      try {
         psmt = conn.prepareStatement(sql);

         psmt.setString(1, vo.getTitle());
         psmt.setString(2, vo.getContents());
         psmt.setString(3, vo.getId());
         psmt.setString(4, vo.getFilename());
         psmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         ConnectionManager.close(conn);
      }
   }
   
   public ArrayList<BoardVO> getBoardList() {
      ArrayList<BoardVO> list = new ArrayList<BoardVO>();
      
      try {
         Connection conn = null;
         PreparedStatement psmt = null;
         conn = ConnectionManager.getConnnect();
         String sql = "select b.*, m.name from board b join member m on (b.id = m.id) order by seq desc";
         psmt = conn.prepareStatement(sql);
         ResultSet rs = psmt.executeQuery();
         while(rs.next()) {
            BoardVO vo = new BoardVO();
            vo.setContents(rs.getString("contents"));
            vo.setId(rs.getString("id"));
            vo.setRegdt(rs.getString("regdt"));
            vo.setSeq(rs.getInt("seq"));
            vo.setTitle(rs.getString("title"));
            vo.setName(rs.getString("name"));
            vo.setFilename(rs.getString("fileName"));
            list.add(vo);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return list;
   }
   
   public int BoardUpdate(BoardVO vo) {
      int r = 0;
      Connection conn = null;
      PreparedStatement psmt = null;
      try {
         // 1. DB 연결
         conn = ConnectionManager.getConnnect();

         // 2. sql구문 준비
         String sql = "update board set seq =?, title =?, contents=?, regdt = sysdate, id=?";

         psmt = conn.prepareStatement(sql);

         // 3. 실행
         psmt.setInt(1, vo.getSeq());
         psmt.setString(2, vo.getTitle());
         psmt.setString(3, vo.getContents());
         psmt.setString(4, vo.getId());

         r = psmt.executeUpdate();

         // 4. 결과처리
         System.out.println(r + " 건이 등록됨.");

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         // 5. 연결해제
         ConnectionManager.close(conn);
      }

      return r;
   }
   
public BoardVO getBoard(int seq) { //한건조회
      
      BoardVO vo = new BoardVO();
      try {
         Connection conn = null;
         PreparedStatement psmt = null;
         
         conn= ConnectionManager.getConnnect();
         String sql = "select * FROM Board where seq=?";
         
         psmt = conn.prepareStatement(sql);
         psmt.setInt(1, seq);
         ResultSet rs = psmt.executeQuery();
         if(rs.next()) {
            vo.setSeq(rs.getInt("seq"));
            vo.setTitle(rs.getString("title"));
            vo.setContents(rs.getString("contents"));
            vo.setId(rs.getString("id"));
            vo.setFilename(rs.getString("fileName"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
            
      return vo;
      
   }

}