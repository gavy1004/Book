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
						<li data-filter=".fresh-meat">소설</li>
						<li data-filter=".fastfood">시</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- 시 -->
		<div class="row featured__filter">
			<c:forEach items="${nlist }" var="vo">
				<div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
					<div class="featured__item">
						<div class="featured__item__pic" style="text-align: center;">
							<img width="200" height="270" src="upload/${vo.bookImage }">
							<ul class="featured__item__pic__hover">
								<li><a onclick="likeIt('${vo.bookCode }')"><i
										class="fa fa-heart"></i></a></li>
								<li><a onclick="selectNovel('${vo.bookCode }')"><i class="fa fa-retweet"></i></a></li>
								<li><a onclick="addCart('${vo.bookCode}','${id }')"><i
										class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<div class="featured__item__text">
							<h6>
								<a onclick="selectNovel('${vo.bookCode }')">${vo.bookName }</a>
							</h6>
							<h5>${vo.price}</h5>
						</div>
					</div>
				</div>
			</c:forEach>

			<c:forEach items="${plist }" var="vo">
				<div class="col-lg-3 col-md-4 col-sm-6 mix oranges fastfood">
					<div class="featured__item">
						<div class="featured__item__pic" style="text-align: center;">
							<img width="200" height="270" src="upload/${vo.bookImage }">
							<ul class="featured__item__pic__hover">
								<li><a onclick="likeIt('${vo.bookCode }')"><i
										class="fa fa-heart"></i></a></li>
								<li><a onclick="selectNovel('${vo.bookCode }')"><i class="fa fa-retweet"></i></a></li>
								<li><a onclick="addCart('${vo.bookCode}','${id }')"><i
										class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<div class="featured__item__text">
							<h6>
								<a onclick="selectNovel('${vo.bookCode }')">${vo.bookName }</a>
							</h6>
							<h5>${vo.price}</h5>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
</section>
<!-- Featured Section End -->

<script>
	// 책 제목 클릭시 상세 페이지로 이동
	function selectNovel(bookCode) {
		location.href = "novelSelect.do?bookCode=" + bookCode;
	}
	// 비로그인 상태에서도 좋아요 누르기 가능
	function likeIt(bookCode) {
		$.ajax({
			url : "${pageContext.request.contextPath}/likeIt.do",
			data : {
				bookCode : bookCode
			},
			success : function() {
				alert('좋아요가 추가되었습니다.');
			},
			error : function() {
			}
		});

	}
	// 로그인상태가 아닐시 장바구니에 상품 담을 수 없음
	function addCart(bookCode, id) {
		if (id == "") {
			alert('로그인해 주십시오');
		} else {
			location.href = "cartInsert.do?bookCode=" + bookCode;
			alert('장바구니에 상품이 추가되었습니다.');
		}

	}
</script>
