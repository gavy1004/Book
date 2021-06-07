<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 리스트</title>
</head>
<style>
textarea {
	width: 200px;
	height: 100px;
}

.hero__search__form {
	align: center;
}

th {
	background-color:;
}

.table {
	margin-top: 2%;
	border: 1;
}
</style>
<body>
	<script>
		//책제목클릭시상세페이지이동
		function selectNovel(bookCode) {
			location.href = "productSelect.do?bookCode=" + bookCode;
		}
		//한건삭제
		function deleteCheck(bookCode) {
			if (confirm("삭제하시겠습니까?") == true) {
				location.href = "productDelete.do?bookCode=" + bookCode;
			} else {
				return false;
			}

		}
		//페이징
		function goPage(page) {
			location.href = 'productList.do?page=' + page;
		}
	</script>
	<div align="center">
		<h3>Book List</h3>
		<div style="width: 80%">
			<table class="table">
				<caption>
					<button type="button"
						onclick="location.href='productInsertForm.do'">등록</button>
					<button type="button" onclick="history.back();">뒤로가기</button>
				</caption>
				<tr>
					<th width="100">BookCode</th>
					<th width="100">BookNAme</th>
					<th width="50">Price</th>
					<th width="50">Sale</th>
					<th width="100">Author</th>
					<th width="80">List It</th>
					<th width="50"></th>
					<th width="50">Detail</th>
				</tr>
				<c:forEach items="${productList }" var="vo">
					<tr ${vo.bookCode }>
						<td>${vo.bookCode }</td>
						<td>${vo.bookName }</td>
						<td>${vo.price }</td>
						<td>${vo.sale }</td>
						<td>${vo.writer }</td>
						<td>${vo.likeIt }</td>
						<td>
							<button type="button" onclick="deleteCheck('${vo.bookCode }')">삭제</button>
						</td>
						<td>
							<button type="button" onclick="selectNovel('${vo.bookCode }')">상세보기</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
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
