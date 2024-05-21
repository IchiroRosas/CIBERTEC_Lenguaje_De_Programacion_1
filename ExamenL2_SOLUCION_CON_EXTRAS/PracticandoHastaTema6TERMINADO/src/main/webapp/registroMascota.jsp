<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<h3 class="text-center">Registro de mascota</h3>
		<form action="MascotaServlet" method="post">
		
		<input type="hidden" name="type" value="register">
		<div class="mb-3">
			<label>Código</label>
			<input class="form-control" type="text" name="txtCodigo">
		</div>
		<div class="mb-3">
			<label>Nombre</label>
			<input class="form-control" type="text" name="txtNombre">
		</div>
		<div class="mb-3">
			<label>Tipo de Mascota</label>
			<input class="form-control" type="text" name="txtMascota">
		</div>
		<div class="mb-3">
			<label>Raza</label>
			<input class="form-control" type="text" name="txtRaza">
		</div>
		<div class="mb-3">
			<label>Nombre del dueño</label>
			<input class="form-control" type="text" name="txtDuenio">
		</div>
		
		<button class="btn btn-primary" type="submit">Registrar</button>
		<button class="btn btn-primary" type="button" onclick="window.location='MascotaServlet?type=list'">Volver</button>
		</form>
		
	</div>
</body>
</html>