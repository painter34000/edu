<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
</head>
<body>
<!-- Navigation bar -->
<%@include file="/common/menu.jsp" %>
<form action="/edu/Login.do" method="post">
<input name="id" placeholder="id"><br>
<input name="pwd" placeholder="pwd" type="password"><br>
<button>로그인</button><br>


</body>
</html>