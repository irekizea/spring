<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous">
</script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous">
</script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous">
</script>
<script>
		$(function(){
			$.ajax({
				url : "${pageContext.request.contextPath}/waiting/getlist",
				type : "post",
				success:function(resp){
					console.log(resp.length);
		
		
						$(".waitingrow").empty();
						htmls = "";
						if(resp.length<1){
						htmls+="<h1> 대기 인원 없음</h1>"
						$(".waitingrow").html(htmls);
			
							
						}
						
					
					htmls+='<table>'
					$(resp).each(function(){
						console.log(resp.cusn)				
					})
					
					
					$(".waitingrow").html(htmls);
					
					setTimeout(function(){
						
					},50000);
					
					

				}
			})

		})

</script>

<div>

</div>

<h1>test</h1>
<div class = "wiatingrow">

</div>
