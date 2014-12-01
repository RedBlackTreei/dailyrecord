<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<%
	String contextPath = request.getContextPath();
%>
<body>
	<form action="/dailyrecord/user/login" method="post">
		<fieldset>
			<label>用户名：</label> <input type="text" name="userId"></input><br>
			<label>密 码：</label><input type="password" name="password"></input>
			<input type="submit" value="登录"></input>
		</fieldset>
	</form>
</body>
</html>