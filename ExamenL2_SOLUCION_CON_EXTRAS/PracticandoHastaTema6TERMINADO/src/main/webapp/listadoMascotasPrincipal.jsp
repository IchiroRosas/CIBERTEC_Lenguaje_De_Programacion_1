<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entidades.Mascota" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de mascotas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"rel="stylesheet"integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"crossorigin="anonymous">
</head>
<body>
	<div class="container">
	
	<h3>Bienvenido: ${sessionScope.nombre} ${sessionScope.apellido} - ${sessionScope.codigo}</h3>
	<form action="UsuarioAuthServlet" method="post">
		<input type="hidden" name="type" value="logout">
		<button class="btn btn-danger" type="submit">Cerrar sesión</button>
	</form>
		<h3 class="text-center">Lista de mascotas</h3>
		
		<button class="btn btn-primary" type="button" onclick="window.location='registroMascota.jsp'">Nuevo registro</button>

		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Código</th>
					<th>Nombre</th>
					<th>Mascota</th>
					<th>Raza</th>
					<th>Dueño</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
			<% 
			List<Mascota> listMascota = (List<Mascota>) request.getAttribute("data");
			if(listMascota!=null) {
				for(Mascota mascota : listMascota){
			%>
				
				<tr>
					<td><%= mascota.getId() %></td>
					<td><%= mascota.getCodigo() %></td>
					<td><%= mascota.getNombre() %></td>
					<td><%= mascota.getMascota() %></td>
					<td><%= mascota.getRaza() %></td>
					<td><%= mascota.getDuenio() %></td>
					<td>
					<button class="btn btn-primary" type="button" onclick="window.location='MascotaServlet?type=info&id=<%= mascota.getId() %>'">Editar</button>
					<button class="btn btn-danger" type="button" onclick="window.location='MascotaServlet?type=delete&id=<%= mascota.getId() %>'">Eliminar</button>
					</td>
				</tr>

			<% 
				}
			}
			%>
			</tbody>
		</table>

		

	</div>
</body>
</html>