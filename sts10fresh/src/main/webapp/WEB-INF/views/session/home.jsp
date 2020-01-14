<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h1>asdfasf</h1>




<c:choose>
	<c:when test= "${id !=null}">login</c:when>
	<c:otherwise>logout</c:otherwise>
	
</c:choose>
<h3> id : ${id}</h3>

<h4><a href="${pageContext.request.contextPath }/session/set"> 세션값 설정</a></h4>
<h4><a href="${pageContext.request.contextPath }/session/remove"> 세션값 제거</a></h4>