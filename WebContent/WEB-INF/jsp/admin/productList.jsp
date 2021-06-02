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
</style>
<body>
<script>
	// 책 제목 클릭시 상세 페이지로 이동
	function selectNovel(bookCode) {
		location.href = "novelSelect.do?bookCode=" + bookCode;
	}
</script>
	<div align="right" style="width: 90%">
		<button type="button" onclick="location.href='adminPage.do'">홈</button>
		<button type="button" onclick="location.href='productInsertForm.do'">등록</button>
		<button type="button" onclick="location.href=''">삭제</button>
	</div>
	<form id="frm" action="" method="post">
		<input type="hidden" id="id" name="id">
	</form>
	<div align="center">
		<h3>도서 리스트 관리</h3>
		<div style="width: 80%">
			<table class="table" border="1">
				<tr>
					<th width="100">카테고리</th>
					<th width="100">상품명</th>
					<th width="200">이미지</th>

					<th width="50">정가</th>
					<th width="50">세일여부</th>
					<th width="100">저자</th>
					<th width="80">좋아요</th>
					<th width="140">기능</th>
				</tr>
				<c:forEach items="${productList }" var="vo">
					<tr onclick="formSubmit(${vo.bookCode })">
						<td>${vo.category }</td>
						<td>${vo.bookName }</td>
						<td><input id="image" type="image"
							src="upload/${vo.bookImage }"></td>
						<td>${vo.price }</td>
						<td>${vo.sale }</td>
						<td>${vo.writer }</td>
						<td>${vo.likeIt }</td>
						<td>
							<button type="button" onclick="location.href='productDelete.do?code=${vo.bookCode }'">삭제</button>
							<button type="button" onclick="selectNovel('${vo.bookCode }')">상세보기</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
