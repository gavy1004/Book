<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<body>
<div align="center">
	<h3>내 정보 수정</h3>
	<form id="frm" action="memberUpdate.do" method="post">
	<input type="hidden" name = "bookImage" value="${product.bookImage }">		
	<input type="hidden" name="likeIt" value="${product.likeIt }">				
	<table border="1" width="800" height="500">
		<tr>
			<th >ID</th>
			<td><input name="category" value="${y }">
			<td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><h5>
					<textarea name="bookName"> ${f }</textarea>
				</h5></td>
		</tr>
		<tr>
			<th>이름</th>
			<td> <input name="bookCode" value="${f }"></td>
		</tr>
		<tr>
			<th>핸드폰번호</th>
			<td><textarea name="contents"> ${f }</textarea></td>
		</tr>
		<tr>
			<th>email</th>
			<td><input name="writer" value="${product.writer }"></td>
		</tr>
	</table>
	<button type="submit">수정</button>
	<button onclick="deleteCheck('${product.bookCode }')">삭제</button>
	<button onclick="location.href='productList.do'">나가기</button>
	</form>
</div>
</body>
</html>