<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login</title>
</head>
<body>
<form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="POST">
	<input type="text" name="j_username" class="form-control input-sm" placeholder="User" autofocus><br />
	<input type="password" name="j_password" class="form-control input-sm" placeholder="Password"><br />
	<input type="submit" value="Submit">
</form>
</body>
</html>