<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.mysite.board.*"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="dao" class="com.mysite.board.BoardDAOImpl" />
<% 
request.setCharacterEncoding("UTF-8");
int num = Integer.parseInt(request.getParameter("num")); 
BoardVO vo = dao.selectOne(num);
pageContext.setAttribute("vo", vo);

/* response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Expires", "0"); // Proxies. */

%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>글내용</title>
  </head>

<%-- <script type="text/javascript">

	<c:set var="board" scope="request" value="<%=vo%>"/>
	<c:out value="${board}" />

var nowCnt = document.querySelector("cnt");
const articleNumber = document.querySelector("artnum");

console.log(nowCnt);
console.log(articleNumber);

window.onpageshow = function(event) {
    if ( event.persisted || (window.performance && window.performance.navigation.type == 2)) {
        // Back Forward Cache로 브라우저가 로딩될 경우 혹은 브라우저 뒤로가기 했을 경우
        // 이벤트 추가하는 곳
        localStorage.setItem('artNum',articleNumber);
        localStorage.setItem('nowCnt',nowCnt);

        console.log('back button event');
    }
}
</script> --%>

  <body>
    <h3>글 정보</h3>
    <p class = "artnum">번호:${vo.num}</p>
    <p class = "title">제목:${vo.title}</p>
    <p class = "writer">작성자:${vo.writer}</p>
    <p class = "content">내용:${vo.content}</p>
    <p class = "regdate">등록일자:${vo.regdate}</p>
    <p class = "cnt">조회수:${vo.cnt}</p>
    <br>

    <a href="<c:url value="/board/list.jsp"/>"><button>글 목록</button></a>
    <a href="<c:url value="/board/editForm.jsp?num=${vo.num}"/>"><button>수정</button></a>
	  <a href="<c:url value="/board/deleteForm.jsp?num=${vo.num}"/>"><button>삭제</button></a>
  </body>
</html>



     <%-- FIXME: 브라우저의 뒤로가기 버튼 클릭시 조회수가 증가하지 않음!!! --%>