<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
	<!-- select first_name, last_name, salary, hire_date from employees order by first_name 부서별 급여가 제일 높은사람의 정보-->
	<!-- select department_id, max(salary) as MAXSAL
	from employees 
	where department_id is not null 
	group by department_id 
	order by department_id -->
	<sql:query var="rs" dataSource="jdbc/myhr">	
	with s AS(select department_id, max(salary) MAXSAL 
			from employees 
			where department_id is not null
			group by department_id 
			order by department_id
			)
select 
	e.first_name, 
	e.last_name, 
	e.salary,
	e.department_id,
	d.department_name
		from employees e, 
			 s
			, departments d
where e.department_id = s.department_id 
	and e.salary = s.maxsal
	and e.department_id = d.department_id
</sql:query>
	<table border="1">
		<tr>
			<c:forEach items="${rs.columnNames }" var="columnName">
				<td>${columnName }</td>
			</c:forEach>
		</tr>
		<c:forEach items="${rs.rows }" var="vo">
			<tr>
				<td>${vo.first_name }</td>
				<td>${vo.last_name }</td>
				<td>${vo.salary}</td>
				<td>${vo.department_id }</td>
				<td>${vo.department_name }</td>

				<%-- <td>${vo.first_name }</td>
				<td>${vo.last_name }</td>
				<td>${vo.salary }</td>	 --%>
				<td><fmt:formatDate value="${vo.hire_date}"
						pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>