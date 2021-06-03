<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script>
	function formCheck() {
		if (frm.firstName.value == "") {
			alert("이름을 확인해 주세요");
			return false;
		}
		if (frm.lastName.value == "") {
			alert("이름을 확인해 주세요");
			return false;
		}
		if (frm.address.value == "") {
			alert("주소를 입력하세요.");
			return false;
		}
		if (frm.phone.value == "") {
			alert("전화번호를 입력하세요.");
			return false;
		}
		if (frm.email.value == "") {
			alert("이메일을 입력하세요.");
			return false;
		}
		
		frm.submit();
	}
</script>
<!-- Checkout Section Begin -->
<section class="checkout spad">
	<div class="container">
		<div class="row">
		</div>
		<div class="checkout__form">
			<h4>주문 정보 작성</h4>
			<form  name="frm" action="orderInsert.do" method="post">
				<div class="row">
					<div class="col-lg-8 col-md-6">
						<div class="row">
							<div class="col-lg-6">
								<div class="checkout__input">
									<p>
										성<span>*</span>
									</p>
									<input type="text" name="firstName">
								</div>
							</div>
							<div class="col-lg-6">
								<div class="checkout__input">
									<p>
										이름<span>*</span>
									</p>
									<input type="text" name="lastName">
								</div>
							</div>
						</div>
						<div class="checkout__input">
							<p>
								주소<span>*</span>
							</p>
							<input type="text" placeholder="도로명 주소"
								class="checkout__input__add" name="address"> <input type="text"
								placeholder="나머지 주소" >
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="checkout__input">
									<p>
										전화번호<span>*</span>
									</p>
									<input type="text" name="phone">
								</div>
							</div>
							<div class="col-lg-6">
								<div class="checkout__input">
									<p>
										Email<span>*</span>
									</p>
									<input type="text" name="email">
								</div>
							</div>
						</div>
						<div class="checkout__input">
							<p>
								주문 메모
							</p>
							<input type="text" placeholder="배송시 요청사항" name="coments">
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="checkout__order">
							<h4>주문 내역</h4>
							<div class="checkout__order__products">
								Products <span>Total</span>
							</div>

							<ul>
								<c:set var="sum" value="0" />
								<c:forEach items="${cartList }" var="vo" varStatus="status">
									<li>${vo.bookName }<span> <c:if
												test="${vo.sale eq 'Y'}">
												<c:set var="sum" value="${sum + vo.ssum}" />
												<td class="shoping__cart__total"><fmt:formatNumber
														type="currency" value="${vo.ssum }"></fmt:formatNumber></td>
											</c:if> <c:if test="${vo.sale eq 'N'}">
												<c:set var="sum" value="${sum + vo.sum}" />
												<td class="shoping__cart__total"><fmt:formatNumber
														type="currency" value="${vo.sum }"></fmt:formatNumber></td>
											</c:if>
									</span>
									</li>
								</c:forEach>
							</ul>

							<div class="checkout__order__total">
								Total <span><fmt:formatNumber type="currency"
										value="${sum }"></fmt:formatNumber></span>
							</div>
							<button type="button" onclick="formCheck()" class="site-btn">결제 하기</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
<!-- Checkout Section End -->