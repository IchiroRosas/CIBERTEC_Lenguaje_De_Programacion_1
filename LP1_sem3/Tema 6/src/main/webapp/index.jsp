<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-
1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<body>
	<div class="container">
	<br>
	<div class="col-lg-6">
		<form action="LoginLEServlet3" method="post" id="id_form">
			<input type="hidden" name="type" value="login">
			<div class="form-group">
				<label for="">Correo</label>
				<input type="text" class="form-control" name="txtCorreo">
			</div>
			<div class="form-group">
				<label>Contraseña</label>
				<input type="text" class="form-control" name="txtPass">
			</div>
			<input type="submit" class="btn btn-primary" name="validateBtn" value="Enviar Datos">
		</form>
		<br>
		<%
		String mensaje = (String) request.getAttribute("mensaje");
		if (mensaje != null){
		%>
			<div class="alert alert-danger">
				<strong>Error!</strong><%=mensaje %>
			</div>
			<%
		}
			%>
	</div>
	</div>
</body>
</html>