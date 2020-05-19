<%@page import="co.yedam.app.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Form Test</title>
</head>
<body align = "center">
<%MemberVO member = (MemberVO)request.getAttribute("member"); %>
<!-- Navigation bar -->
<%@include file="/common/menu.jsp" %>
<h3>회원정보</h3>
<form action="../MemberUpdate.do" method="post">
ID : <input type="text" name = "id" id="id" readonly="readonly" value="${member.id}"/><br/>
비밀번호 :  <input type = "text" name = "pwd" id="pwd" value="${member.pwd}"><br>
이름 : <input type="text" name = "name" id="name" value="${member.name}"><br>
취미 : 
<input type = "checkbox" name ="hobby" value="h01" checked = "checked"/>등산
<input type = "checkbox" name ="hobby" value="h02" />운동
<input type = "checkbox" name ="hobby" value="h03" />독서
<input type = "checkbox" name ="hobby" value="h04" />여행<br>
성별 : 
<input type="radio" name = "gender" value="m"/>남자 
<input type="radio" name = "gender" value="f"/>여자<br>

종교 : <select name="religion" id="religion">
<option value="r01" <%if( member.getReligion()!=null && member.getReligion().indexOf("r01")>=0) {%>selected="selected"<%} %>>기독교
<option value="r02" <%if( member.getReligion()!=null && member.getReligion().indexOf("r02")>=0) {%>selected="selected"<%} %>>불교
<option value="r03" <%if( member.getReligion()!=null && member.getReligion().indexOf("r03")>=0) {%>selected="selected"<%} %>>천주교
<option value="r04" <%if( member.getReligion()!=null && member.getReligion().indexOf("r04")>=0) {%>selected="selected"<%} %>>무교
</select><br>
자기소개:<br>
<textarea cols="30" rows="10" name="introduction" id="introduction" >
${member.introduction}
</textarea><br>
<input type="submit" value="전송"><input type="reset" value="지우기">

</form>

</body>
</html>