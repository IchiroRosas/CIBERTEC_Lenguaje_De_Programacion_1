<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Procurar que en este apartado siempre vayan los css -->
<link rel="stylesheet" href="css/style.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h2>Registrar Usuario</h2>
		<form action="" name="registration">
			<label for="firstname">Nombres</label> <input type="text"
				name="firstname" id="firstname" placeholder="Nombre" /> <label
				for="lastname">Apellidos</label> <input type="text" name="lastname"
				id="lastname" placeholder="Apellidos" /> <label for="email">Correo</label>
			<input type="email" name="email" id="email" placeholder="Correo" /> <label
				for="password">Clave</label> <input type="password" name="password"
				id="password" placeholder="Contraseña" />
			<button type="submit" class="btn btn-primary">Registrar</button>
		</form>
	</div>
</body>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
	</script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js">
</script>
<script type="text/javascript">
//Mediante jquery y la librería validate se valida por medio de mensajes los campos requeridos
	$(function() {
		$("form[name='registration']")
				.validate(
						{
							rules : {
								firstname : "required",
								lastname : "required",
								email : {
									required : true,
									email : true
								},
								password : {
									required : true,
									minlength : 5
								}
							},
							messages : {
								firstname : "Ingrese su nombre",
								lastname : "Ingrese sus apellidos",
								password : {
									required : "Ingrese su contraseña",
									minlength : "Tu contraseña debe tener al menos 5 caracteres"
								},
								email : "Ingrese su correo"
							},
							submitHandler : function(form) {
								form.submit();
							}
						});
	});
</script>
</body>
</html>