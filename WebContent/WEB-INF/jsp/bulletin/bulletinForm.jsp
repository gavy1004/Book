<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>후기게시판</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>
<script>
	function formCheck() {
		if (frm.title.value == "") {
			alert("제목을 입력하세요.");
			frm.title.focus();
			return false;
		}
		frm.submit();
	}
</script>
</head>

<body>
	<div align="center">
		<div>
			<h3>후기글 작성</h3>
		</div>
		<div>
			<form id="frm" action="bulletinInsert.do" method="post">
				<input type="hidden" name="id" value="${id }">
				<input type="hidden" name="bookCode" value="${order.bookCode }">
				<!-- 로그인한 id값 -->
				<div>
					<table border="1" width="500">
						<tr>
							<th width="100">주문번호</th>
							<td width="400">${order.code }</td>
						</tr>
						<tr>
							<th width="100">작성일</th>
							<td width="100">
								<p id="time-result"></p> <script type="text/javascript">
									var d = new Date();
									var currentDate = d.getFullYear() + "년 "
											+ (d.getMonth() + 1) + "월 "
											+ d.getDate() + "일";
									var result = document
											.getElementById("time-result");
									result.innerHTML = currentDate;
								</script>

							</td>
						</tr>
						<tr>
							<th width="100">작성자</th>
							<td width="400">${order.name }</td>
						</tr>
						<tr>
							<th width="100">제목</th>
							<td width="100"><input type="text" id="title" name="title">
							</td>
						</tr>
						<tr>
							<th width="100">도서코드</th>
							<td width="100">${order.bookCode }</td>
						</tr>
						<tr>
							<th width="100">내용</th>
							<td width="100"><textarea id="content" name="content"
									rows="" cols=""></textarea></td>
						</tr>
					</table>
				</div>
				<div>
					<button type="button" onclick="formCheck()">등록</button>
					<button type="reset">취소</button>
					<button type="button" onclick="location.href=''">홈</button>
				</div>
			</form>
		</div>
	</div>
</body>

</html>