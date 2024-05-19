<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- De esta manera se obtiene la variable que retorna desde SubjectServlet.java y así llega a esta página -->
	<%
	String subject[] = (String[]) request.getAttribute("registerSubject");
	%>
	<h4>
		Código Curso :
		<%=subject[0]%><br> Nombre Curso :
		<%=subject[1]%><br> Nivel Curso :
		<%=subject[2]%><br> Modalidad Curso :
		<%=subject[3]%><br> Profesor Curso :
		<%=subject[4]%><br>
	</h4>
</body>
</html>