<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$(function(){
	//입력을 마치면(blur) 비동기통신으로 아이디 유무를 검사
	$("input[name=id]").blur(function(){
		var id = $(this).val();
		$.ajax({
			url:"${pageContext.request.contextPath}/rest/check",
			type:"get",
			data:{ id : id },
			dataType:"text",
			success:function(resp){
				//console.log(resp);
				if(resp === "Y"){//사용중
					$("input[name=id]").next("span").text("사용중인 아이디");
				}
				else if(resp === "N"){//사용가능
					$("input[name=id]").next("span").text("사용 가능합니다");
				}
			}
		});
	});
});
</script>

<h1>아이디 중복 검사 예제</h1>

<input type="text" name="id">
<span></span>