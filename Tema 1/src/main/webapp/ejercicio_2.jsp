<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- En este ejercicio se va a crear una tabla en donde se visualizará un listado de 3 cursos disponibles.
*Recomiendo practicar agregando más filas a la tabla -->
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="col-lg-8">
		<h3>Cursos Disponibles</h3>
		<table class="table" border="1">
			<thead>
				<!-- con la etiqueta <tr> inicias una fila -->
				<tr>
					<!-- cada <tr> tiene su <td> cada <th> vendría a ser su columna de cabecera  -->
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
					<!-- cada <tr> tiene su <td> cada <td> vendría a ser su columna -->
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