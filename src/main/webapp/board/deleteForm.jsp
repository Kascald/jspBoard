<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제확인</title>
</head>
<body>

    <% 
        int num = Integer.parseInt(request.getParameter("num"));
    %>

    <form action="delete.jsp">
        <input type="hidden" value="<%=num%>" name="num">
        삭제하시겠습니까? <br><br>
        <input type="submit" value="예">
        <a href="<c:url value="/board/boardDetail.jsp?num=<%=num%>"/>"><button>취소</button></a>
        <!-- TODO: 삭제를 클릭할경우 [예] 버튼 하나에서 [아니오] 버튼 추가 -->
    </form>

</body>
</html>