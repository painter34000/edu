<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>

	//JSON -> 자바 스크립에서 객체를 표현하는 방법  :   대괄호[],  중괄호{} 로 표현한다.    배결->[대괄호],   객체->{중괄호} 로 표현한다. 
	var emp = {employee_id: 100, first_name:"King", last_name:"steven"}
	document.write("last_name:" + emp.last_name);
	
	var arr= [
		{employee_id: 100, first_name:"King", last_name:"steven"},
		{employee_id: 101, first_name:"홍", last_name:"길동"},
		{employee_id: 102, first_name:"박", last_name:"기자"}
	]
	document.write("<br>"+ arr[1].last_name);
	
	var emp1 = {emp_id:100, name : "이순신", hobby:["raed","ski:","bow1"]};
	document.writer("<br>emp1.hobby:" + emp1.hobby[0] +"<br>");
	
	//emp1 사원의 첫번째 hobby
//	decument.writer("<br> 취미:"+ emp1.emp_id);
	
	var emp2 = {dept: "개발", emps:[     
		{id:200, name:"홍길동", hobby:["raed","ski:","bow1"]},
		{id:201, name:"김유신"},
		{id:202, name:"장각가"} 
	]}
	
	//사원 이름만 출력
	for(i=0; i<emp2.emps.length; i++){
		document.write("<br>사원 이름만 출력"+emp2.emps[i].name+"<br>");
	}
	//첫번째 사원의 첫번째 , 두번재 취미 출력
	document.writer("<br>첫번째 사원의 두번재 취미 출력ㅁ;"+emp2.emps[0].hobby[1]);
	
	//object->string  <- object 를 string 으로 변환
	var emp3 = JSON.parse(str);
	
	var str=JSON.stefintid
	consode.log(emp);
	console.log(str);
	
	//string ->object
	var str=JSON.stringify(emp);
	consode.log(emp);
	console.log(str);                
	
</script>
</head>
<body>

</body>
</html>