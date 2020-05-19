<%@page import="co.yedam.app.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
</head>
<body>
<%--request.setAttribute("id","홍길동") --%>
<c:set var="id" value="홍길동" scope="request"/>

<%-- <%MemberVO member = new MemberVO(); 
	vo.setName("김유신");
	session.setAttribute("member", "vo");
%> --%>
<c:set var="member" value="<%=new MemberVO() %>" scope="session"/>
<c:set value="김유신" target="${member }" property="name" />

<%-- <%out.print(request.getAttribute("id")) %> --%>
${id }<br>

<%-- <%out.print(((MemberVO)session.getAttribute("member")).getName()); %> --%>
${ member.name}<br>

</body>
</html>