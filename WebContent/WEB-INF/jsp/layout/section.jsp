<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Featured Section Begin -->
<section class="featured spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title">
					<h2>오늘의 책</h2>
				</div>
				<div class="featured__controls">
					<ul>
						<li class="active" data-filter="*">전체보기</li>
						<li data-filter=".oranges">소설</li>
						<li data-filter=".fresh-meat">ㅇ</li>
						<li data-filter=".vegetables">ㅇ</li>
						<li data-filter=".fastfood">ㅇ</li>
					</ul>
				</div>
			</div>
		</div>
	
		<div class="row featured__filter">
			<c:forEach items="${list }" var="vo">
			<img src="upload/image02.jpg">
				<div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
					<div class="featured__item">
						<div>
							<img class="featured__item__pic set-bg"
								src="upload/${vo.bookimage }">
								
								<ul class="featured__item__pic__hover">
									<li><a href="#"><i class="fa fa-heart"></i></a></li>
									<li><a href="#"><i class="fa fa-retweet"></i></a></li>
									<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
								</ul>
							
							<div class="featured__item__text">
								<h6>
									<a href="#">${vo.bookName }</a>
								</h6>
								<h5>${vo.price}</h5>
							</div>
						</div>
					</div>
				</div>
			
			</c:forEach>
		</div>






	</div>
</section>
<!-- Featured Section End -->