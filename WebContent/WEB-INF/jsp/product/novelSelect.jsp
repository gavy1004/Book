<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.bi-star-fill {
	content: "\f586";
	display: inline;
	color: #ffc107 !important;
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<div align="center">
	<h3>상세 내용보기</h3>
	<table border="1" width="500" height="500">
		<tr>
			<th colspan="2" align="center">${book.contents }</th>
		</tr>
		<th rowspan="5"><img width="" height=""
			src="upload/${book.bookImage }"></i></th>
		</tr>

		<tr>
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
		<tr>
			<th>가격 : ${book.price }</th>
		</tr>
		<tr>
			<th colspan="2"><c:forEach begin="1" end="${book.likeIt }">
					<div class="bi-star-fill"></div>
				</c:forEach></th>
		</tr>
		<tr>
			<th colspan="2">후기보러가기</th>
		</tr>
	</table>
	<button>장바구니</button>
	<button>바로구매</button>
</div>
