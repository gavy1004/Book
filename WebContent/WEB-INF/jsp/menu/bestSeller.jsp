<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<div class="col-lg-8 col-md-7">
	<div class="row">
		<table>
			<c:forEach items="${blist }" var="vo">
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="blog__item">
						<tr>
							<td><img width="200" height="270" src="upload/${vo.bookImage }"
								alt=""></td>
						</tr>
						<tr>
				
							<h5>
								<a href="#"><h3 style="color: red;">${vo.rank}</h3>
								${vo.bookName }</a>
							</h5>
						</tr>
						
							<p>${vo.contents }</p>
							<a onclick="selectNovel('${vo.bookCode }')" class="blog__btn">MORE
								<span class="arrow_right"></span>
							</a>
					

					</div>
				</div>
			</c:forEach>
			</div>
		</table>

		<a>페이징</a>

</div>

<script>
	// 책 제목 클릭시 상세 페이지로 이동
	function selectNovel(bookCode) {
		location.href = "novelSelect.do?bookCode=" + bookCode;
	}
</script>