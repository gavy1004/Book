<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.bi-star-fill {
	content: "\f586";
	display: inline;
	color: #ffc107 !important;
}

.table {
	margin-top: 2%;
	border: 1;
	width: 50%;
}

.imgSize {
	width: -webkit-fill-available;
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<div align="center">
	<h3>Book Detail</h3>

	<table class="table" border="1" width="500" height="500">
		<tr>
			<th colspan="2" align="center">${book.contents }</th>
		</tr>
		<tr>
			<th rowspan="5"><img class="imgSize" width="" height=""
				src="upload/${book.bookImage }"></th>
			<th><h3>${book.bookName}</h3></th>
		</tr>

		<tr>
			<th>${book.writer }</th>
		</tr>
		<c:if test="${book.sale eq 'Y' }">
			<tr>
				<th>정가 : ${book.price }</th>
			</tr>
			<tr>
				<th>세일가 : ${book.salePrice }</th>
			</tr>
		</c:if>
		<c:if test="${book.sale eq 'N' }">
			<tr>
				<th rowspan="1">가격 : ${book.price }</th>
			</tr>
		</c:if>

		<tr>
			<th colspan="2">별점 : <c:forEach begin="1" end="${book.likeIt }">
					<div class="bi-star-fill"></div>
				</c:forEach></th>
		</tr>
		<tr>
			<th colspan="2"><button
					onclick="reviewPage('${book.bookCode }')">후기조회</button></th>
		</tr>
	</table>
	<button type="button" onclick="history.back();">Back</button>
	<button onclick="addCart('${book.bookCode}','${id }')">Cart
		Add</button>


</div>

<script>
	function reviewPage(bookCode) {
		location.href = "reviewSelect.do?bookCode=" + bookCode;
	}

	function addCart(bookCode, id) {
		if (id == "") {
			alert('로그인해 주십시오');
		} else {
			$.ajax({
				url : "${pageContext.request.contextPath}/cartInsert.do",
				data : {
					bookCode : bookCode
				},
				success : function(bookCode, id) {
					alert('장바구니에 상품이 추가되었습니다.');
				},
				error : function() {
				}
			});
		}
	}
</script>