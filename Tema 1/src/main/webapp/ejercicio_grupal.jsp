<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- Ejercicio en donde se visualiza menú nav tab -->
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap -->
<!-- CDN de boostrap de preferencia ponerlo aquí para que la página adquiera los estilos de boostrap 
en este caso estamos usando la versión 5.1.3 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-
1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Ejemplo 03</title>
</head>
<body>
	<div class="container">
		<div>
			<ul class="nav nav-tabs">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#">Principal</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
					role="button" aria-expanded="false">Mantenedores</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Productos</a></li>
						<li><a class="dropdown-item" href="#">Ventas</a></li>
						<li><a class="dropdown-item" href="#">Almacén</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Ayuda</a></li>
					</ul></li>
				<li class="nav-item"><a class="nav-link" href="#">Reportes</a>
				</li>
				<li class="nav-item"><a class="nav-link disabled">Soporte</a></li>
			</ul>
		</div>

		<br>
		<div class="accordion" id="accordionPanelsStayOpenExample">
			<div class="accordion-item">
				<h2 class="accordion-header" id="panelsStayOpen-headingOne">
					<button class="accordion-button" type="button"
						data-bs-toggle="collapse"
						data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true"
						ariacontrols="panelsStayOpen-collapseOne">Principales
						Noticias</button>
				</h2>
				<div id="panelsStayOpen-collapseOne"
					class="accordion-collapse collapse
show"
					aria-labelledby="panelsStayOpen-headingOne">
					<div class="accordion-body">Lorem Ipsum is simply dummy text
						of the printing and typesetting industry. Lorem Ipsum has been the
						industry's standard dummy text ever since the 1500s, when an
						unknown printer took a galley of type and scrambled it to make a
						type specimen book. It has survived not only five centuries,</div>
				</div>
			</div>
			<div class="accordion-item">
				<h2 class="accordion-header" id="panelsStayOpen-headingTwo">
					<button class="accordion-button collapsed" type="button"
						data-bstoggle="collapse"
						data-bs-target="#panelsStayOpen-collapseTwo" aria-expanded="false"
						aria-controls="panelsStayOpen-collapseTwo">Últimas
						Noticias</button>
				</h2>
				<div id="panelsStayOpen-collapseTwo"
					class="accordion-collapse collapse"
					aria-labelledby="panelsStayOpen-headingTwo">
					<div class="accordion-body">Lorem Ipsum is simply dummy text
						of the printing and typesetting industry. Lorem Ipsum has been the
						industry's standard dummy text ever since the1500s, when an
						unknown printer took a galley of type and scrambled it to make a
						type specimen book. It has survived not only five centuries,</div>
				</div>
			</div>
		</div>
		<br>
		<div class="card text-center">
			<div class="card-header">Footer</div>
			<div class="card-body">
				<h5 class="card-title">Cibertec</h5>
				<p class="card-text">Creado y soportado por Cibertec</p>
				<a href="#" class="btn btn-primary">Contáctanos</a>
			</div>
			<div class="card-footer text-muted">2023</div>
		</div>
	</div>
</body>
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
</html>