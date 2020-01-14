<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <c:forEach var="guestBook" items = "${list}">
       <!-- <fmt:parseDate var = "t" value = "${guestBook.date}"  pattern = "yyyy-MM-dd HH:mm:ss.S"/> --> 
	   <!--   (<fmt:formatDate value="${t}" type="both" dateStyle="short" timeStyle="short"/>)-->
    	<h3>${guestBook.getContent()}</h3>
    </c:forEach>
    
    <a href = "home"> 돌아가기</a>