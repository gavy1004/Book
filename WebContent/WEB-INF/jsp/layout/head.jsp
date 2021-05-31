<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Header Section Begin -->
<header class="header">
	<div class="header__top"> 
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="header__top__left">
						<ul>
							<li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
							<li>10만원이상 구매시 무료배송</li>
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
								<a href="memberLogOut.do"><i class="fa fa-user"></i>로그아웃</a>
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
					<ul>
						<li class="active"><a href="novelList.do">홈</a></li>
						<li><a href="./shop-grid.html">공지사항</a></li>
						<li><a href="#">카테고리</a>
							<ul class="header__menu__dropdown">
								<li><a href="./shop-details.html">Shop Details</a></li>
								<li><a href="./shoping-cart.html">Shoping Cart</a></li>
								<li><a href="./checkout.html">Check Out</a></li>
								<li><a href="./blog-details.html">Blog Details</a></li>
							</ul></li>
						<li><a href="./blog.html">후기게시판</a></li>
						<c:if test="${not empty id }">
						<li><a href="./contact.html">주문내역</a></li>
						</c:if>
						<c:if test="${id eq 'admin' }">
						<li><a href="adminPage.do">관리자페이지</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
			<div class="col-lg-3">
				<div class="header__cart">
					<ul>
						<li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
						<li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
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