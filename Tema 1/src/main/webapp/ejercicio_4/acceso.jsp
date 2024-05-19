<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- Este ejecicio muestra una tabla de loguin en donde al darle click al botón te debe de mostrar un mensaje  -->
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- dentro de action se coloca el nombre del jsp de donde vas a obtener la data  -->
	<form name="frmAcceso" method="post" action="validarCredencial.jsp">
		<table border="1">
			<tr>
				<th colspan="2">Validación de Acceso</th>
			</tr>
			<tr>
				<td>Rol de Usuario:</td>
				<td><select name="cboRol" style="width: 140px">
						<option value="administrador">Administrador</option>
						<option value="empleado">Empleado</option>
						<option value="soporte">Soporte</option>
				</select></td>
			</tr>
			<tr>
				<td>Credencial</td>
				<td><input type="text" name="txtCredencial"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value=Enviar></td>
			</tr>
		</table>
	</form>
</body>
</html>