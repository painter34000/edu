package co.yedam.app.test;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SetAttr
 */
@WebServlet("/SetAttr")
public class SetAttr extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SetAttr() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		HttpSession session = request.getSession();
		context.setAttribute("charset", "utf-8");
		session.setAttribute("cart", "good1");
		request.setAttribute("name", "홍길동<br>");
//		response.getWriter().append("save attribute");
		request.getRequestDispatcher("/GetAttr").forward(request, response); //forword는 전달이다.
	}
	//session은 브라우저가 종료될때가지 유지가 되고, request는 요청이 들어오고 완료되면 없어진다.

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
