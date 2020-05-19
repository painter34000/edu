package co.yedam.app.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/MemberInsert.do")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 응답 결과 인코딩
		response.setContentType("text/html; charset=UTF-8"); // 한글 출력되도록
		// 요청 정보 인코딩
		request.setCharacterEncoding("utf-8"); // GET방식은 setCharacterEncoding 할 필요없음
		// 1 파라미터 받기
		
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd");
//		String name = request.getParameter("name");
//		String gender = request.getParameter("gender");
//		String religion = request.getParameter("religion");
//		String introduction = request.getParameter("introduction");
		// 자기소개, 이름, 종교
		
		// 취미
		String hobbys = request.getParameter("hobby");
		String[] hobby = request.getParameterValues("hobby");
		hobbys = "";
		if (hobby != null)
			for (String temp : hobby) {
				hobbys += temp + ",";
			}
		
		//2. 서비스 로직 처리(DAO)
		MemberDAO memberDAO = new MemberDAO();
		MemberVO member = new MemberVO();
		
//		member.setId(id);
//		member.setPwd(pwd);
//		member.setName(name);		
//		member.setGender(gender);
//		member.setReligion(religion);
//		member.setIntroduction(introduction);
		
		try {
			BeanUtils.copyProperties(member, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		member.setHobby(hobbys);
		
		
		int r = memberDAO.memberInsert(member);
		
//		PrintWriter out = response.getWriter();
//		out.print("<br>id =" + id);
//		out.print("<br>pwd =" + pwd);
//		out.print("<br>name =" + name);
//		out.print("<br>hobby =" + hobbys);
//		out.print("<br>gender =" + gender);
//		out.print("<br>religion =" + religion);
//		out.print("<br>introduction =" + introduction);
//		out.print("<br>처리된 건수 : " + r);
		
		//3.회원 목록 이동 /include, forward, sendRedirect
		String contextPath = getServletContext().getContextPath();
		response.sendRedirect(contextPath + "/MemberList.do");
//		request.getRequestDispatcher("/MemberList.do").forward(request, response);
		

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 응답 결과 인코딩
		response.setContentType("text/html; charset=UTF-8"); // 한글 출력되도록
		// 요청 정보 인코딩
		// 1 파라미터 받기
//		String querystring = request.getQueryString();
//		response.getWriter().append("질의문자열=" + querystring);
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// 자기소개, 이름, 종교
		// 취미
		String[] hobby = request.getParameterValues("hobby");
		String hobbys = "";
		if (hobby != null)
			for (String temp : hobby) {
				hobbys += temp + ",";
			}
		request.getParameterValues("hobby");
		PrintWriter out = response.getWriter();
		out.print("<br>id = " + id); //
		out.append("<br>pwd = " + pwd)//
		.append("<br>hobby = " + hobbys);
	}
}
