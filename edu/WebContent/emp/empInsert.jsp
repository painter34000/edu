<%@page import="co.yedam.app.emp.DeptVO"%>
<%@page import="co.yedam.app.emp.myHomeVo"%>
<%@page import="co.yedam.app.emp.JobDAO"%>
<%@page import="co.yedam.app.emp.JobVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employees.html</title>
<style>
.label { display: inline-block; width: 180px;  }
</style>
</head>
<body>
<%@ include file="/common/menu.jsp" %>

<h3 id="top">사원등록</h3>
<form action="EmpInsert.do" method="post" name="frm">
	<div><span class="label">employee_id</span><input type="number" min="300" step="1" name="employee_id"></div>
	<div><span class="label">first_name</span><input name="first_name"></div>
	<div><span class="label">last_name</span><input name="last_name"></div>
	<div><span class="label">email</span><input type="email" name="email"></div>
	<div><span class="label">phone_number</span><input type="text" name="phone_number"></div>
	<div><span class="label">hire_date</span><input type="date" name="hire_date"></div>
	<div><span class="label">job_id</span>
		<select name="job_id">
		<%
			List<JobVO> jobList = (List<JobVO>)request.getAttribute("jobList"); 
				for(JobVO jobVO : jobList){
		%>
				<option value="<%=jobVO.getJob_id()%>"> <%=jobVO.getJob_title()%>   
		<%
   			}
   		%>
		</select></div> 
	<div><span class="label">department_id</span> 
	<%
 		List<DeptVO> deptList = (List<DeptVO>)request.getAttribute("deptList"); 
 			for(DeptVO deptVO : deptList){
 	%>		
	<input type="radio" name="department_id" value="<%=deptVO.getDepartment_id()%>"><%=deptVO.getDepartment_name()%>
	<%
		}
	%>
	</div>
	<div><span class="label">manager_id</span> 
	<select name="manager_id">
		<%
			List<myHomeVo> empList = (List<myHomeVo>)request.getAttribute("empList"); 
				for(myHomeVo empVO : empList){
		%>
				<option value="<%=empVO.getManager_id() %>"> <%=empVO.getFirst_name() %>
		<%} %>
	</select></div>
	<div><button type="submit">등록</button>
	<button type="reset">초기화</button></div>
</form>

</body>
</html>
