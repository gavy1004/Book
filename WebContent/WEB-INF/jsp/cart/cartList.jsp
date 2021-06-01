<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="center">
	<table border="1">
		<tr>
			<th colspan="2">상품명</th>
			<th>가격</th>
			<th>수량</th>
		</tr>

		<c:forEach items="${cartList }"  var="vo" >
			<tr>
				<th colspan="2"><img src="upload/${vo.bookImage}">${vo.bookName }</th>
				<th>${vo.price }</th>
				<th>${vo.bookQty }</th>
			</tr>

		</c:forEach>
		<c:if test="">
		<tr>
			<th>배송비</th> <th colspan="2"></th>
		</tr>
		</c:if>
		<tr>
			<th>총결제 금액</th> <th colspan="2"></th>
		</tr>
	</table>
</div>