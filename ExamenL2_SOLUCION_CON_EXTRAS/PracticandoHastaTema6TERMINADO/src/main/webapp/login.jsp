<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"rel="stylesheet"integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"crossorigin="anonymous">
</head>
<body>
	<br>
	<div class="container">
	
		<h3 class="text-center">Log-In</h3>
		
		<form action="UsuarioAuthServlet" method="post">
		<input type="hidden" name="type" value="login">
		
		<div class="mb-3">
			<label>Correo</label>
			<input class="form-control" type="email" name="txtCode">
		</div>
		<div class="mb-3">
			<label>Contraseña</label>
			<input class="form-control" type="password" name="txtPass">
		</div>
		<button class="btn btn-primary" type="submit">Ingresar</button>
		</form>
		
	</div>
</body>
</html>