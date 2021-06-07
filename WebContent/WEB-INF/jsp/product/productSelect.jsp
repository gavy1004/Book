<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.bi-star-fill {
	content: "\f586";
	display: inline;
	color: #ffc107 !important;
}

textarea {
	width: 500px;
	align-content: center;
}

.table {
	margin-top: 2%;
	width: 800px;
	border: 1;
}

.selectBox {
	width: 80px;
}
</style>
<script>
	function deleteCheck(bookCode) {
		if (confirm("삭제하시겠습니까?") == true) {
			location.href = "productDelete.do?bookCode=" + bookCode;
		} else {
			return false;
		}
	}

	function reviewPage(bookCode) {
		location.href = "reviewSelect.do?bookCode=" + bookCode;
	}
</script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<div align="center">
	<h3>Detail</h3>
	<form id="frm" action="productUpdate.do" method="post">
		<input type="hidden" name="bookCode" value="${product.bookCode }">
		<input type="hidden" name="bookImage" value="${product.bookImage }">
		<input type="hidden" name="likeIt" value="${product.likeIt }">
		<table class="table">
			<caption>
				<button onclick="reviewPage('${book.bookCode }')">후기조회</button>
			</caption>
			<tr>
				<td rowspan="10"><img width="" height=""
					src="upload/${product.bookImage }"></td>
				<th width="100">카테고리</th>
				<td><select class="selectBox" name="category">
						<c:if test="${product.category eq 'N' }">
							<option value="N" selected="selected">N</option>
							<option value="P">P</option>
						</c:if>

						<c:if test="${product.category eq 'P' }">
							<option value="N">N</option>
							<option value="P" selected="selected">P</option>
						</c:if>
				</select></td>
			</tr>
			<tr>
				<th>북코드</th>
				<td>${product.bookCode }</td>
			</tr>
			<tr>
				<th>도서명</th>
				<td><h5>
						<textarea name="bookName">${product.bookName}</textarea>
					</h5></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents">${product.contents }</textarea></td>
			</tr>
			<tr>
				<th>저자</th>
				<td><input name="writer" value="${product.writer }"></td>
			</tr>

			<tr>
				<th>정가</th>
				<td><input name="price" value="${product.price }"></td>
			</tr>
			<tr>
				<th>세일여부</th>
				<td><select class="selectBox" name="sale">
						<c:if test="${product.sale eq'Y' }">
							<option value="Y" selected="selected">Y</option>
							<option value="N">N</option>
						</c:if>
						<c:if test="${product.sale eq 'N' }">
							<option value="Y">Y</option>
							<option value="N" selected="selected">N</option>
						</c:if>
				</select></td>
			</tr>
			<tr>
				<th>세일가</th>
				<td><input name="salePrice" value="${product.salePrice }"></td>
			</tr>
			<tr>
				<th rowspan="1">가격</th>
				<td><input name="price" value="${product.price }"></td>
			</tr>

			<tr>
				<th>별점</th>
				<td><c:forEach begin="1" end="${product.likeIt }">
						<div class="bi-star-fill"></div>
					</c:forEach></td>
			</tr>
		</table>
		<button type="submit">수정</button>
		<button onclick="deleteCheck('${product.bookCode }')">삭제</button>
		<button type="button" onclick="history.back();">뒤로가기</button>
	</form>
</div>