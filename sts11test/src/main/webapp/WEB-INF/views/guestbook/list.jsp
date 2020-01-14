<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <c:forEach var="guestBook" items = "${list }">
    
    	<h3>${guestBook.getContent()}</h3>
    </c:forEach>
    
    <a href = "home"> 돌아가기</a>