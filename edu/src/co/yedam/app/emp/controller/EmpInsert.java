package co.yedam.app.emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.emp.DeptDAO;
import co.yedam.app.emp.DeptVO;
import co.yedam.app.emp.EmpDAO;
import co.yedam.app.emp.EmpVO;
import co.yedam.app.emp.JobDAO;
import co.yedam.app.emp.JobVO;

/**
 * Servlet implementation class EmpInsert
 */
@WebServlet("/EmpInsert.do")
public class EmpInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 등록 폼으로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// job
		List<JobVO> jobList = JobDAO.getInstance().selectAll();
		request.setAttribute("jobList", jobList);
		// dept
		// manager(emp)
		List<DeptVO> deptList = DeptDAO.getInstance().selectAll();
		request.setAttribute("deptList", deptList);

		List<EmpVO> empList = EmpDAO.getInstance().selectAll();
		request.setAttribute("empList", empList);
		
		request.getRequestDispatcher("emp/empInsert.jsp").forward(request, response);

	}

	// 등록 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String employee_id = request.getParameter("employee_id");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		String hire_date = request.getParameter("hire_date");
		String job_id = request.getParameter("job_id");
//		String salary = request.getParameter("salary");
//		String commission_pct = request.getParameter("commission_pct");
//		String manager_id = request.getParameter("manager_id");
//		String department_id = request.getParameter("department_id");

		EmpDAO empDAO = new EmpDAO();
		
		EmpVO vo = new EmpVO();
		vo.setEmployee_id(employee_id);
		vo.setFirst_name(first_name);
		vo.setLast_name(last_name);
		vo.setEmail(email);
		vo.setPhone_number(phone_number);
		vo.setHire_date(hire_date);
		vo.setJob_id(job_id);
//		vo.setSalary(salary);
//		vo.setCommission_pct(commission_pct);
//		vo.setManager_id(manager_id);
//		vo.setDepartment_id(department_id);
		empDAO.empInsert(vo);		
		
		String contextPath = getServletContext().getContextPath();
		response.sendRedirect(contextPath + "EmpList.do");
		
	}

}
