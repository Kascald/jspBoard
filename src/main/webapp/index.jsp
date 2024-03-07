<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%
	
%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>index</title>
	</head>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<body>
		<h1>Board Home</h1>
		

    <a href="${contextPath}/board/list.jsp">게시판으로 가기</a>
		
		
		<pre>
   JSP 파일(/board/)
   - 메인 페이지(index.jsp)
     게시판 링크(목록 요청)
   - 게시글 목록(list.jsp)
     글쓰기 링크
   - 게시글 등록
     입력폼 응답(registerForm.jsp)
      데이터베이스에 등록 후 list.jsp 리다이렉트(register.jsp)
   - 게시글 보기(boardDetail.jsp?num=10)
     데이터베이스에서 해당 게시글을 찾아 브라우저에 응답
   - 게시글 수정
     입력폼 응답(editForm.jsp?num=10)
         해당 게시글 변경 전 내용 필요
     데이터베이스에 수정 후 boardDetail.jsp 리다이렉트(edit.jsp?num=10) 	  
   - 게시글 삭제
     게시글 삭제 확인(deleteForm.jsp?num=10)
         삭제확인, 취소
     데이터베이스에서 삭제 후 list.jsp로 리다이렉트(delete.jsp?num=10)

 ==> 화면 디자인은 백단 완성 후 (화면을 생각하다 보면 코드에 집중할 수 없음)
		
		
		</pre>
	</body>
</html>