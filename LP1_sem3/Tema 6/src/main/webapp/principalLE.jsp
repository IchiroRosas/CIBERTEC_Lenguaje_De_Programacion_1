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
	<%@ include file="snippet/nav_main.jsp" %>
	
	<br>
	<div class="col-lg-6 jumbotron">
		<h2>Bienvenido ${mensaje}</h2>
	</div>
	<div class="col-lg-6">
		<h3>Cursos virtuales</h3>
		<p>Plataforma de cursos online</p>
	</div>
</div>
</body>
</html>