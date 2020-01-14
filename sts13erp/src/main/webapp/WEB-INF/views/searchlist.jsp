<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>1</h1>
<c:forEach var = "product" items = "${list }">
	<h3>이름:${product.name} 가격 :${product.price}</h3>
</c:forEach>
    