package co.yedam.app.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GetAttr")
public class GetAttr extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		HttpSession session = request.getSession();
		
		String charset = (String) context.getAttribute("charset");
		String cart = (String) session.getAttribute("cart");
		String name = (String) request.getAttribute("name");
		out.append("<br>charset = " + charset)
		.append("<br>cart = " + cart)
		.append("<br>name = " + name);
		
	}


}
