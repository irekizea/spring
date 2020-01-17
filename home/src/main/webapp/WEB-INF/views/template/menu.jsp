<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var = "context" value="${pageContext.request.contextPath}"></c:set>
<c:set var = "login" value = "${not empty id }"></c:set>
<c:set var = "admin" value="${grade == '관리자'}"></c:set>
		 <!--  홈페이지 메뉴를 구현
		 	-주의 : 경로는 절대경로를 사용해야 한다(불려가서 실행되므로)
		 	-명령 : request.getContextPath() 이용시 자동으로 주서 첫부분 구해옴
		  -->
		  
			
        <nav>
            <div class="menu">
                <label for="hamburg">&equiv;</label>
                <input type="checkbox" id="hamburg">
                <a href="${context}" class="menu-item left-menu">홈으로</a>
                <a href="${context}/board/list" class="menu-item left-menu">게시판</a>
                <c:if test="${admin}">
                 	<a href="${context}/member/find" class="menu-item left-menu">회원찾기</a>
                </c:if>
                <c:choose>
                	<c:when test="${login}">
                		<a href="${context}/member/logout" class="menu-item right-menu">로그아웃</a>
                		<a href="${context}/member/info" class="menu-item right-menu">회원정보</a>
                		  <a href="${context}/member/exit" class="menu-item right-menu">회원탈퇴</a>
           		   </c:when>
           		    <c:otherwise>
                 		 <a href="${context}/member/login" class="menu-item right-menu">로그인</a>
                		<a href="${context}/member/regist" class="menu-item right-menu">회원가입</a>
                
                	</c:otherwise>
                </c:choose>
            </div>
        </nav>