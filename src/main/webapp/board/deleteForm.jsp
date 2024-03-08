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
        pageContext.setAttribute("num",num);
    %>

    <form action="delete.jsp">
        <input type="hidden" value="<%=num%>" name="num">
        삭제하시겠습니까? <br><br>
        <input type="submit" value="예">
   
    </form>
     <a href="${pageContext.request.contextPath}/list.jsp"><button>취소</button></a>
     <%-- FIXME: 취소버튼으로 뒤로가기 시 조회수가 같이 증가함!!! --%>

</body>
</html>