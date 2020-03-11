<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <script src= "http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js"></script>
    
    <script>
    	function connect(){
    			var uri = "${pageContext.request.contextPath}/server";
    			window.socket = new SockJS(uri)
    			
    			window.socket.onopen=function(){
    				
    				console.log("안녕");
    			};
    			window.socket.onclose=function(){    				
    				console.log("잘가");
    				
    				};

    			window.socket.onerror=function(){};
    			window.socket.onmessage=function(e){};
    	}
    	
    	function disconnect(){
    			window.socket.close();
    	}
    
    	function sendMessage(text){
    		window.socket.send(text);
    	}
    	function displayMessage(){
    		
    	}
    </script>
    
    
    
<h1>scok.js 쓸거야</h1>