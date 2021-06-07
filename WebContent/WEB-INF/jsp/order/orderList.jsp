<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역 리스트</title>
<style>
.table {
	margin-top: 2%;
	border: 1;
}
</style>
<script>
	/* 	function formSubmit(code) {
	 frm.id.value = code;
	 frm.submit();
	 } */

	function select(code) {
		location.href = "orderSelect.do?code=" + code;
	}
	function goPage(page) {
		location.href = 'orderList.do?page=' + page;
	}
</script>
</head>
<body>
	<div align="center">
		<h3>All Order List</h3>
		<br>
		<div style="width: 80%">
			<table class="table">
				<caption>
					<button type="button" onclick="history.back();">Back</button>
				</caption>
				<tr>
					<th width="100">OrderCode</th>
					<th width="200">Name</th>
					<th width="150">Phone</th>
					<th width="100">Email</th>

				</tr>
				<c:forEach items="${orderList }" var="vo">
					<tr onclick="select('${vo.code }')">
						<td>${vo.code }</td>
						<td>${vo.name }</td>
						<td>${vo.phone }</td>
						<td>${vo.email }</td>
					</tr>
				</c:forEach>
			</table>
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
</body>
</html>