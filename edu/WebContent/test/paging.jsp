<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>

<head>
<title>edu/test/paging.jsp</title>
<style>
.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border-radius: 5px;
}

.pagination a:hover:not(.active) {
  background-color: #ddd;
  border-radius: 5px;
}
</style>
<script>
function gopage(p){
	location.href="paging.jsp?p="+p
}
</script>

</head>
<body>
<h3>페이징 테스트</h3>
<my:paging st="1" ed="5" p="${param.p }"></my:paging>
<my:paging  ed="10" p="${param.p }"></my:paging>
<my:deptSelect></my:deptSelect>
</body>
</html>