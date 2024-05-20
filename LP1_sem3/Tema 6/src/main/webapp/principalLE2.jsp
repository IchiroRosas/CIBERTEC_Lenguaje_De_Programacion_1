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

	<div class="row">
	 <h2>Cursos Virtuales</h2>
	 <h3>Bienvenido ${usuario.nombre} ${usuario.apellido}</h3>
	 
	 <div class="col-6 col-sm-4">
	 	<ul class="list-group">
	 		<li class="list-group-item"><a>Actualizar información</a></li>
	 		<li class="list-group-item"><a>Mantenedor de Cursos</a></li>
	 		<li class="list-group-item"><a>Mantenedor de Profesores</a></li>
	 		<li class="list-group-item"><a>Mantenedor de Estudiantes</a></li>
	 		<li class="list-group-item"><a>Cerrar Sesión</a></li>
	 	</ul>
	 </div>
	 
	 <div class="col-6 col-sm-7 bg-light">
	 	<p>Actualización de datos</p>
	 	<form action="SubjectServlet" method="post" class="">
	 		<div class="form-group">
		 		<label class="text-secondary">Código</label>
		 		<input class="form-control" type="text" name="txtCode" value="${usuario.codigo}" readonly="readonly">
	 		</div>
	 		<div class="form-group">
		 		<label class="text-secondary">Nombre</label>
		 		<input class="form-control" type="text" name="txtName" value="${usuario.nombre}">
	 		</div>
	 		<div class="form-group">
		 		<label class="text-secondary">Apellido</label>
		 		<input class="form-control" type="text" name="txtApellido" value="${usuario.apellido}">
	 		</div>
	 		<div class="form-group">
		 		<label class="text-secondary">Usuario</label>
		 		<input class="form-control" type="text" name="txtTeacher" value="${usuario.usuario}">
	 		</div>
	 		<div class="form-group">
		 		<label class="text-secondary">Contraseña</label>
		 		<input class="form-control" type="password" name="txtTeacher" value="">
	 		</div>
	 		<br>
	 		<div class="btn-group" role="group" arial-label="Basic example">
	 			<input type="submit" class="btn btn-primary" value="Actualizar">
	 		</div>
	 	</form>
	 </div>
	</div>
</div>
</body>
</html>