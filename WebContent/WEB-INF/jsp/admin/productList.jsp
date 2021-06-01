<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 리스트</title>
</head>
<style>
textarea {
	box-sizing: border-box;
	resize: none;
}
</style>
<body>

	<div align="right" style="width: 90%">
		<button type="button" onclick="location.href='adminPage.do'">홈</button>
		<button type="button" onclick="location.href='productInsertForm.do'">등록</button>
		<button type="button" onclick="location.href=''">삭제</button>
	</div>
	<form id="frm" action="" method="post">
		<input type="hidden" id="id" name="id">
	</form>
	<div align="center">
		<h3>도서 리스트</h3>
		<div style="width: 80%">
			<table class="table" border="1">
				<tr>
					<th width="100">상품명</th>
					<th width="200">이미지</th>
					<th width="50">설명</th>
					<th width="50">정가</th>
					<th width="50">세일여부</th>
					<th width="50">세일가격</th>
					<th width="100">저자</th>
					<th width="80">좋아요</th>
					<th width="140">기능</th>
				</tr>
				<c:forEach items="${productList }" var="vo">
					<tr onclick="formSubmit(${vo.bookCode })">
						<td><input id="name" type="text" value="${vo.bookName }"></td>
						<td><img alt="" src="upload/${vo.bookImage }"></td>
						<td><input id="contents" type="text" value="${vo.contents }"></td>
						<td><input id="price" type="text" value="${vo.price }"></td>
						<td><input id="sale" type="text" value="${vo.sale }"></td>
						<td><input id="salePrice" type="text" value="${vo.salePrice }"></td>
						<td><input id="writer" type="text" value="${vo.writer }"></td>
						<td>${vo.likeIt }</td>
						<td>
							<button type="button" onclick="location.href=''">수정</button>
							<button type="button" onclick="location.href=''">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div>
				<button type="button" onclick="location.href=''">홈</button>
				<button type="button"
					onclick="location.href='producdtInsertForm.do'">등록</button>
				<button type="button" onclick="location.href=''">삭제</button>
			</div>
		</div>
	</div>
</body>
</html>