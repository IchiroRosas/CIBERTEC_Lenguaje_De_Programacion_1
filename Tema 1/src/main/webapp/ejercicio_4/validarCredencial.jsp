<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Esta es la forma de capturar la data se usa request.getParameter(nombre colocado en el input) -->
	<%
		String mensaje = "";
		//cboRol es el nombre colocado dentro de la etiqueta <select> del jsp llamado acceso.jsp
		String rol = request.getParameter("cboRol");
		//txtCredencial es el nombre colocado dentro de la etiqueta <input> del jsp llamado acceso.jsp
		String credencial = request.getParameter("txtCredencial");
		mensaje = "Datos validados correctamente";
		//para poder establecer el mensaje usamos request.setAttribute
		request.setAttribute("msj", mensaje);
		//enviamos el mensaje establecido a la página llamada respuestaCredencial.jsp
		pageContext.forward("respuestaCredencial.jsp");
%>
	
</body>
</html>