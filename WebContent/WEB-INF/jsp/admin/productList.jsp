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
th{
	background-color: #7fad39;
}
</style>
<body>
	<script>
		// 책 제목 클릭시 상세 페이지로 이동
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
	</script>
	<div align="right" style="width: 90%">
		<button type="button" onclick="location.href='adminPage.do'">홈</button>
		<button type="button" onclick="location.href='productInsertForm.do'">등록</button>
	</div>
	<div align="center">
	<div class="col-lg-9" >
		<div class="hero__search">
			<div class="hero__search__form">
				<form action="#">
					<div class="hero__search__categories">
						카테고리 <span class="arrow_carrot-down"></span>
					</div>
					<input type="text" placeholder="">
					<button type="submit" class="site-btn">검색</button>
				</form>
			</div>
		</div>
	</div>
	</div>
	<div align="center">
		<h3>도서 리스트 관리</h3>
		<div style="width: 80%">
			<table class="table" border="1">
				<tr>
					<th width="100">카테고리</th>
					<th width="100">상품명</th>
					<th width="50">정가</th>
					<th width="50">세일여부</th>
					<th width="100">저자</th>
					<th width="80">좋아요</th>
					<th width="140">기능</th>
				</tr>
				<c:forEach items="${productList }" var="vo">
					<tr ${vo.bookCode }>
						<td>${vo.category }</td>
						<td>${vo.bookName }</td>
						<td>${vo.price }</td>
						<td>${vo.sale }</td>
						<td>${vo.writer }</td>
						<td>${vo.likeIt }</td>
						<td>
							<button type="button" onclick="deleteCheck('${vo.bookCode }')">삭제</button>
							<button type="button" onclick="selectNovel('${vo.bookCode }')">상세보기</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
