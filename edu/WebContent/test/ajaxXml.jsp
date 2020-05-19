<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<script type="text/javascript">
	function findName() {
		//1. xhr	
		var xhr = new XMLHttpRequest();
		//2. 콜백함수
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var xmlDoc = xhr.responseXML;  //xml로 받은건 xml로 받아야 된다
				var id = xmlDoc.getElementsByTagName("id")[0].firstChild.nodeValue;
				var name = xmlDoc.getElementsByTagName("name")[0].firstChild.nodeValue;
				result.innerHTML = id +":"+ name;
			}
		}
		//3. 서버연결
		xhr.open("get", "../FindNameXML?id=" + id.value);
		//4. 서버전송
		xhr.send();

	}
</script>
</head>
<body>

	<form action="">
		<input name="id" id="id" onchange="findName()"><span  id="result"></span>
	</form>

</body>
</html>