<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.mysite.board.*" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <jsp:useBean id="dao" class="com.mysite.board.BoardDAOImpl" />
    <jsp:useBean id="vo" class="com.mysite.board.BoardVO" />
    <jsp:setProperty name="vo" property="*" />

    <% 
    request.setCharacterEncoding("UTF-8"); 
    dao.insert(vo); 
    //request.sendRedirect(request.getContextPath()+"/list.jsp"); 
    %>
      <c:redirect url="/board/list.jsp" />
      <!DOCTYPE html>
      <html>

      <head>
        <meta charset="UTF-8" />
        <title>title</title>
      </head>

      <body></body>

      </html>