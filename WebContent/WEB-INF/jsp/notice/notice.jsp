<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- notice.jsp -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>
<style>
.table{
	margin-top: 2%;
	border:1;
}
</style>
<script>
	$(function() {
		CKEDITOR
				.replace(
						'content',
						{
							filebrowserUploadUrl : '${pageContext.request.contextPath }/fileUpload',
							height : '600px',
							width : '800px'
						});
	})

	function noticeUpdate() {
		let id = document.getElementById("cid").innerHTML;
		let title = document.getElementById("ctitle").value;
		let content = document.getElementById("ccontent").value;

		frm.id.value = id;
		frm.title.value = title;
		frm.content.value = content;

		frm.submit();
	}

	function noticeDelete(id) {
		location.href = "noticeDelete.do?id=" + id;
	}
</script>
<div align="center">
	<h3>Notice</h3>
	<form id="frm" action="noticeUpdate.do" method="post">
		<input type="hidden" name="id" id="id" value="${notice.id}">
		<div style="width:800px">
		<table class="table">
		<caption> 
			<button type="button" onclick="history.back();">Back</button>
			<c:if test="${id eq 'admin' }">
				<button type="submit">Update</button>
				<button type="button" onclick="noticeDelete('${notice.id}')">Delete</button>
			</c:if>
		</caption>
			<tr>
				<th>No</th>
				<td id="id">${notice.id}</td>
				<th>Date</th>
				<td>${notice.regDate}</td>
				<th>Hit</th>
				<td>${notice.hit + 1}</td>
			</tr>
			<tr>
				<th>Title</th>
				<td colspan="5"><c:if test="${id ne 'admin' }">
				${notice.title }
			</c:if> <c:if test="${id eq 'admin' }">
						<input type="text" name ="title" id="title" value="${notice.title }">
					</c:if></td>
			</tr>
			<tr>
				<th>Contents</th>
				<td colspan="5"><c:if test="${id ne 'admin' }">
						<textarea name="content" rows="6" cols="90" readonly="readonly">${notice.contents }</textarea>
					</c:if> <c:if test="${id eq 'admin' }">
						<textarea name="content" id="content" rows="6" cols="90">${notice.contents }</textarea>
					</c:if></td>
			</tr>
		</table>
		</div>
	</form>
</div>
</body>
</html>