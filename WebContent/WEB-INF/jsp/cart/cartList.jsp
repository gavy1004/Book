<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Shoping Cart Section Begin -->
<section class="shoping-cart spad">
	<div class="container">
		<form id="frm" action="cartUpdate.do" method="post">
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
									<input type="hidden" id="bookCode" name=""bookCode" value="${vo.bookCode }">
									<tr>
										<td class="shoping__cart__item"
											onclick="selectNovel('${vo.bookCode }')"><img
											src="upload/${vo.bookImage}">
											<h5>${vo.bookName }</h5></td>

										<c:if test="${vo.sale eq 'Y'}">
											<td id="price_${vo.bookCode }" val="${vo.salePrice }"
												class="shoping__cart__price"><fmt:formatNumber
													type="currency" value="${vo.salePrice }" /></td>
										</c:if>
										<c:if test="${vo.sale eq 'N'}">
											<td id="price_${vo.bookCode }" val="${vo.price }"
												class="shoping__cart__price"><fmt:formatNumber
													type="currency" value="${vo.price }" /></td>
										</c:if>

										<td class="shoping__cart__quantity">
											<div class="quantity">
												<div class="pro-qty">
													<input type="button" value="-" onclick="minus(event)">
													<input type="text" id="qty_${vo.bookCode }" name="cartQty"
														value="${vo.cnt }" onchange="qtyChange('${vo.bookCode }')">
													<input type="button" value="+" onclick="plus(event)">
												</div>
											</div>
										</td>

										<c:if test="${vo.sale eq 'Y'}">
											<c:set var="sum" value="${sum + vo.ssum}" />
											<td id="sum_${vo.bookCode }" val="${vo.ssum }"
												class="shoping__cart__total"><fmt:formatNumber
													type="currency" value="${vo.ssum }"></fmt:formatNumber></td>
										</c:if>
										<c:if test="${vo.sale eq 'N'}">
											<c:set var="sum" value="${sum + vo.sum}" />
											<td id="sum_${vo.bookCode }" val="${vo.sum }"
												class="shoping__cart__total"><fmt:formatNumber
													type="currency" value="${vo.sum }"></fmt:formatNumber></td>
										</c:if>
										<td class="shoping__cart__item__close"><span
											class="icon_close" onclick="cartDelete('${vo.bookCode }')"></span>
										</td>
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
							class="primary-btn cart-btn cart-btn-right"> Delete Cart</a> <a
							href="cartUpdate.do" class="primary-btn cart-btn"><span
							class="icon_loading"></span>
							<button type="submit" value="Update Cart"></button></a>
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
							<li>Total <span id="totalSum"> <fmt:formatNumber
										type="currency" value="${sum }"></fmt:formatNumber>
							</span></li>
						</ul>
						<a href="cartOrder.do" class="primary-btn">결제하기</a>
					</div>
				</div>
			</div>
		</form>
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

	function qtyChange(bookCode) {
		console.log($('#qty_' + bookCode).val(), $('#price_' + bookCode).attr(
				'val'), $('#sum_' + bookCode).val());
		let qty = $('#qty_' + bookCode).val();
		let price = $('#price_' + bookCode).attr('val');
		let sum = price * qty;
		console.log(sum);
		$('#sum_' + bookCode).html(new Intl.NumberFormat('ko-KR', {
			style : 'currency',
			currency : 'KRW'
		}).format(sum));
		$('#sum_' + bookCode).attr('val', sum);

		totalSum();
	}

	function plus(e) {
		e.target.parentNode.childNodes[3].value++; // 플러스 부호를 누를 때 마다 실행이 됨.
		let qty = e.target.parentNode.childNodes[3].value; //변경된 수량
		//금액포맷이 적용이 안된 값을 val이라는 attribute에 지정.
		let price = e.target.parentNode.parentNode.parentNode.parentNode.childNodes[3]
				.getAttribute('val');
		let sum = price * qty;
		//계산된 금액을 val이라는 속성에 넣어서 계산용으로 갖고 있도록 한다.
		e.target.parentNode.parentNode.parentNode.parentNode.childNodes[7]
				.setAttribute('val', sum);
		//실제 화면에 currency를 보여줄 용도로 사용.
		e.target.parentNode.parentNode.parentNode.parentNode.childNodes[7].innerHTML = new Intl.NumberFormat(
				'ko-KR', {
					style : 'currency',
					currency : 'KRW'
				}).format(sum);

		totalSum();

	}

	function minus(e) {
		if (e.target.parentNode.childNodes[3].value == 0)
			return;
		e.target.parentNode.childNodes[3].value--; // 마이너스 부호를 누를 때 마다 실행이 됨.
		let qty = e.target.parentNode.childNodes[3].value; //변경된 수량
		//금액포맷이 적용이 안된 값을 val이라는 attribute에 지정.
		let price = e.target.parentNode.parentNode.parentNode.parentNode.childNodes[3]
				.getAttribute('val');
		let sum = price * qty;
		//계산된 금액을 val이라는 속성에 넣어서 계산용으로 갖고 있도록 한다.
		e.target.parentNode.parentNode.parentNode.parentNode.childNodes[7]
				.setAttribute('val', sum);
		//실제 화면에 currency를 보여줄 용도로 사용.
		e.target.parentNode.parentNode.parentNode.parentNode.childNodes[7].innerHTML = new Intl.NumberFormat(
				'ko-KR', {
					style : 'currency',
					currency : 'KRW'
				}).format(sum);

		totalSum();
	}

	function totalSum() {
		// shoping__cart__total 클래스에 해당하는 전체 리스트를 가져와서 계산하기 위해서..
		let rowTotal = $(".shoping__cart__total");
		let sum = 0;
		for (let i = 0; i < rowTotal.length; i++) {
			console.log(rowTotal[i].innerHTML)
			sum += parseInt(rowTotal[i].getAttribute('val'));
		}
		$('#totalSum').html(new Intl.NumberFormat('ko-KR', {
			style : 'currency',
			currency : 'KRW'
		}).format(sum));
	}
</script>