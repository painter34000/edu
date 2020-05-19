<%@page import="java.util.StringTokenizer"%>
<%@page import="sun.util.locale.StringTokenIterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
</head>
<body>
<%
int sum=0;
for(int i=1; i<=10; i++){
	out.print(i+"  |  ");
	sum = sum+i;
}

out.print("<br>합계 : " + sum);
%>
<!-- jstl -->
<c:set var="sum" value="0"/>
<c:forEach begin="1" end="10" var="i">
	${i }<br>
	<c:set var="sum" value="${sum+i }"/>	
</c:forEach>

합계 : ${sum}
<hr>
<%
	String str = "jsp.java.spring";
	StringTokenizer st = new StringTokenizer(str,".");
	out.print("<select>");
	while(st.hasMoreElements()){
		out.print("<option>"+st.nextElement());
	}
	out.print("</select>");
	
%>

<hr>
<select>
<c:forTokens items="jsp.java.spring" delims="." var="op">
<option>${op }
</c:forTokens>

</select>

<c:import url="/common/menu.jsp"></c:import>


<c:url var="boardList" value="../BoardList.do">
<c:param name="title">제목</c:param>
<c:param name="id">작성자</c:param>
</c:url>
<a href="${boardList }">목록검색</a>
<a href="../BoardInsert.do?title=제목&id=작성자">목록검색</a>

</body>
</html>