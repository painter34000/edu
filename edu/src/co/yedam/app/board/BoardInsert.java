package co.yedam.app.board;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import co.yedam.app.common.FileRenamePolicy;

/**
 * Servlet implementation class BoardInsert
 */
@WebServlet("/BoardInsert.do")
@MultipartConfig(location = "d:/upload")
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	public BoardInsert() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); // 한글 출력되도록
		request.setCharacterEncoding("utf-8"); // GET방식은 setCharacterEncoding 할 필요없음

		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		// 파라미터 받기
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String id = request.getParameter("id");
		String filename = request.getParameter("filename");

		// 첨부파일 처리
		Part part = request.getPart("filename");
		String fileName = getFileName(part);
		String path = "d:/upload";
		if (fileName != null && !fileName.isEmpty()) {
			//중복 파일 처리
			File f = FileRenamePolicy.rename(new File(path, fileName));
			part.write(f.getAbsolutePath()); // 업로드폴더에 파일 저장
			vo.setFilename(f.getName()); // 파일명을 vo 담기
		}
		// 서비스 로직 처리
		dao.BoardInsert(vo);

		// 등록처리
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setId(id);

		dao.BoardInsert(vo);
		// 목록으로 페이지 이동
		String contextPath = getServletContext().getContextPath();
		response.sendRedirect(contextPath + "/BoardList.do");

	}

	private String getFileName(Part part) throws UnsupportedEncodingException {
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	private String readParameterValue(Part part) throws IOException {
		InputStreamReader reader = new InputStreamReader(part.getInputStream(), "utf-8");
		char[] data = new char[512];
		int len = -1;
		StringBuilder builder = new StringBuilder();
		while ((len = reader.read(data)) != -1) {
			builder.append(data, 0, len);
		}
		return builder.toString();
	}
}
