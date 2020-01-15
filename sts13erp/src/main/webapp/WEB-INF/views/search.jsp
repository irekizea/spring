<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>검색</h1>

<form action="search" method="post">
	<input type = "text" name = "keyword">
	<input type = "submit">
</form>

<c:forEach var = "product" items = "${list }">
	<h3>이름:${product.name} 가격 :${product.price}</h3>
</c:forEach>