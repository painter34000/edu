package co.yedam.app.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//loadOnStartup 쓰기 위해서 urlPatterns 를 앞에 써주고, 숫자값은 우선순위를 나타냄
@WebServlet(urlPatterns = { "/test1.do", "/test2.do" }, loadOnStartup = 1) // http://localhost/edu/test
public class TestServ extends HttpServlet {
	String gName = "홍길동"; //전역변수 모든 스레드에서 공유함
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String lName ="김유신";
		System.out.println("testserv service() 실행");
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().append("<hr>테스트 서블릿 실행<br>");
		
		gName = request.getParameter("name");
		for(int i =0; i<10; i++) {
			response.getWriter().append(gName + "<br>");
			response.getWriter().flush(); //flush == buffer를 client에 바로바로 보냄
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// if(req.getMethod().contentEquals("GET")){ get, post 구분할때 사용
//		}else
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("testserv init 실행");
	}

}
