package co.yedam.app.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 파라미터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// 2. 서비스 로직
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getMember(id);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		// id로 조회, 조회 결과가 없으면 id가 없다.
		if (vo.getId() == null) { // id 오류
			out.print("id 오류!");
		} else if (!vo.getPwd().equals(pwd)) { // pwd 오류
			out.print("pwd 오류!");
		} else { // 로그인 성공
			// 세션에 로그인 여부를 저장
			HttpSession session = request.getSession();
			session.setAttribute("loginId", id);
			session.setAttribute("loginMember", vo);
			request.getRequestDispatcher("common/menu.jsp").include(request,response);
			out.print("로그인 성공");
		}
		// 조회가 된 경우에는 password가 맞는지 검사
		// 로그인
		// 3. 결과 저장

		// 4. 뷰페이지로 포워드

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
