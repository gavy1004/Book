<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.table {
	margin-top: 2%;
	border: 1;
	width: 70%;
}
</style>
<script>
	function formCheck() {
		if (frm.bookName.value == "") {
			alert("상품명을 입력하세요.");
			frm.name.focus();
			return false;
		}
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<form name="frm" action="productInsert.do"
			enctype="multipart/form-data" method="post">
			<table class="table">
				<caption>
					<button type="button" onclick="formCheck()">Insert</button>
					<input type="reset" value="Reset">
					<button type="button" onclick="history.back();">Back</button>
				</caption>
				<tr>
					<th colspan="2">상품 등록</th>
				</tr>
				<tr>
					<td>분류</td>
					<td><input type="text" name="category"></td>
				</tr>
				<tr>
					<td style="width: 20%">상품명</td>
					<td><input type="text" name="bookName"></td>
				</tr>
				<tr>
					<td>이미지</td>
					<td><input type="file" name="bookImage" size="30" onchange=""></td>
				</tr>
				<tr>
					<td>설 명</td>
					<td><textarea name="contents" rows="3" cols="30"></textarea></td>
				</tr>
				<tr>
					<td>정 가</td>
					<td><input type="text" name="price"></td>
				</tr>
				<tr>
					<td>세일여부</td>
					<td><input type="text" name="sale"></td>
				</tr>
				<tr>
					<td>세일가격</td>
					<td><input type="text" name="salePrice"></td>
				</tr>
				<tr>
					<td>저 자</td>
					<td><input type="text" name="writer"></td>
				</tr>

				<tr>
					<td colspan="2"><br /></td>

				</tr>
			</table>
		</form>
	</div>
</body>
</html>