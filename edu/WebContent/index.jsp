
<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index하준원</title>
</head>
<%=application.getRealPath("/") %>
<%//자바 코드는 % 씀 %>
<% //출력시 %= 으로 써야함%>
<%@  include file="/common/menu.jsp" %> <!-- 지시어를 이용한 include -->
<%-- request.getRequestDispatcher("/common/menu.jsp").include(request, response); --%>
<%-- <jsp:include page="/common/menu.jsp"/> --%>
<body>
<h1>PC버전 입니다</h1>
환영<br>
현재 시간${today}<br>
<% //request.getRequestDispatcher("BoardList.do").forward(request, response); %>
<%-- <jsp:forward page="MemberList.do"/> --%>
<%out.print(getServletContext().getRealPath("/")); %>
</body>
</html>