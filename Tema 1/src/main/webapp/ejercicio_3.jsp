<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- En este ejercicio se visualizará el formulario con la misma tabla del ejercicio 2 -->
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="col-lg-8">
		<h3>Registrar Cursos</h3>
		<form action="SubjectServlet" method="post">
			<div class="form-group">
				<label>Código</label> <input class="form-control" type="text"
					name="txtCode" value="">
			</div>

			<br>
			<div class="form-group">
				<label>Nombre</label> <input class="form-control" type="text"
					name="txtName" value="">
			</div>
			<br>
			<div class="form-group">
				<label>Nivel</label> <input class="form-control" type="text"
					name="txtLevel" value="">
			</div>
			<br>
			<div class="form-group">
				<label>Profesor</label> <input class="form-control" type="text"
					name="txtTeacher" value="">
			</div>
			<br> <input type="submit" class="btn btn-primary"
				value="Enviar Datos">
		</form>
		<br> <br>
		<table class="table" border="1">
			<thead>
				<tr>
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
					<td><input type="submit" value="Editar"> <input
						type="submit" value="Eliminar"></td>
				</tr>
				<tr>
					<td>2</td>
					<td>1956</td>
					<td>Desarrollo de Aplicaciones Móviles I</td>
					<td>Avanzado</td>
					<td>Diana Vera</td>
					<td><input type="submit" value="Editar"> <input
						type="submit" value="Eliminar"></td>
				</tr>
				<tr>
					<td>3</td>
					<td>7878</td>
					<td>Programación Orientada a Objetos I</td>
					<td>Intermedio</td>
					<td>Julio Sanchez</td>
					<td><input type="submit" value="Editar"> <input
						type="submit" value="Eliminar"></td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>