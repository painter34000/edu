<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Form Test</title>

<script type="text/javascript">
	function idDupCheck() {

		//1.xhr 객체 생성
		var xhttp = new XMLHttpRequest();
		//2. 콜백함수(inreadystatechange) 지정
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4) { //응답완료
				if (this.status == 200) { //정상실행    <--200은 에러메세지 200을 뜻함
					console.log("ajax 요청 완료");
					document.getElementById("result").innerHTML = this.responseText;
				} else {
					document.getElementById("result").innerHTML = this.status
							+ this.statusText
				}
			} else {
				//로딩중  이미지 출력
				document.getElementById("result").innerHTML = "로딩중";
			}
		};
		//3.서버연결
		var param = "id=" + document.frm.id.value;
		xhttp.open("POST", "../IdDupCheck.do?" , true)    //비동기                        false =>동기식으로  변경;
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		//4.서버전송
		xhttp.send(param);
		console.log("ajax 요청 시작");
	}
</script>
</head>
<body align="center">
	<!-- Navigation bar -->
	<%@include file="/common/menu.jsp"%>
	<h3>회원정보</h3>
	<form action="../MemberInsert.do" method="post" name="frm">
		ID : <input type="text" name="id" id="id" onchange="idDupCheck()" /><span
			id="result"></span><br /> 비밀번호 : <input type="text" name="pwd"
			id="pwd"><br> 이름 : <input type="text" name="name"
			id="name"><br> 취미 : <input type="checkbox" name="hobby"
			value="h01" />등산 <input type="checkbox" name="hobby" value="h02" />운동
		<input type="checkbox" name="hobby" value="h03" />독서 <input
			type="checkbox" name="hobby" value="h04" />여행<br> 성별 : <input
			type="radio" name="gender" value="m" />남자 <input type="radio"
			name="gender" value="f" />여자<br> 종교 : <select name="religion"
			id="religion">
			<option value="r01">기독교
			<option value="r02">불교
			<option value="r03">천주교
			<option value="r04">무교
		</select><br> 자기소개:<br>
		<textarea cols="30" rows="10" name="introduction" id="introduction"></textarea>
		<br> <input type="submit" value="전송"><input type="reset"
			value="지우기">

	</form>

</body>
</html>