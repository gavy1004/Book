<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>주문내역 리스트</h3>
	<form id="frm" action="" method="post">
		<input type="hidden" id="id" name="id">
	</form>
	<div align="center">
		<div style="width: 80%">
			<table class="table" border="1">
				<tr>
					<th width="100">오더코드</th>
					<th width="200">이름</th>
					<th width="150">핸드폰번호</th>
					<th width="100">이메일</th>
				</tr>
				<c:forEach items="${orderList }" var="vo">
					<tr onclick="formSubmit(${vo.ordercode })">
						<td>${vo.ordercode }</td>
						<td>${vo.name }</td>
						<td>${vo.phone }</td>
						<td>${vo.email }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<button type="button" onclick="location.href='novelList.do'">홈</button>
				<button type="button" onclick="location.href=''">삭제</button>
		</div>

	</div>
</body>
</html>