<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%
      request.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글 등록</title>
</head>
<body>
<form action="regist.jsp" method="post">

    <input type="text" name="title" placeholder="제목을 입력하세요.."><br>
    <input type="text" name="writer" placeholder="작성자"><br>
    <textarea name="content" placeholder="내용을 입력하세요..." cols="22" rows="4"></textarea><br>
    <input type="submit" value="등록">
    <%-- <p>${pageContext.request.contextPath}/list.jsp</p> --%>
</form>
    <a href="<c:url value="/board/list.jsp"/>"><button>취소</button></a>
</body>
</html>