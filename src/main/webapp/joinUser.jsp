<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
<center>
<h1>회원가입</h1>
<hr>
<form action="joinUser_proc.jsp" method="post">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange">아이디</td>
		<td><input type="text" name="id"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">비밀번호</td>
		<td><input type="password" name="password"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">이름</td>
		<td><input type="text" name="name"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="가입하기"/>
		</td>
	</tr>
</table>
</form>
<hr>
</center>
</body>
</html>