<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(function(){
		// 로그인 버튼 누를 시 로그인 처리 컨트롤러 이동
		//- 입력된 ID 같이 전송해야함
		$(".login-btn").click(function(){
			
			var text = $(".user-id").val();
			if(!text) return;
			location.href = "login?id="+text;
			
		});		
	
		$(".logout-btn").click(function(){
			location.href = "logout";
 		//	$(location).attr("href", "logout");
		});
		
		
		
		//페이지가 로딩 되면
		connect();

		//페이지 나가기 전 웹소켓 서버 접속을 종료
	//	$(window).on("beforeunload", click(function(){
	//		window.socket.close();//종료코드
	//	});
		
		//전송버튼 처리
		$(".send-btn").click(function(){
			var text = $(".user-input").val();//입력값을 불러오고
			if(!text) return;//미입력시 중단
			window.socket.send(text);//전송
			$(".user-input").val("");//입력창 초기화
		});
		
		//p태그 생성해서 본문에 추가
		function appendMessage(message){
			$("<p>").text(message).appendTo("#chat-content");
		}
		
		function connect(){
			var host = location.host;
			var context = "${pageContext.request.contextPath}";
			var uri = "ws://"+host+context+"/loginchat";
			console.log(uri);
// 			var socket = new WebSocket(uri);//연결코드
			window.socket = new WebSocket(uri);//연결코드
			
// 			연결 시 예약 작업을 설정
			window.socket.onopen = function(){
// 				console.log("서버와 연결되었습니다");
				appendMessage("서버와 연결되었습니다");
			};
			window.socket.onclose = function(){
				console.log("서버와 연결이 종료되었습니다");
// 				console.log("서버와 연결이 종료되었습니다");
				appendMessage("서버와 연결이 종료되었습니다");
			};
			window.socket.onmessage = function(e){
				console.log("메시지가 도착했습니다");
				console.log(e.data);
// 				console.log("메시지가 도착했습니다");
// 				console.log(e.data);
				appendMessage(e.data);
			};
			window.socket.onerror = function(){
				console.log("연결 오류가 발생했습니다");
// 				console.log("연결 오류가 발생했습니다");
				appendMessage("연결 오류가 발생했습니다");
			};
		}
	});	
</script>    

<h1>안녕</h1>

<c:choose>
	<c:when test="${id==null}">
<input type = "text" class = "user-id" placeholder = "아이디써">
<button class = "login-btn"> login</button>
	</c:when>
	<c:otherwise>
<button class ="logout-btn">logout</button>
<hr>


<input type="text" class="user-input">
<button class="send-btn">보내기</button>
	</c:otherwise>
</c:choose>



<div id="chat-content"></div>