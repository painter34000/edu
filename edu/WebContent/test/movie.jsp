<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>movie.jsp</title>

<script >
	//1. xhr	
var xhr = new XMLHttpRequest();
//2. 콜백함수
xhr.onreadystatechange = function(){
	if(xhr.readyState  == 4 && xhr.status ==200){
		var obj = JSON.parse(xhr.responseText);   //string -> 객체
		console.dir(obj);
		for(i=0; i<arr.length; i++){
			dailyBoxOfficeList: Array(10);
		}		
		}
}
//3. 서버연결
xhr.open("get", "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20200517"+id.value	);
//4. 서버전송
xhr.send();

</script>

</head>
<body>
	<button type="button" onclick="getBoxOffice()">박스오피스조회</button>
	<div id="result"></div>

</body>
</html>