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
</style>
<script>
function updateProduct(bookCode){
	location.href="productUpdate.do?bookCode="+bookCode;
}
	function deleteCheck(bookCode) {
		if (confirm("삭제하시겠습니까?") == true) {
			location.href = "productDelete.do?bookCode=" + bookCode;
		} else {
			return false;
		}
	}
</script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<div align="center">
	<h3>상세 내용보기</h3>
	<form id="frm" action="update.do" method="post"></form>
	<table border="1" width="900" height="1000">
		<tr>
			<td rowspan="10"><img width="" height=""
				src="upload/${product.bookImage }"></td>
			<th width="100">카테고리</th>
			<td><input value="${product.category }">
			<td>
		</tr>
		<tr>
			<th>북코드</th>
			<td><input name="bookCode" value="${product.bookCode }"></td>
		</tr>
		<tr>
			<th>도서명</th>
			<td><h5>
					<textarea> ${product.bookName}</textarea>
				</h5></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea> ${product.contents }</textarea></td>
		</tr>
		<tr>
			<th>저자</th>
			<td><input value="${product.writer }"></td>
		</tr>

		<tr>
			<th>정가</th>
			<td><input value="${product.price }"></td>
		</tr>
		<tr>
			<th>세일여부</th>
			<td><input value="${product.sale }"></td>
		</tr>
		<tr>
			<th>세일가</th>
			<td><input value="${product.salePrice }"></td>
		</tr>
		<tr>
			<th rowspan="1">가격</th>
			<td><input value="${product.price }"></td>
		</tr>

		<tr>
			<th>별점</th>
			<td><c:forEach begin="1" end="${product.likeIt }">
					<div class="bi-star-fill"></div>
				</c:forEach></td>
		</tr>

		<tr>
			<th colspan="3">후기보러가기</th>
		</tr>
	</table>
	<button onclick="updateProduct('${product.bookCode }')">수정</button>
	<button onclick="deleteCheck('${product.bookCode }')">삭제</button>
	<button onclick="location.href='productList.do'">나가기</button>
</div>