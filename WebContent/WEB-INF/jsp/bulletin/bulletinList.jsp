<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기게시판 리스트</title>
<style>
.table {
	width: 70%;
	text-align: center;
	margin-top: 2%;
	border: 1;
}

#title {
	text-align: left;
	width: 200;
	padding-left: 3%;
}

#title:hover {
	text-decoration: underline;
}
</style>
<script>	
	function select(id){
	location.href = "bulletinSelect.do?id=" + id;
	}
</script>
</head>
<body>
	<div align="center">
		<h3>Review List</h3>
		<br>
		<div style="width: 80%">
			<table class="table">
				<tr>
					<th width="100">NO</th>
					<th>Title</th>
					<th width="150">Writer</th>
					<th width="150">Date</th>
					<th width="100">Hit</th>
				</tr>
				<c:forEach items="${bulletinList }" var="vo">
					<tr onclick="select(${vo.id })">
						<td>${vo.id }</td>
						<td id="title">${vo.title }</td>
						<td>${vo.writer }</td>
						<td>${vo.regDate }</td>
						<td>${vo.hit }</td>
					</tr>
				</c:forEach>
			</table>
			<div>
				<button type="button" onclick="location.href='novelList.do'">홈</button>
				<c:if test="${!empty id }">
				</c:if>
			</div>
		</div>
		<jsp:include page="../common/paging.jsp" flush="true">
			<jsp:param name="firstPageNo" value="${paging.firstPageNo}" />
			<jsp:param name="prevPageNo" value="${paging.prevPageNo}" />
			<jsp:param name="startPageNo" value="${paging.startPageNo}" />
			<jsp:param name="pageNo" value="${paging.pageNo}" />
			<jsp:param name="endPageNo" value="${paging.endPageNo}" />
			<jsp:param name="nextPageNo" value="${paging.nextPageNo}" />
			<jsp:param name="finalPageNo" value="${paging.finalPageNo}" />
		</jsp:include>
	</div>
</body>
</html>