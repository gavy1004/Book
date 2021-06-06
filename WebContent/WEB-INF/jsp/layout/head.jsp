<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Header Section Begin -->
<style>
#user {
	display: inline-block;
}
style>#user {
	display: inline-block;
}
</style>
<header class="header">
	<div class="header__top">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="header__top__left notice">
						<ul>
							<li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
							<li>10만원 이상 구매시 무료배송</li>
						</ul>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="header__top__right">
						<c:if test="${empty id }">
							<div class="header__top__right__auth">
								<a href="memberLoginForm.do"><i class="fa fa-user"></i>로그인</a>
							</div>
							<div class="header__top__right__auth">
								<a href="memberJoinForm.do"><i class="fa fa-user2"></i>회원가입</a>
							</div>
						</c:if>
						<c:if test="${not empty id }">
							<div class="header__top__right__auth">
								<ul>
									<li id="user">${id}님</i></a></li>
									<li id="user"><a href="memberLogOut.do"><i
											class="fa fa-user"></i>로그아웃</a></li>
								</ul>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="header__logo">
					<a href="./index.html"><img src="img/logo.png" alt=""></a>
				</div>
			</div>
			<div class="col-lg-6">
				<nav class="header__menu">
					<ul style="display: flex;">
						<li class="active"><a href="novelList.do">Home</a></li>
						<li><a href="noticeListPaging.do">Notice</a></li>
						<li><a href="bulletinList.do">Review</a></li>
						<li><a href="#">Menu</a>
							<ul class="header__menu__dropdown">
								<li><a href="bestSeller.do">Best Seller</a></li>
								<li><a href="novelMenu.do">Novel</a></li>
								<li><a href="poemMenu.do">Poem</a></li>
							</ul></li>

						<c:if test="${not empty id }">
							<li><a href="#">MyPage</a>
								<ul class="header__menu__dropdown">
									<li><a href="memberUpdate.do">정보수정</a></li>
									<li><a href="orderList.do">주문내역</a></li>
									<li><a href="cartList.do">카트</a></li>
								</ul></li>
						</c:if>

						<c:if test="${id eq 'admin' }">
							<li><a href="adminPage.do">Admin</a>
								<ul class="header__menu__dropdown">
									<li><a href="memberList.do">전체회원조회</a></li>
									<li><a href="productList.do">전체상품조회</a></li>
									<li><a href="orderList.do">주문조회</a></li>
									<li><a href="productInsertForm.do">상품입력</a></li>
								</ul></li>
						</c:if>

					</ul>
				</nav>
			</div>
			<div class="col-lg-3">
				<div class="header__cart">
					<ul>
						<li><a href="cartList.do"><i class="fa fa-shopping-bag"></i>
								<span> <c:if test="${empty id }">
										0
									</c:if> <c:if test="${not empty id }">
										${cartCnt }
									</c:if>
							</span> </a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="humberger__open">
			<i class="fa fa-bars"></i>
		</div>
	</div>
</header>
<!-- Header Section End -->