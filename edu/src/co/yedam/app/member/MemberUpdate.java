package co.yedam.app.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberUpdateForm
 */
@WebServlet("/MemberUpdate.do") //타겟 세팅값
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 -> 세션에서 id 받오기
		
		String id = (String) request.getSession().getAttribute("loginId");
		if(id == null) {
			response.sendRedirect("/edu/member/login.jsp");
			return;
		}
		//서비스 로직 처리(회원정보 1건 조회)
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getMember(id);
		//결과 저장
		request.setAttribute("member", vo); //member란 이름으로 조회된 vo를 넘겨주겠다.		
		//뷰페이지로 이동
		request.getRequestDispatcher("member/memberUpdate.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 응답 결과 인코딩
		response.setContentType("text/html; charset=UTF-8"); // 한글 출력되도록
		// 요청 정보 인코딩
		request.setCharacterEncoding("utf-8"); // GET방식은 setCharacterEncoding 할 필요없음
		// 1 파라미터 받기
//				String querystring = request.getQueryString();
//				response.getWriter().append("질의문자열=" + querystring);
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String hobbys = request.getParameter("hobby");
		String gender = request.getParameter("gender");
		String religion = request.getParameter("religion");
		String introduction = request.getParameter("introduction");
		// 자기소개, 이름, 종교
		// 취미
//		String[] hobby = request.getParameterValues("hobby");
//		String hobbys = "";
//		if (hobby != null)
//			for (String temp : hobby) {
//				hobbys += temp + ",";
//			}
		
		//2. 서비스 로직 처리(DAO)
		MemberDAO memberDAO = new MemberDAO();
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setHobby(hobbys);
		member.setGender(gender);
		member.setReligion(religion);
		member.setIntroduction(introduction);
		int r = memberDAO.memberUpdate(member);
		
		PrintWriter out = response.getWriter();
		out.print("<br>id =" + id);
		out.print("<br>pwd =" + pwd);
		out.print("<br>name =" + name);
		out.print("<br>hobby =" + hobbys);
		out.print("<br>gender =" + gender);
		out.print("<br>religion =" + religion);
		out.print("<br>introduction =" + introduction);
		out.print("<br>처리된 건수 : " + r);
	}

}
