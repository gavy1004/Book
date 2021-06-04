<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역</title>
</head>
<body>
	<h3>주문내역</h3>
	<div align="center">
		<div style="width: 80%">
			<table class="table" border="1">
				<tr>
					<th width="100">주문번호</th>
					<th width="200">주 문 자</th>
					<th width="150">핸드폰번호</th>
					<th width="150">주  소</th>
					<th width="100">이 메 일</th>
					<th width="100">북 코 드</th>
					<th width="100">수  량</th>
					<th width="100">가  격</th>
					<th width="100">요구사항</th>
				</tr>
				<tr>
					<c:forEach items="${order }" var="vo">
						<tr onclick="select('${vo.code }')">
							<td>${vo.code }</td>
							<td>${vo.name }</td>
							<td>${vo.phone }</td>
							<td>${vo.adress }</td>
							<td>${vo.email }</td>
							<td>${vo.bookCode }</td>
							<td>${vo.qty }</td>
							<td>${vo.price }</td>
							<td>${vo.coments }</td>
						</tr>
					</c:forEach>
			</table>
		</div>
		<div>
			<button type="button" onclick="location.href='orderList.do'">홈</button>
			<button type="button" onclick="location.href=''">삭제</button>
		</div>
	</div>
</body>
</html>