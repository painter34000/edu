<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}
</style>
<%
	String contextPath = getServletContext().getContextPath();
%>
<ul>
	<li><a class="active" href="<%=contextPath%>/index.jsp">Home</a></li>
	<% String loginId = (String)session.getAttribute("loginId"); %>
	<%if(loginId == null){ %>
	<li><a href="<%=contextPath%>/member/login.jsp">로그인</a></li>
	<li><a href="<%=contextPath%>/member/memberInsert.jsp">회원가입</a></li>
	<%}else{ %>
	<li><a href="<%=contextPath%>/Logout.do">로그아웃</a></li>
	<li><a href="<%=contextPath%>/MemberUpdate.do">정보수정</a></li>
	<%} %>
	<li><a href="<%=contextPath%>/MemberList.do">회원목록</a></li>
	<li><a href="<%=contextPath%>/board/boardInsert.jsp">게시판등록</a></li>
	<li><a href="<%=contextPath%>/BoardList.do">게시판목록</a></li>	
	<li><a href="<%=contextPath%>/EmpList.do">사원목록</a></li>
</ul>
