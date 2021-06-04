<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeListPaging.jsp</title>
<style>
.table {
	width: 70%;
	text-align: center;
	margin-top: 2%;
	border:1;
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
	function formSubmit(id) {
		frm.id.value = id;
		frm.submit();
	}
	
	function goPage(page) {
		location.href= 'noticeListPaging.do?page='+page;
	}
</script>
</head>
<body>
	<form id='frm' action="noticeSelect.do" method="post">
		<input type='hidden' id='id' name='id'>
	</form>

	<div align="center">
		<h3>Notice List</h3>
		<div style="width: 90%">
			<table class="table">
				<caption align="right">
					<button type="button" onclick="location.href='novelList.do'">Home</button>
					<c:if test="${id eq 'admin' }">
						<button type="button" onclick="location.href='noticeForm.do'">Insert</button>
					</c:if>
				</caption>
				<tr>
					<th style="width: 1%;">NO</th>
					<th>TITLE</th>
					<th style="width: 20%;">DATE</th>
					<th style="width: 1%;">HIT</th>
				</tr>
				<!-- 해당되는 걸렉션 items 한건한건 담아올떄 var -->
				<c:forEach items="${noticeList }" var="vo">
					<tr onclick="formSubmit(${vo.id})">
						<td>${vo.id }</td>
						<td id="title">${vo.title }</td>
						<td>${vo.regDate }</td>
						<td>${vo.hit }</td>
					</tr>
				</c:forEach>
			</table>
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