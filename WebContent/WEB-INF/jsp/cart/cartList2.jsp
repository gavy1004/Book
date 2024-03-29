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
								<c:set var="sum" value="0" />
								<c:set var="cnt" value="1" />
								<c:forEach items="${cartList }" var="vo" varStatus="status">
									<tr>
										<td class="shoping__cart__item"
											onclick="selectNovel('${vo.bookCode }')"><img
											src="upload/${vo.bookImage}">
											<h5>${vo.bookName }</h5></td>

										<c:if test="${vo.sale eq 'Y'}">
											<td id="price_${vo.bookCode }" class="shoping__cart__price">${vo.salePrice }</td>
										</c:if>
										<c:if test="${vo.sale eq 'N'}">
											<td id="price_${vo.bookCode }" class="shoping__cart__price">${vo.price }</td>
										</c:if>

										<td class="shoping__cart__quantity">
											<div class="quantity">
												<div class="pro-qty">
													<input type="button" value="-" onclick="minus(event)">
													<input type="text" id="qty_${vo.bookCode }" name ="cartQty" value="${vo.cnt }" onchange="qtyChange('${vo.bookCode }')">
													<input type="button"  value="+" onclick="plus(event)">
												</div>
											</div>
										</td>
										
										<c:if test="${vo.sale eq 'Y'}">
											<c:set var="sum" value="${sum + vo.ssum}" />
											<td id="sum_${vo.bookCode }" class="shoping__cart__total">${vo.ssum }</td>
										</c:if>
										<c:if test="${vo.sale eq 'N'}">
											<c:set var="sum" value="${sum + vo.sum}" />
											<td id="sum_${vo.bookCode }" class="shoping__cart__total">${vo.sum }</td>
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
						<a href="novelList.do" class="primary-btn cart-btn">CONTINUE
							SHOPPING</a> <a href="cartAllDelete.do"
							class="primary-btn cart-btn cart-btn-right"><span
							class="icon_loading"></span>Delete Cart</a>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="shoping__cart__btns"></div>
				</div>
				<div class="col-lg-6"></div>
				<div class="col-lg-6">
					<div class="shoping__checkout">
						<h5>총 금액</h5>
						<ul>
							<li>Total<span id="totalSum"><fmt:formatNumber type="currency"
										value="${sum }"></fmt:formatNumber></span></li>
						</ul>
						<a href="cartOrder.do" class="primary-btn">결제하기</a>
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
		function qtyChange (bookCode) {
			console.log($('#qty_'+bookCode).val(), $('#price_'+bookCode).html(), $('#sum_'+bookCode).html());
			let qty = $('#qty_'+bookCode).val();
			let price = $('#price_'+bookCode).html();
			let sum = price * qty;
			console.log(sum);
			$('#sum_'+bookCode).html(sum);
		}
		function plus(e) {
			console.log(e.target.parentNode.childNodes[3].value++)
			let qty = e.target.parentNode.childNodes[3].value;
			let price = e.target.parentNode.parentNode.parentNode.parentNode.childNodes[3].innerHTML;
			let sum = price * qty;
			console.log(qty+","+price+","+sum);
			e.target.parentNode.parentNode.parentNode.parentNode.childNodes[7].innerHTML = sum;
			totalSum();
			
		}
		function minus(e) {
			console.log(e.target.parentNode.childNodes[3].value--)
			let qty = e.target.parentNode.childNodes[3].value;
			let price = e.target.parentNode.parentNode.parentNode.parentNode.childNodes[3].innerHTML;
			let sum = price * qty;
			console.log(qty+","+price+","+sum);
			e.target.parentNode.parentNode.parentNode.parentNode.childNodes[7].innerHTML = sum;
		}
		function totalSum() {
			let rowTotal = $(".shoping__cart__total");
			let sum = 0;
			for(let i=0; i<rowTotal.length; i++) {
				console.log(rowTotal[i].innerHTML)
				sum += parseInt(rowTotal[i].innerHTML);
			}
			$('#totalSum').html(sum);
		}
	</script>