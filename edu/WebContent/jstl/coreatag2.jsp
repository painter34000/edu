<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>coretag2</title>
</head>
<body>
	<%-- 	<%
String scoreStr = request.getParameter("score");
int score = Integer.parseInt(scoreStr);
if(score >= 60 ){
	out.print("<font style='color:blue'>pass</font>");
}else{
	out.print("<font style='color:red'>fail</font>");
}
%> --%>
	<!-- el -->
<%-- 	score : ${param.score }점은<br>
	<c:if test="${param.score >=60 }">
	<font style='color: blue'>pass</font><Br>
	</c:if>
	<c:if test="${param.score <60 }">
	<font style='color: red'>fail</font>
	</c:if> --%>
	
	<c:choose>
		<c:when test="${param.score >=90 }">
		<font style='color: blue'>A등급</font><br>
		</c:when>
		<c:when test="${param.score >=80 }">
		<font style='color: blue'>B등급</font><br>
		</c:when>
		<c:when test="${param.score >=70 }">
		<font style='color: blue'>C등급</font><br>
		</c:when>
		<c:when test="${param.score <60 }">
		<font style='color: red'>F등급</font><br>
		</c:when>
		<c:otherwise>
		성적 입력
		</c:otherwise>
	</c:choose>
</body>
</html>