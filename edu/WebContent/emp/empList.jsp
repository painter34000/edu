<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.yedam.app.emp.myHomeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
</head>
<body>
	<!-- Navigation bar -->
	<%@ include file="/common/menu.jsp"%>	
	<a href="EmpList.do">사원 등록</a>
	
	<h1 align="center">EMP LIST</h1><br>
	<table border="1" align="center">
	<tr>
	<td>Employee_id</td>
	<td>First_name</td>
	<td>Last_name</td>
	<td>Email</td>
	<td>Phone_number</td>
	<td>Hire_date</td>
	<td>Job_Id</td>
	<td>Salary</td>
	<td>Commission_pct</td>
	<td>Manager_id</td>
	<td>Department_id</td>
	</tr>
	<%
		List<myHomeVo> list = (List<myHomeVo>) request.getAttribute("list"); 
		for(myHomeVo vo : list) {
	%>
	
	<tr>
	<td><%=vo.getEmployee_id() %></td>
	<td><%=vo.getFirst_name() %></td>
	<td><%=vo.getLast_name() %></td>
	<td><%=vo.getEmail() %></td>
	<td><%=vo.getPhone_number() %></td>
	<td><%=vo.getHire_date() %></td>
	<td><%=vo.getJob_id() %></td>
	<td><%=vo.getSalary() %></td>
	<td><%=vo.getCommission_pct() %></td>
	<td><%=vo.getManager_id() %></td>
	<td><%=vo.getDepartment_id() %></td>
	</tr>
	<%} %>
	</table>
</body>
</html>