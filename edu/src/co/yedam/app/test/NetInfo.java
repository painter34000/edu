package co.yedam.app.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NetInfo
 */
@WebServlet("/NetInfo")
public class NetInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NetInfo() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//클라이언트 정보
		out.print("<br> 클라이언트 IP = " + request.getRemoteAddr());
		//요청 헤더
		out.print("<br> User-Agent = " + request.getHeader("User-Agent"));
		
		//서버의 호스트, 포트
		out.print("<br> 프로토콜 = " + request.getProtocol());
		out.print("<br> 요청  URI = " + request.getRequestURI());
		out.print("<br> 포트  = " + request.getServerPort());
		
		//파라미터
		
		
	}


}
