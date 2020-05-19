<%@page import="co.yedam.app.board.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>하준원</title>
</head>
<%@include file="/common/menu.jsp"%>
<body>
	<%
		if (loginId != null) {
	%>
	<a href="/edu/board/boardInsert.jsp"></a>
	<%
		}
	%>
	<h3>게시글 목록</h3>
	<table border="1" align="center">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>작성자</td>
			<td>파일명</td>
			
		</tr>
		<%
			ArrayList<BoardVO> boardList = (ArrayList<BoardVO>) request.getAttribute("boardList");
			for (BoardVO boardVO : boardList) {
		%>
		<tr>
			<td><%=boardVO.getSeq()%></td>
			<td><%=boardVO.getTitle()%></td>
			<td><%=boardVO.getContents()%></td>
			<td><%=boardVO.getName()%></td>
			<td><a href="FileDown.do?seq=<%=boardVO.getSeq()%>"><%=boardVO.getFilename()%></a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>