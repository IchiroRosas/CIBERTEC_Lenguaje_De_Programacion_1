<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entidades.Libro"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar registro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"rel="stylesheet"integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"crossorigin="anonymous">
</head>
<body>
	<br>
	<div class="container">
		<h3 class="text-center">Actualizar registro</h3>
		<form action="LibroServlet" method="post">
		
		<% 
	   	Libro libro = (Libro) request.getAttribute("data");
		%>
		
		<input type="hidden" name="type" value="edit">
		
			<div>
				<input type="hidden" name="idLibro" value="<%= libro.getIdLibro() %>">
			</div>
			<div class="mb-3">
				<label>Código</label>
				<input class="form-control" type="text" name="txtCodigo" value="<%= libro.getCodigo() %>">
			</div>
			<div class="mb-3">
				<label>Nombre del libro</label>
				<input class="form-control" type="text" name="txtNombreLibro" value="<%= libro.getNombreLibro()%>">
			</div>
			<div class="mb-3">
				<label>Edición</label>
				<input class="form-control" type="text" name="txtEdicion" value="<%= libro.getEdicion() %>">
			</div>
			<div class="mb-3">
				<label>Tipo</label>
				<input class="form-control" type="text" name="txtTipo" value="<%= libro.getTipo() %>">
			</div>
			<div class="mb-3">
				<label>Precio(S/.)</label>
				<input class="form-control" type="text" name="txtPrecio" value="<%= libro.getPrecio() %>">
			</div>
			<div class="mb-3">
				<label>Stock</label>
				<input class="form-control" type="text" name="txtStock" value="<%= libro.getStock() %>">
			</div>
			<div class="mb-3">
				<label>Fecha de compra</label>
				<input class="form-control" type="date" name="txtFechaCompra" value="<%= libro.getFechaCompra() %>">
			</div>
			
			<button type="submit" class="btn btn-primary">Actualizar</button>
			<button type="button" class="btn btn-primary" onclick="window.location='LibroServlet?type=list'">Volver al listado</button>
	
		</form>
		
		
	</div>
</body>
</html>