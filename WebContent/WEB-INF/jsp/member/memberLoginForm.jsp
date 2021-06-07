<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberLoginForm.jsp</title>
<style>
.table {
	margin-top: 2%;
	width: 800px;
	border: 1;
}
</style>
<script>
	function formCheck() {
		console.log("hhh")
		if (frm.memberId.value == "") {
			alert("아이디를 입력하세요");
			frm.memberId.focus();
			return false;
		}
		if (frm.memberPwd.value == "") {
			alert("비밀번호를 입력하세요");
			frm.memberPwd.focus();
			return false;
		}
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<h1>Login</h1>
		<div>
			<form id="frm" action="memberLogin.do" method="post">
				<div>
					<table class="table">
						<caption>
							<button type="button" onclick="formCheck()">로그인</button>
							<button type="reset">취소</button>
						</caption>
						<tr>
							<th>ID</th>
							<td><input type="text" id="memberId" name="memberId"></td>
						</tr>
						<tr>
							<th>PassWord</th>
							<td><input type="password" id="memberPwd" name="memberPwd"></td>
						</tr>

					</table>
				</div>
			</form>
		</div>
</body>
</html>