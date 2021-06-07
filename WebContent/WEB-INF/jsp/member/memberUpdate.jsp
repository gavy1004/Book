<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<style>
.table{
	margin-top: 2%;
	width:800px;
	border:1;
}
</style>
<script>
function formCheck() {
	if(frm.passWd.value == "") {
		alert("비밀번호를 입력해 주세요");
		return false;
	}
	if(frm.passWd1.value == "") {
		alert("비밀번호를 입력해 주세요");
		return false;
	}
	if(frm.passWd.value != frm.passWd1.value) {
		alert("비밀번호가 일치하지 않습니다");
		return false;
	}
	
	frm.submit();
	
	alert("수정이 완료 되었습니다.");
}

</script>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<body>
	<div align="center">
		<h3>My Page</h3>
		<form id="frm" action="memberUpdate.do" method="post">
			<table class="table">
				<tr>
					<th>I D</th>
					<td><h5>${member.id }</h5></td>
				</tr>
				<tr>
					<th>PassWord</th>
					<td><input type="password" name="passWd" placeholder="비밀번호"><br>
						<input type="password" name="passWd1" placeholder="비밀번호 확인">
					</td>
				</tr>
				<tr>
					<th>Name</th>
					<td>${member.name }</td>
				</tr>
				<tr>
					<th>Phone</th>
					<td><input name="phone" value="${member.phone }"></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><input name="email" value="${member.email }"></td>
				</tr>
			</table>
			<button onclick="formCheck()">수정</button>
			<button onclick="location.href='productList.do'">나가기</button>
		</form>
	</div>
</body>
</html>