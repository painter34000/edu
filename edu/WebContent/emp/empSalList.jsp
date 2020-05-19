<%@page import="co.yedam.app.emp.myHomeVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>SalList</title>
</head>
<%@include file="/common/menu.jsp"%>
<table border="1" align="center">
<tr>
<td>부서번호</td><td>부서명</td><td>급여</td><td>사원수</td><td>평균급여</td>
</tr>
<c:forEach items="${salList }" var="vo">
<tr>
<td>${vo.department_id }</td>
<td>${vo.department_name }</td>
<td align="right"><fmt:formatNumber value="${vo.salary }" pattern="\ #,###.0"/></td>
<td>${vo.cnt }</td>
<td align="right">
<fmt:parseNumber value="${vo.avgsal }" var="numAbg" />
<fmt:formatNumber value="${vo.avgsal }" type="number"/>
</td>
</tr>
</c:forEach>
</table>
</body> 
</html>