<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<h1>cookie</h1>

<h3>id : ${cookie.id }</h3>


<h4>${cookie.id.name}</h4>
<h4>${cookie.id.value}</h4>
<h4>${URLDecoder.decode(cookie.id.value, 'UTF-8'}</h4>

<input type = "text" name = "id" value ="${cookie.id.value}">

<c:if test = "${empty cookie.id}">
	광고 출력
</c:if>


<h3><a href= "create">쿠키 생성</a></h3>
<h3><a href="remove"> 쿠키 제거</a></h3>

