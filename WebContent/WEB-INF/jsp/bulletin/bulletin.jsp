<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>게시글 내용보기</h3>
		<form id="frm" action="bulletinUpdate.do" method="post">
			<input type="hidden" name="id" value="${bulletin.id }">
			<table border="1" width="700" height="300"> 
				<tr>
					<th height="40">순번</th>
					<td id="cid">${bulletin.id }</td>
					<th>작성일자</th>
					<td>${bulletin.regDate }</td>
					<th>작성자</th>
					<td>${bulletin.writer }</td>
					<th>조회수</th>
					<td>${bulletin.hit }</td>
				</tr>
				<tr>
					<th>북코드</th>
					<td>${bulletin.bookCode }</td>
					<th height="30">제목</th>
					<td colspan="7">
						<c:if test="${id eq bulletin.writer }">
							<input id="ctitle" name="title" type="text" value="${bulletin.title }">
						</c:if>
						<c:if test="${id ne bulletin.writer }">
							${bulletin.title }
						</c:if>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="7">
						<c:if test="${id eq bulletin.writer }">
							<textarea id="ccontent" name="content" rows="6" cols="90">${bulletin.content }</textarea>
						</c:if>
						<c:if test="${id ne bulletin.writer }">		
							${bulletin.content }
						</c:if>
					</td>		
				</tr>
			</table>
			<div>
				<button type="button" onclick="location.href='bulletinList.do'">목록보기</button>
				<c:if test="${id eq bulletin.writer }">
					<button type="submit">수정</button>
					<button type="d" >삭제</button>
				</c:if>
			</div>
		</form>
	</div>
</body>
</html>