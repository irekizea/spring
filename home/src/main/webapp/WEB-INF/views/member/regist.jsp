<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>
  <form method = "post">
 <article class = "w-60">
 	<div class="row regtitle">
 		 <h1>회원 가입</h1>
 	</div>
 		
 	<div class = "row-left">
 		<label for="id-input">ID:</label>
 		<input id="id-input" class= " block-item input-item" type = "text" name = "id" required>
 	</div>
 	<div class = "row-left">
 		<label for ="pw-input">pw</label>
 		<input id="pw-input" class= "block-item input-item" type = "password" name = "pw" required>
 	</div>
 	<div class = "row-left">
 		<h4>name</h4>
 		<input class= "w-60 block-item input-item " type = "text" name = "name" required>
 	</div>
 	
 	
 	<div class = "row-left">
 		<h4>address</h4>
 		<input class= "w-40" type = "text" name = "post" size ="6" placeholder = "우편번호">
 		<input  type = "button" value = "우편번호 찾기">
 	</div>
 	
 	<div class ="row-left">
 		<input class="block-item input-item" type = "text" name = "basic_addr" placeholder = "기본주소">
 	</div>
 	
 	<div class = "row-left">
 		<input class="block-item input-item" type = "text" name = "extra_addr" placeholder = "상세주소">
 	</div>
 	
 	<div class = "row-left">
 		<h4>phone</h4>
 		<input type = "tel" name = "phone" required>
 	</div>
 	
 	<div class ="row-center">
 		<input class= "w-30 btn" type = "submit" value = "regist">
 		<input class= "w-30 btn" type="reset" value = "reset">
 	</div>
 
 
 
 </article>
 
 </form>
 
 
 
  <jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>