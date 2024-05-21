<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entidades.Mascota" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"rel="stylesheet"integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"crossorigin="anonymous">
</head>
<body>
	<br>
	<div class="container">
		<h3 class="text-center">Editar mascota</h3>
		<form action="MascotaServlet" method="post">
		<input type="hidden" name="type" value="edit">
		<%
		Mascota mascota = (Mascota) request.getAttribute("data");
		%>
		<input type="hidden" name="id" value="<%= mascota.getId() %>">
		<div class="mb-3">
			<label>Código</label>
			<input class="form-control" type="text" name="txtCodigo" value=<%= mascota.getCodigo() %>>
		</div>
		<div class="mb-3">
			<label>Nombre</label>
			<input class="form-control" type="text" name="txtNombre" value=<%= mascota.getNombre() %>>
		</div>
		<div class="mb-3">
			<label>Tipo de Mascota</label>
			<input class="form-control" type="text" name="txtMascota" value=<%= mascota.getMascota() %>>
		</div>
		<div class="mb-3">
			<label>Raza</label>
			<input class="form-control" type="text" name="txtRaza" value=<%= mascota.getRaza() %>>
		</div>
		<div class="mb-3">
			<label>Nombre del dueño</label>
			<input class="form-control" type="text" name="txtDuenio" value=<%= mascota.getDuenio() %>>
		</div>
		
		<button class="btn btn-primary" type="submit">Actualizar</button>
		<button class="btn btn-primary" type="button" onclick="window.location='MascotaServlet?type=list'">Volver</button>
		</form>
	
	</div> 
</body>
</html>