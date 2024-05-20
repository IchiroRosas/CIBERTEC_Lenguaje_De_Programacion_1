<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import = "java.util.List" %>
<%@ page import = "entidades.Elefante" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de elefantes</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<br>
	<div class="container">
		<button type="button" class="btn btn-primary" onclick="window.location='ElefanteServlet?type=list'">Actualizar Listado</button>
		<br>
		<h3 class="text-center">Listado de elefantes</h3>
		<div>
			<table class="table" border="1">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Origen</th>
						<th>Patas</th>
						<th>Orejas</th>
						<th>Trompa</th>
						<th>Peso(Kg)</th>
						<th>Fecha de nacimiento</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Elefante> listado = (List<Elefante>) request.getAttribute("data");
								if(listado!=null){
									for(Elefante elefante : listado){
					%>
					
							<tr>
								<td><%=elefante.getIdElefante()%></td>
								<td><%=elefante.getNombre()%></td>
								<td><%=elefante.getOrigen()%></td>
								<td><%=elefante.getPatas()%></td>
								<td><%=elefante.getOrejas()%></td>
								<td><%=elefante.getTrompa()%></td>
								<td><%=elefante.getPeso() %></td>
								<td><%=elefante.getFechaNacimiento() %></td>
								<td>
									<button type="button" class="btn btn-primary" onclick="window.location='ElefanteServlet?type=info&id=<%= elefante.getIdElefante() %>'">Editar</button>
									<button type="button" class="btn btn-danger" onclick="window.location='ElefanteServlet?type=delete&id=<%= elefante.getIdElefante() %>'" >Eliminar</button>
								
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
			<button type="button" class="btn btn-primary" onclick="window.location='registroElefante.jsp'">Registrar</button>
		</div>
	</div>
</body>

</html>