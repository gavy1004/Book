<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

</head>
<body>
	<h3>전체회원리스트</h3>
	<form id="frm" action="" method="post">
		<input type="hidden" id="id" name="id">
	</form>
	<div align="center">
		<div style="width: 80%">
			<table class="table" border="1">
				<tr>
					<th width="100">아이디</th>
					<th width="200">이름</th>
					<th width="150">비밀번호</th>
					<th width="150">핸드폰번호</th>
					<th width="100">이메일</th>
				</tr>
				<c:forEach items="${memberList }" var="vo">
					<tr onclick="formSubmit(${vo.id })">
						<td>${vo.id }</td>
						<td>${vo.name }</td>
						<td>${vo.passwd }</td>
						<td>${vo.phone }</td>
						<td>${vo.email }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<button type="button" onclick="location.href='adminPage.do'">홈</button>
				<button type="button" onclick="location.href=''">삭제</button>
		</div>

	</div>
</body>
</html>