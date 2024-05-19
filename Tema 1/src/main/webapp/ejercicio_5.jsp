<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- En este ejercicio se visualizará el formulario con la tabla usando boostrap -->
<html>
<head>
<meta charset="ISO-8859-1">
<!-- CDN de boostrap de preferencia ponerlo aquí para que la página adquiera los estilos de boostrap 
en este caso estamos usando la versión 5.1.3 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="col-lg-8">
		<h2>
			Cursos Disponibles <span class="badge bg-secondary">Nuevos</span>
		</h2>
		<table class="table table-success table-striped">
			<thead>
				<tr class="bg-info">
					<th>Id</th>
					<th>Código</th>
					<th>Nombre</th>
					<th>Nivel</th>
					<th>Profesor</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td>1</td>
					<td>2414</td>
					<td>Seguridad de Aplicaciones</td>
					<td>Intermedio</td>
					<td>Jose Gomez</td>
					<td>
						<button type="button" class="btn btn-primary">Editar</button>
						<button type="button" class="btn btn-danger">Eliminar</button>
					</td>
				</tr>
				<tr>
					<td>2</td>
					<td>1956</td>
					<td>Desarrollo de Aplicaciones Móviles I</td>
					<td>Avanzado</td>
					<td>Diana Vera</td>
					<td>
						<button type="button" class="btn btn-primary">Editar</button>
						<button type="button" class="btn btn-danger">Eliminar</button>
					</td>
				</tr>
				<tr>
					<td>3</td>
					<td>7878</td>
					<td>Programación Orientada a Objetos I</td>
					<td>Intermedio</td>
					<td>Julio Sanchez</td>
					<td>
						<button type="button" class="btn btn-primary">Editar</button>
						<button type="button" class="btn btn-danger">Eliminar</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- Bootstrap JS -->
	<!-- Estos son los links del boostrap son usados para realizar animaciones como por ejemplo carrusel -->
	<script src="https://code.jquery.com/jquery-latest.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>

</body>
</html>