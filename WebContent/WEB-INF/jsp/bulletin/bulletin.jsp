<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.table{
	margin-top: 2%;
	width:800px;
	border:1;
}
</style>
</head>
<script>
function noticeDelete(id) {
	location.href = "bulletinDelte.do?id=" + id;
}
</script>
<body>
	<div align="center">
		<h3>Review</h3>
		<form id="frm" action="bulletinUpdate.do" method="post">
			<input type="hidden" name="id" value="${bulletin.id }">
			<table class="table">
				<caption>
					<button type="button" onclick="history.back();">Back</button>
					<c:if test="${id eq bulletin.writer }">
						<button type="submit">Update</button>
						<button type="d">Delete</button>
					</c:if>
				</caption>
				<tr>
					<th height="40">No</th>
					<td id="cid">${bulletin.id }</td>
					<th>Date</th>
					<td>${bulletin.regDate }</td>
					<th>Writer</th>
					<td>${bulletin.writer }</td>
					<th>Hit</th>
					<td>${bulletin.hit +1 }</td>
				</tr>
				<tr>
					<th>책제목</th>
					<td>${bulletin.bookName }</td>
					<th height="30">제목</th>
					<td colspan="7"><c:if test="${id eq bulletin.writer }">
							<input id="ctitle" name="title" type="text"
								value="${bulletin.title }">
						</c:if> <c:if test="${id ne bulletin.writer }">
							${bulletin.title }
						</c:if></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="7"><c:if test="${id eq bulletin.writer }">
							<textarea id="ccontent" name="content" rows="15" cols="90">${bulletin.content }</textarea>
						</c:if> <c:if test="${id ne bulletin.writer }">		
							<textarea name="content"  rows="15" cols="90" readonly="readonly">${bulletin.content }</textarea>
						</c:if></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>