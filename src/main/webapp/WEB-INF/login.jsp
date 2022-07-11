<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login:.</title>
</head>
<body>
	<div>
		<c:if test="${msgError!= null}">
			<c:out value="${msgError}"></c:out>
		</c:if>
		
		<form action="/registro/usuario/ingreso" method="post">
		
			<label for="email">Email:</label>
			<input type="email" name="email"/>
			<br>
			<label for="password">Password:</label>
			<input type="password" name="password"/>
			<br>
			<input type="submit" value="Ingresar">
		</form>
	</div>
</body>
</html>