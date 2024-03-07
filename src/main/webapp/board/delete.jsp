<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="dao" class="com.mysite.board.boardDAOImpl"></jsp:useBean>

<%
    int num = Integer.parseInt(request.getParameter("num"));
    dao.delete(num);

%>
<c:redirect url="${pageContext.request.contextPath}/list.jsp"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>