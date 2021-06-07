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
		<input type="hidden" id="id" name="id" value="${id }">
		
		
			<table border="1" width="600" height="400">
				<tr>
					<th>I D</th>
					<td><input name="category" value="${member.id }"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><h5>${member.passwd }</h5></td>
				</tr>
				<tr>
					<th>이 름</th>
					<td><input name="bookCode" value="${member.name }"></td>
				</tr>
				<tr>
					<th>핸드폰번호</th>
					<td><input name="contents" ${member.phone }></td>
				</tr>
				<tr>
					<th>email</th>
					<td><input name="writer" value="${member.email }"></td>
				</tr>
			</table>
			<button type="submit">수정</button>
			<button onclick="location.href='productList.do'">나가기</button>
		</form>
	</div>
</body>
</html>