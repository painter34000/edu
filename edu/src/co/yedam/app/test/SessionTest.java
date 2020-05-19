package co.yedam.app.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/SessionTest")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(); //request 객체로부터 session객체를 얻어 올 수 있다.
		session.setMaxInactiveInterval(20);
		
		out.print("<br>SessionId: " + session.getId());
		out.print("<br>Session 생성시간 : "+ new Date(session.getCreationTime()));
		out.print("<br>Session 마지막 접근시간 : " + new Date(session.getLastAccessedTime()));
		out.print("<br>Session 유지시간 : " + session.getMaxInactiveInterval());		
		//경과시간
		
		long cur = System.currentTimeMillis(); // ==new Date().getTime() 과 동일
		long  dul = (cur - session.getCreationTime())/1000;
		out.print("<br>Session 경과시간 : " + dul + "초");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
