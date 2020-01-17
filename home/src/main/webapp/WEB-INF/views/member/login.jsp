<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>
<form action="login" method="post">
<article class = "w-40">

	<div class = "row">
		<h2>로그인</h2>
	</div>
	<div class = "row">
		<input class= "block-item input-item"  type="text" name="id" placeholder="ID" required>
	</div>
	<div class = "row">
		<input class= "block-item input-item" type="password" name="pw" placeholder="Password" required>
	</div>
	<div class = "row-left">
		<input type="checkbox">
				아이디 저장하기
	</div>
	<div class = "row-right">
		<input class ="btn" type="submit" value="Login">
	</div>
	<div class = "row-left">
		<a href="#">아이디 찾기</a><br>
		<a href="#">비밀번호 찾기</a><br>
		<a href="#">회원가입</a>
	
	</div>
	
	<%if(request.getParameter("error") != null){ %>
	<div class="row">
		<h5> <font color = "red"> 입력한 정보가 일치하지 않음</font></h5>
	</div>
	<%} %>
	
</article>
</form>












<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>