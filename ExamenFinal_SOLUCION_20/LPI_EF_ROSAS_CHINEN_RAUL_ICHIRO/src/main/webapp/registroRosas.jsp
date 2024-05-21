<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Libro" %>
<%@ page import="entidades.Proveedor" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

<%
List<Proveedor> listProveedor = (List<Proveedor>) session.getAttribute("listProveedor"); 
List<Libro> listLibro = (List<Libro>) session.getAttribute("listLibro"); 
%>

	<div
		class="container min-vh-100 d-flex justify-content-center align-items-center">
		<div class="row">
		<div class="col-12 text-center">
			<h1>Registro de ventas</h1>
		</div>
			<div class="col-12">
				<form action="VentaServlet" method="post">
				<input type="hidden" name="type" value="register">
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Proveedor</label>
						<select class="form-control" name="cboProveedor">
						
						<%
						if(listProveedor!=null){
							for(Proveedor item : listProveedor){
						%>
							<option value="<%= item.getId() %>">
								<%= item.getNombre() %>
							</option>
						<%
							}
						}
						%>
						
						</select>

					</div>
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label">Libro</label>
						<select class="form-control" name="cboLibro">
						
						<%
						if(listLibro!=null){
							for(Libro item : listLibro){
						%>
							<option value="<%= item.getId() %>">
								<%= item.getNombreLibro() %>
							</option>
						<%
							}
						}
						%>
						
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Registrar</button>
				</form>
			</div>

			<div class="col-12">
				<table class="table">
					<thead>
						<tr>
							<th>Nombre del libro</th>
							<th>Cantidad disponible (stock)</th>
						</tr>
					</thead>
					<tbody>
						<%  
						if (listLibro!=null){
							for(Libro item : listLibro){
						%>		
							<tr>
								<td><%= item.getNombreLibro() %></td>
								<td><%= item.getStock() %></td>
							</tr>
						<%
							}
						}
						%>
						
					</tbody>
				</table>
			</div>
			<%
			
			String mensajeExito = (String) request.getAttribute("mensajeBueno");
			String mensajeFallo = (String) request.getAttribute("mensajeMalo");
			
			if(mensajeFallo!=null){
			%>
			
			<div class="alert alert-danger">
				<strong><%= mensajeFallo %></strong>
			</div>
			
			<% 
			}
			%>
			
			<%
			if(mensajeExito!=null){
			%>
			
			<div class="alert alert-success">
				<strong><%= mensajeExito %></strong>
			</div>
			
			<%
			}
			%>
			
			
		</div>
	</div>
</body>
</html>