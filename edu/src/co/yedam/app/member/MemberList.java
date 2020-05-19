package co.yedam.app.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberList
 */
@WebServlet("/MemberList.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.파라미터

		// 2.서비스 (DAO 목록 조회)
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.getMemberList();

		// 3.결과출력 or 결과 저장해서 view 포워드
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/member/memberList.jsp").forward(request, response); // 메뉴바와 테이블 함께 보이게 하기 위해 include시켜줌
		
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	

}
