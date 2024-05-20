<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entidades.Elefante"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar elefante</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"rel="stylesheet"integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"crossorigin="anonymous">
</head>
<body>
	<br>
	<div class="container">
		<h3 class="text-center">Actualizar elefante</h3>
		<form action="ElefanteServlet" method="post">
		
		<%
				Elefante elefante = (Elefante) request.getAttribute("data");
				%>
		
		<input type="hidden" name="type" value="edit">
		
			<div>
				<input type="hidden" name="idElefante" value="<%= elefante.getIdElefante() %>">
			</div>
			<div class="mb-3">
				<label>Nombre</label>
				<input class="form-control" type="text" name="txtNombre" value="<%= elefante.getNombre() %>">
			</div>
			<div class="mb-3">
				<label>Origen</label>
				<input class="form-control" type="text" name="txtOrigen" value="<%= elefante.getOrigen()%>">
			</div>
			<div class="mb-3">
				<label>Patas</label>
				<input class="form-control" type="text" name="txtPatas" placeholder="Ejemplo: 4" value="<%= elefante.getPatas() %>">
			</div>
			<div class="mb-3">
				<label>Orejas</label>
				<input class="form-control" type="text" name="txtOrejas" placeholder="2" value="<%= elefante.getOrejas() %>">
			</div>
			<div class="mb-3">
				<label>Trompa</label>
				<input class="form-control" type="text" name="txtTrompa" placeholder="SI" value="<%= elefante.getTrompa() %>">
			</div>
			<div class="mb-3">
				<label>Peso(Kg)</label>
				<input class="form-control" type="text" name="txtPeso" placeholder="5100.00" value="<%= elefante.getPeso() %>">
			</div>
			<div class="mb-3">
				<label>Fecha de nacimiento</label>
				<input class="form-control" type="date" name="txtFechaNacimiento" value="<%= elefante.getFechaNacimiento() %>">
			</div>
			
			<button type="submit" class="btn btn-primary">Actualizar</button>
			<button type="button" class="btn btn-primary" onclick="window.location='ElefanteServlet?type=list'">Volver al listado</button>
	
		</form>
		
		
	</div>
</body>
</html>