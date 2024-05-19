<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	//recuperamos el mensaje enviado desde validarCredencial.jsp
	String msj = (String) request.getAttribute("msj");
	%>
	<!-- agregamos una etiqueta <h2> para establecer le mensaje -->
	<h2 align="center">
		Mensaje :
		<!-- de esta manera obtenemos el mensaje mediante la variable msj -->
		<%=msj%>
	</h2>
</body>
</html>