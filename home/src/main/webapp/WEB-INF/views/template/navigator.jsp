<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <!--  네비게이터 -->
    
<!-- 
	반드시 받아야 하는 데이터 : tlype, keyword, pno, count, navisize
 -->
 <%
 	String type = request.getParameter("type");
 	String keyword = request.getParameter("keyword");
 	
 	boolean isSearch = type!= null&& keyword!=null;
 	
 	int pno = Integer.parseInt(request.getParameter("pno"));
 	int count = Integer.parseInt(request.getParameter("count"));
 	int navsize = Integer.parseInt(request.getParameter("navsize"));
	int startBlock = (pno-1)/navsize * navsize +1;
	int pageSize = Integer.parseInt(request.getParameter("pageSize"));
	
	
	int finishblock = startBlock +(navsize-1);
	int pagecount = (count+pageSize)/pageSize;
	
	if(finishblock>pagecount){
		finishblock = pagecount;
// 	System.out.println(request.getRequestURI());
		
	}
 	
 	
 %>
 
 
 


  <ul class="pagination">
  
  
  			<%if(startBlock>1){ %>
  	 			<%if(isSearch){ %>
  	 				<li><a href="<%=request.getRequestURI()%>?type=<%=type%>&keyword=<%=keyword%>&pno=<%=startBlock - 1%>">[이전]</a> </li>
  	 			<%}else{ %>
  	 				<li><a href="<%=request.getRequestURI()%>?pno=<%=startBlock - 1%>">[이전]</a> </li>
				<%} %>
 			 <%} %>
			 <% for(int i=startBlock; i<= finishblock; i++){%>	
			 	<%if(i==pno){ %>
			 			<li class="active" Style="color:blanchedalmond"><%=i %></li>
			 	<%}else {%>
			 			<%if(isSearch){ %>
 	 						<li><a href="<%=request.getRequestURI()%>?type=<%=type%>&keyword=<%=keyword%>&pno=<%=i%>"><%=i%></a></li>
 	 					<%} else { %>
 	 	 					<li><a href="<%=request.getRequestURI()%>?pno=<%=i%>"><%=i%></a></li>
 	 	 				<%} %>
 	 	 		<%} %> 
 	 	 	<%} %>
 	 	 <%if(finishblock<pagecount){ %>
 	 	
 	 		<%if(isSearch){ %>
 	 		<li><a href="<%=request.getRequestURI()%>?type=<%=type%>&keyword=<%=keyword%>&pno=<%=finishblock + 1%>">[다음]</a></li>
 	 	<%} else { %>
 	 	<li><a href="<%=request.getRequestURI()%>?pno=<%=finishblock + 1%>">[다음]</a></li>
 	 	<%} %>
 	 	<%} %>
 	</ul>
 	 	 	
 

 	 	

  	
  	
 	