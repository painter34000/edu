package co.yedam.app;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.common.Device;


/**
 * Servlet implementation class HomeServ
 */
@WebServlet({ "/index.do", "/home.do" })
public class HomeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//dao
		Date date = new Date();
		request.setAttribute("today", date);  //name = today로 date값을 받음
		//디바이스에 따라서 모바일 페이지로 이동
		String device = Device.getDevice(request);
		String page = "";
		if(device.contentEquals(Device.IS_MOBILE))
			page = "/mobile/index.jsp";
		else
			page = "/index.jsp";
		request.getRequestDispatcher(page)  //index페이지로 넘겨줌
		.forward(request, response);		
		
	}

}
