<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<form:form method="post" modelAttribute="user">
		name : <form:input path="name"/><br/>
		userId : <form:input path="userId"/><br/>
		password : <form:input path="password"/><br/>
		email : <form:input path="email"/><br/>
		<input type="submit" value="提交"/>
	</form:form>
</body>
</html>