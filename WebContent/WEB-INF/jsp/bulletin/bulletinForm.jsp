<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기게시판</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>
<script>
	$(function(){
		CKEDITOR.replace('content', {
			filebrowserUploadUrl: '${pageContext.request.contextPath}/fileUpload',
			height: '600px',
			width: '800px'
		}); 
	})
	
	function formCheck() {
		if(frm.title.value == ""){
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
		<form id="frm" action="bulletinInsert.do"method="post">
			<input type="hidden" name="id" value="${id }">				<!-- 로그인한 id값 -->
			<div>
				<table border="1">
					<tr>
						<th width="100">작성일</th>
						<td width="100">
							<input type="text" id="title" name="title">
						</td>
					</tr>
					<tr>
						<th width="100">작성자</th>
						<td width="100">
							<input type="text" id="title" name="title">
						</td>
					</tr>
					<tr>
						<th width="100">제목</th>
						<td width="100">
							<input type="text" id="title" name="title">
						</td>
					</tr>
					<tr>
						<th width="100">도서코드</th>
						<td width="100">
							<input type="text" id="title" name="title">
						</td>
					</tr>
					<tr>
						<th width="100">내용</th>
						<td width="100">
							<textarea id="content" name="content" rows="" cols=""></textarea>
						</td>
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