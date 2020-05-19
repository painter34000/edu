package co.yedam.app.emp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.emp.EmpDAO;

/**
 * Servlet implementation class EmpSal
 */
@WebServlet("/EmpSal")
public class EmpSal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpSal() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터
		
		//2. 서비스 로직 처리(DAO)
		List<Map<String, Object>> list = EmpDAO.getInstance().selectDeptSal();
		//3. 결과 저장
		request.setAttribute("salList", list); //속성 이름을 salList로 지정
		//4. view페이지로 이동(jsp-forward, do-sendredirect)
		request.getRequestDispatcher("/emp/empSalList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
