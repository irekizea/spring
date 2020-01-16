<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action = "regist" method = "post" enctype="multipart/form-data">

		<input type = "text" name = member_id placeholder = "id">
		<input type = "password" name = member_pw placeholder = "pw">
		<input type = "text" name = member_nick placeholder ="nickname">
		<input type = "file" name = "file" multiple accept="image/*"><br><br>		
		<input type = "submit" value = "잘가">
		
</form>