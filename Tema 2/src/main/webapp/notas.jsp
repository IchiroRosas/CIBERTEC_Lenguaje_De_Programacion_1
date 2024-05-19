<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<!-- Se visualizará una tabla de registro de notas, al ingresar los datos irá al servlet para luego redirigir a 
la página respuesta en donde se visualizará la data ingresada -->
<body>
	<form id="frmRegistroCursos" action="SubjectServlet" method="post">
		<table border="1">
			<tr>
				<th colspan="2">Registro de Cursos</th>
			</tr>
			<tr>
				<td>Código del Curso</td>
				<td><input type="number" name="txtCodigo" size="4"
					maxlength="4" minlength="4" required></td>
			</tr>
			<tr>
				<td>Nombre del Curso</td>
				<td><input type="text" name="txtNombre" size="30"
					class="required"></td>
			</tr>
			<tr>
				<td>Nivel del Curso:</td>
				<td><select name="cboNivel" style="width: 140px">
						<option value="badico">Básico</option>
						<option value="intermedio">Intermedio</option>
						<option value="avanzado">Avanzado</option>
				</select></td>
			</tr>
			<tr>
				<td>Modalidad del Curso:</td>
				<td><select name="cboModalidad" style="width: 140px">
						<option value="presencial">Presencial</option>
						<option value="virtual">Virtual</option>
						<option value="hibrido">Híbrido</option>
				</select></td>
			</tr>
			<tr>
				<td>Docente del Curso:</td>
				<td><input type="text" name="txtDocente" size="30"
					class="required"></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="Enviar Datos">
				</th>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
	</script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js">
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#frmRegistroCursos").validate();
	});
</script>
</html>
