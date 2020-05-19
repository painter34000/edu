<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>/test/path.jsp</title>
</head>
<body>
<h2>경로 연습</h2><br>
<a href="/edu/BoardList.do">게시글 목록</a><br>
<img src="/image/Penguins.jpg">
<%
//application == ServletContext
out.print(application.getRealPath("/"));
application.getRealPath("/");
application.getMajorVersion();
%>
</body>
</html>