package co.yedam.app.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.board.BoardDAO;
import co.yedam.app.board.BoardVO;


@WebServlet("/FileDown.do")
public class FileDown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FileDown() {
        super();
        // TODO Auto-generated constructor stub
    }
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		//게시글 번호 파라미터
		String seq = request.getParameter("seq");
		int seq1 =Integer.parseInt(seq);
		
		
		//단건조회해서 파일이름 확인
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(seq1);
		
		
		
		//다운로드
			if(vo.getFilename() != null){
					//응답 헤더 다운로드 설정
					response.reset();
					int filesize = 0;
					String fileName = new String(vo.getFilename().getBytes("utf-8"),
					"iso-8859-1");
					String realPath = "d:/upload/" + vo.getFilename();
					response.setContentType("application/octet-stream");
					response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName+"\"");
					response.setHeader("Content-Transfer-Encoding", "binary");
					//response.setContentLength( filesize );
					response.setHeader("Pragma", "no-cache;");
					response.setHeader("Expires", "-1;");
					
					FileDownloadHelper.copy(realPath, response.getOutputStream());
					
					response.getOutputStream().close();
				}		
				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			doGet(request, response);
	}

}
