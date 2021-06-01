<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Shoping Cart Section Begin -->
<section class="shoping-cart spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="shoping__cart__table">
						<form id="frm" action="cartUpdate.do" method="POST">
						<table>
							<thead>
								<tr>
									<th class="shoping__product">도서명</th>
									<th>가격</th>
									<th>수량</th>
									<th>총 금액</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							<c:set var = "sum" value = "0" />
								<c:forEach items="${cartList }" var="vo">
									<tr>
										<td class="shoping__cart__item"
											onclick="selectNovel('${vo.bookCode }')"><img
											src="upload/${vo.bookImage}">
											<h5>${vo.bookName }</h5></td>
										<c:if test="${vo.sale eq 'Y'}">
											<td class="shoping__cart__price"><fmt:formatNumber
													type="currency" value="${vo.salePrice }"></fmt:formatNumber></td>
										</c:if>
										<c:if test="${vo.sale eq 'N'}">
											<td class="shoping__cart__price"><fmt:formatNumber
													type="currency" value="${vo.price }"></fmt:formatNumber></td>
										</c:if>
										<td class="shoping__cart__quantity">
											<div class="quantity">
												<div class="pro-qty">
													<input type="text" name="cartQty" value="${vo.cnt }">
												</div>
											</div>
										</td>
										<c:if test="${vo.sale eq 'Y'}">
										<c:set var= "sum" value="${sum + vo.ssum}"/>
											<td class="shoping__cart__total"><fmt:formatNumber
													type="currency" value="${vo.ssum }"></fmt:formatNumber></td>
										</c:if>
										<c:if test="${vo.sale eq 'N'}">
										<c:set var= "sum" value="${sum + vo.sum}"/>
											<td class="shoping__cart__total"><fmt:formatNumber
													type="currency" value="${vo.sum }"></fmt:formatNumber></td>
										</c:if>
										<td class="shoping__cart__item__close"><span
											class="icon_close" onclick="cartDelete('${vo.bookCode }')"></span></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
				
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="shoping__cart__btns">
					<a href="novelList.do" class="primary-btn cart-btn">쇼핑 더하기</a> 
					<a href="cartUpdate.do" class="primary-btn cart-btn cart-btn-right">
					<span class="icon_loading" ></span> <input type="submit" value="카트수정" style="border:0;color: #6f6f6f;background: #f5f5f5;"></a>
				</div>
				</form>
			</div>
			<div class="col-lg-6"></div>
			<div class="col-lg-6">
				<div class="shoping__checkout">
					<h5>총 금액</h5>
					<ul>
						<li>Total <span><c:out value="${sum}"/> </span></li>
					</ul>
					<a href="#" class="primary-btn">결제하기</a>
				</div>
			</div>

		</div>
	</div>
</section>
<!-- Shoping Cart Section End -->
<script>
	// 책 제목 클릭시 상세 페이지로 이동
	function selectNovel(bookCode) {
		location.href = "novelSelect.do?bookCode=" + bookCode;
	}
	function cartDelete(bookCode) {
		location.href = "cartDelete.do?bookCode=" + bookCode;
	}

</script>