<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<style>
.title {
	text-align: center;
	margin-top: 3%;
}

.contentsCenter {
	display: flex;
	flex-wrap: wrap;
	margin-left: 19%;
	margin-top: 5%;
}

.contentsText {
	display: block;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	width: 100px;
}
</style>

<h1 class="title">Novel</h1>
<div class="contentsCenter">
	<c:forEach items="${nlist }" var="vo">
		<div class="blog__item">
			<div class="blog__item__pic">
				<img width="200" height="270" src="upload/${vo.bookImage }" alt="">
			</div>
			<div class="blog__item__text">
				<h5>
					<a class="contentsText">${vo.bookName }</a>
				</h5>
				<p class="contentsText">${vo.contents }</p>
				<a onclick="selectNovel('${vo.bookCode }')" class="blog__btn">READ
					MORE <span class="arrow_right"></span>
				</a>
			</div>
		</div>
	</c:forEach>
</div>


<script>
	// 책 제목 클릭시 상세 페이지로 이동
	function selectNovel(bookCode) {
		location.href = "novelSelect.do?bookCode=" + bookCode;
	}
</script>