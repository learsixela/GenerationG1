<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Auto</title>
</head>
<body>
	<div>
		<c:if test="${msgError!= null}">
			<c:out value="${msgError}"></c:out>
		</c:if>
		<form:form action="/auto/guardar" method="post" modelAttribute="auto">
			<form:label path="marca">Marca:</form:label>
			<form:input path="marca" />
			<br>
			<form:label path="modelo">Modelo:</form:label>
			<form:input path="modelo" />
			<br>
			<form:label path="velocidad">Velocidad:</form:label>
			<form:input type="number" path="velocidad" />
			<br>
			<form:label path="color">Color:</form:label>
			<form:input path="color" />
			<br>
			<input type="submit" value="Guardar Auto">
		</form:form>
	</div>
</body>
</html>