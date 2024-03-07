<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%
	
%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>index</title>
	</head>
	<body>
		<div id="wrap">
			<h1>글 읽기</h1>
			
			<form action="" method="get">
            <fieldset>
                <legend>글 내용</legend>
                
                <table>
                	<tbody>
						<tr>
							<th scope="row"><label for="num">글번호</label></th>
							<td>
								<input type="text" id="num" value="${list.num}" readonly>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="title">제목</label></th>
							<td>
								<input type="text" id="title" value="${list.title}" readonly>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="writer">글쓴이</label></th>
							<td>
								<input type="text" id="writer" value="${list.writer}" readonly>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="content">내용</label></th>
							<td>
								<textarea name="content" id="content" cols="30" rows="10">${list.content}</textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="regDate">등록일</label></th>
							<td>
								${list.regDate}
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="content">조회수</label></th>
							<td>
								${list.viewCnt}
							</td>
						</tr>


                	</tbody>
                
                </table>
                
                
                <label for=""></label>
                <input type="text" readonly>

                <label for=""></label>
                <textarea name="" id="" cols="30" rows="10"></textarea>


            </fieldset>


            
        </form>
		
		
		</div>

	
	</body>
</html>