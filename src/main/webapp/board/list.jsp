<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page  import="com.mysite.board.*"%>
<%@ page  import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%
	BoardDAOImpl dao = new BoardDAOImpl();
	List<BoardVO> ls = dao.findAll();
	pageContext.setAttribute("ls", ls);
%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>list</title>
	</head>
	<body>
		<h1>Board List</h1>
		<a href="../index.jsp">메인으로 가기</a>

		<table>
			<thead>
				<tr>
					<td>글번호</td>
					<td>제목</td>
					<td>글쓴이</td>
					<td>등록일</td>
					<td>조회수</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.num}</td>
					<td><a href="/board/detail?num=${list.num}">${list.title}</a></td>
					<td>${list.writer}</td>
					<td>${list.regDate}</td>
					<td>${list.viewCnt}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<div>
			<p><a href="./registerForm.jsp">새글쓰기</a></p>
			<p><a href="#"></a></p>
			<p><a href="#"></a></p>
		</div>

		<pre>

		
		
		</pre>
	</body>
</html>