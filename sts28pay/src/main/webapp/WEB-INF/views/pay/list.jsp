<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1> 결제이력</h1>

<c:forEach var = "pay" items ="${list}">
	<div>
		${pay}
		<a href = "revoke?no=${pay.no}">취소</a>
	
	</div>





</c:forEach>