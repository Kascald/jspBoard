<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page  import="com.mysite.board.*"%>
<%@ page  import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%

    request.setCharacterEncoding("UTF-8");
	BoardDAOImpl dao = new BoardDAOImpl();
	List<BoardVO> ls = dao.findAll();
	pageContext.setAttribute("ls", ls);
	System.out.println(ls);
%>
<!DOCTYPE html>
<html>
<%-- <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"> --%>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>list</title>
	</head>
	<%-- <script type="text/javascript">

	let veiwCnt_;
	let artNum_ = document.querySelectorAll(".artnums");
	console.log(artNum_);
	console.log(veiwCnt_);

	if(localStorage.getItem('artNum') && localStorage.getItem('nowCnt')) {
 		var isNowCnt = localStorage.getItem('artNum')
 		var isArtNum = localStorage.getItem('nowCnt')
	}

	console.log("로컬저장소 값 더하기전 테스트 뷰카운트 :" , veiwCnt_);
	console.log("로컬저장소 값 더하기전 테스트 게시글번호 :" ,artNum_);


	</script> --%>
	<body>
		<h1>Board List</h1>
		<a href="../index.jsp">메인으로 가기</a>

		<table border="1">
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
				<c:forEach var="board" items="${ls}">
				<tr>
					<td class = "artnums">${board.num}</td>
					<td><a href="${pageContext.request.contextPath}/board/boardDetail.jsp?num=${board.num}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.regdate}</td>
					<td class= "viewCnt">${board.cnt}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<div>
			<a href="<c:url value="/board/registForm.jsp"/>"><button>글등록</button></a>	
			<p><a href="#"></a></p>
			<p><a href="#"></a></p>
		</div>

		<pre>

		
		
		</pre>
	</body>
</html>