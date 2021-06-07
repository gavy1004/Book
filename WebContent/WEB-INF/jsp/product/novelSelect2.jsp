<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.bi-star-fill {
	content: "\f586";
	display: inline;
	color: #ffc107 !important;
}

.table {
	margin-top: 2%;
	border: 1;
	width: 100%;
}

.imgSize {
	width: -webkit-fill-available;
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<div align="center">
	<!-- Product Details Section Begin -->
	<section class="product-details spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="product__details__pic">
						<div class="product__details__pic__item">
							<img class="product__details__pic__item--large"
								style="width: 250px;" src="upload/${book.bookImage }" alt="">
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="product__details__text">
						<h3>${book.bookName}</h3>
						<c:forEach begin="1" end="${book.likeIt }">
							<div class="bi-star-fill"></div>
						</c:forEach>
						</th>
						<c:if test="${book.sale eq 'Y' }">
							<div class="product__details__price">
								price :${book.price } won
								<br>
								<hr>
								sale : ${book.salePrice } won
							</div>
						</c:if>
						<c:if test="${book.sale eq 'N' }">
							<div class="product__details__price">price : ${book.price }
							</div>
						</c:if>
						<p>
							저자 - ${book.writer } <br> [ ${book.contents } ]
						</p>
						<div class="product__details__quantity">
							<div class="quantity">
								<div class="pro-qty">
									<input type="text" value="1">
								</div>
							</div>
						</div>
						<a onclick="addCart('${vo.bookCode}','${id }')"
							class="primary-btn">ADD TO CARD</a> <a
							onclick="likeIt('${vo.bookCode }')"><i class="fa fa-heart"></i></a>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="product__details__tab">
						<ul class="nav nav-tabs" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">Description</a>
							</li>
							<li class="nav-item"><a class="nav-link" data-toggle="tab"
								href="#tabs-2" role="tab" aria-selected="false">Information</a>
							</li>
							<li class="nav-item"><a class="nav-link" data-toggle="tab"
								href="#tabs-3" role="tab" aria-selected="false">Reviews <span>
								</span></a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="tabs-1" role="tabpanel">
								<div class="product__details__tab__desc">
									<h6>Products Description</h6>
									<p>${book.contents }</p>
								</div>
							</div>
							<div class="tab-pane" id="tabs-2" role="tabpanel">
								<div class="product__details__tab__desc">
									<h6>Products Infomation</h6>
									<p>저자 - ${book.writer }</p>
									<p></p>
								</div>
							</div>
							<div class="tab-pane" id="tabs-3" role="tabpanel">
								<div class="product__details__tab__desc">
									<h6>Products Review</h6>
									<div>
										<h3>Review List</h3>
										<br>
										<div style="width: 80%">
											<table class="table">
												<tr>
													<th width="100">NO</th>
													<th>Title</th>
													<th width="150">Writer</th>
													<th width="150">Date</th>
													<th width="100">Hit</th>
												</tr>
												<c:forEach items="${bulletinList }" var="vo">
													<tr onclick="select(${vo.id })">
														<td>${vo.id }</td>
														<td id="title">${vo.title }</td>
														<td>${vo.writer }</td>
														<td>${vo.regDate }</td>
														<td>${vo.hit }</td>
													</tr>
												</c:forEach>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</section>
	<!-- Product Details Section End -->

</div>

<script>
	
function select(id){
location.href = "bulletinSelect.do?id=" + id;
}

	function reviewPage(bookCode) {
		location.href = "reviewSelect.do?bookCode=" + bookCode;
	}

	function addCart(bookCode, id) {
		if (id == "") {
			alert('로그인해 주십시오');
		} else {
			$.ajax({
				url : "${pageContext.request.contextPath}/cartInsert.do",
				data : {
					bookCode : bookCode
				},
				success : function(bookCode, id) {
					alert('장바구니에 상품이 추가되었습니다.');
				},
				error : function() {
				}
			});
		}
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
</script>