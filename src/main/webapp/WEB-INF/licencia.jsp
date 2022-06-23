<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Auto</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<c:if test="${msgError!= null}">
			<c:out value="${msgError}"></c:out>
		</c:if>
		<form:form action="/licencia/guardar" method="post" modelAttribute="licencia">
			<form:label path="numero" class="form-label" >Numero:</form:label>
			<form:input path="numero" type="number" class="form-control" />
			<br>
			<form:label path="fechaVencimiento" class="form-label">Fecha Vencimiento:</form:label>
			<form:input path="fechaVencimiento" type="date" class="form-control"/>
			<br>
			<form:label path="clase" class="form-label">Clase:</form:label>
			<form:input type="text" path="clase" class="form-control"/>
			<br>
			<form:label path="estado" class="form-label">Estado:</form:label>
			<form:input type="text" path="estado" class="form-control"/>
			<br>
			<!-- USUARIO -->
			<form:select path="usuario" class="form-select">
				<form:option value="0">Seleccione un usuario</form:option>
			</form:select>
	
			<br>
			<button type="submit" class="btn btn-outline-primary">Guardar Licencia</button>
		</form:form>
	</div>
</body>
</html>