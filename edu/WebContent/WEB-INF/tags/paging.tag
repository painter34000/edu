<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name ="st" %>
<%@attribute name ="ed" required="true"%>
<%@attribute name ="p"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${empty st }">
<c:set var="st" value="1"/>
</c:if>
<c:if test="${empty p }">
<c:set var="p" value="1"/>
</c:if>


<div class="pagingnation">
  <a href="#">&laquo;</a>
  
  <c:forEach begin="${st }" end ="${ed }" var="i">
  	<a onclick="gopage(${i})" href="#" <c:if test="${p==i}"> class="active" </c:if>>${i }</a>
  </c:forEach>
  <a href="#">&raquo;</a>
</div>