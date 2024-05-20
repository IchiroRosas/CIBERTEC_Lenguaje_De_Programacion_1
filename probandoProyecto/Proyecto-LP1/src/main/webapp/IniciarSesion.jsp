<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
	.centrado {
		display: flex;
		justify-content: center;
		align-items: center;
		min-height: 100vh;
	}
	.formulario {
		width: 80%;
		max-width: 800px; 
		padding: 20px; 
		font-size: 18px; 
		border: 2px solid #ccc; 
		border-radius: 10px; 
		background-color: #f9f9f9; 
	}
</style>
</head>
<body>
	<div class="container centrado">
		<div class="formulario">
			<div class="text-center mb-3">
				<h3>Iniciar Sesión</h3>
			</div>
			<form action="AuthServlet" method="post">
				<input type = "hidden" value = "login" name = "type">
				<div class="mb-3">
					<label class="form-label">Correo Electronico</label> 
					<input type="email" class="form-control" name = "txtCorreo">
				</div>
				<div class="mb-3">
					<label class="form-label">Contraseña</label> 
					<input type="password" class="form-control" name = "txtContraseña">
				</div>
				<div class="mb-3 form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1">
					<label class="form-check-label" for="exampleCheck1">Recordar mi cuenta</label>
				</div>
				<div class = text-center>
					<button type="submit" class="btn btn-primary">Ingresar</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>