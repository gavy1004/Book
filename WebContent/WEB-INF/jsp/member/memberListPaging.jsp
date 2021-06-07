<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.table {
	margin-top: 2%;
	border: 1;
}
</style>
<script type="text/javascript">
function goPage(page) {
	location.href= 'memberList.do?page='+page;
}
</script>
</head>
<body>
	<form id="frm" action="" method="post">
		<input type="hidden" id="id" name="id">
	</form>
	<div align="center">
		<h3>Member List</h3>
		<div style="width: 80%">
			<table class="table">
				<caption>
						<button type="button" onclick="location.href='adminPage.do'">Back</button>
				</caption>
				<tr>
					<th width="100">ID</th>
					<th width="200">Name</th>
					<th width="150">PassWord</th>
					<th width="150">Phone</th>
					<th width="100">Email</th>
				</tr>
				<c:forEach items="${memberList }" var="vo">
					<tr onclick="formSubmit(${vo.id })">
						<td>${vo.id }</td>
						<td>${vo.name }</td>
						<td>${vo.passwd }</td>
						<td>${vo.phone }</td>
						<td>${vo.email }</td>
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