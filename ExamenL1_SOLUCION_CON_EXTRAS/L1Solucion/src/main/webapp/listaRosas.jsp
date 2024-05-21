<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import = "java.util.List" %>
<%@ page import = "entidades.Libro" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Historial de atenciones</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<br>
	<div class="container">
		<button type="button" class="btn btn-primary" onclick="window.location='LibroServlet?type=list'">Actualizar Listado</button>
		<br>
		<h3 class="text-center">Listado de atenciones</h3>
		<div>
			<table class="table" border="1">
				<thead>
					<tr>
						<th>ID</th>
						<th>Código</th>
						<th>Nombre</th>
						<th>Edición</th>
						<th>Tipo</th>
						<th>Precio(S/.)</th>
						<th>Stock</th>
						<th>Fecha de Compra</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<% List<Libro> listado = (List<Libro>) request.getAttribute("data");
					if(listado!=null){
						for(Libro libro : listado){
							
					%>
					
							<tr>
								<td><%= libro.getIdLibro() %></td>
								<td><%= libro.getCodigo() %></td>
								<td><%= libro.getNombreLibro() %></td>
								<td><%= libro.getEdicion() %></td>
								<td><%= libro.getTipo() %></td>
								<td><%= libro.getPrecio() %></td>
								<td><%= libro.getStock() %></td>
								<td><%= libro.getFechaCompra() %></td>
								<td>
									<button type="button" class="btn btn-primary" onclick="window.location='LibroServlet?type=info&id=<%= libro.getIdLibro() %>'">Editar</button>
									<button type="button" class="btn btn-danger" onclick="window.location='LibroServlet?type=delete&id=<%= libro.getIdLibro() %>'" >Eliminar</button>
								
								</td>
							</tr>
					
					<%
						}
					}
					%>
				</tbody>
			</table>
		</div>
		<div>
			<button type="button" class="btn btn-primary" onclick="window.location='registroRosas.jsp'">Registrar</button>
		</div>
	</div>
</body>

</html>