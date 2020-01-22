<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>재잘재잘재잘</h1>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(function(){
		//접속버튼을 누르면 웹소켓 서버에 접속
		$(".connect-btn").click(function(){
			var host = location.host;
			var context = "${pageContext.request.contextPath}";
			var uri = "ws://"+host+context+"/echo";
			console.log(uri);
		//	var socket = new WebSocket(uri);
			window.socket = new WebSocket(uri);
			
// 연결시 예약 작업 설정
		window.socket.onopen = function(){
			console.log("반가워");
 		}	
		
		window.socket.onmessage = function(e){
			console.log("연락 왔어");
			console.log(e.data);
		}
		window.socket.onerror=function(){
			console.log("에러났어");
		}
		
		window.socket.onclose = function(){
			console.log("잘가");
		};
			
		});
		
		//종료버튼을 누르면 웹소켓 서버 접속을 종료
		$(".disconnect-btn").click(function(){
			window.socket.close();
		});
		
		
		$(".send-btn").click(function(){
			var text = $(".user-input").val();//입력값을 불러오고
			if(!text) return;//미입력시 중단
			window.socket.send(text);//전송
			$(".user-input").val("");//입력창 초기화
		});
		
	});	
</script>    

<h1>웹소켓 클라이언트</h1>
<button class="connect-btn">접속</button>
<button class="disconnect-btn">종료</button>

<hr>

<input type = "text" class = "user-input">
<button class = "send-btn">보낼게</button>
