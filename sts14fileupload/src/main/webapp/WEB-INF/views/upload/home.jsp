<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1> 안녕안녕안녕안녕</h1>
<form action = "./upload3" method = "post" enctype="multipart/form-data">
		<input type = "text" name = "name" placeholder="작성자"><br><br>
		<input type = "file" name = "file" multiple accept="image/*"><br><br>		
		<input type = "submit" value = "잘가">
		
</form>