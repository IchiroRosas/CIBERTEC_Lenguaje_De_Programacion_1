<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="entidades.Candidato"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
table {
	font-size: 14pt;
}

.tamaño {
	width: 90%;
	margin: 0 auto;
	text-align: center;
}

.form-group label {
	margin-right: 5px;
	white-space: nowrap;
}

.form-group {
	display: flex;
	align-items: center;
}
</style>
</head>

<body>
	<nav class="navbar navbar-expand-lg bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand text-white fs-2" href="#">Reclutamiento de
				Personal</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarScroll"
				aria-controls="navbarScroll" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarScroll">
				<ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll"
					style="-bs-scroll-height: 100px;">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle text-white fs-4" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Mantenimiento Empleados </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item"
								onclick="window.location='Registrado.jsp'">Registrar
									Empleado</a></li>
							<li><a class="dropdown-item"
								onclick="location.href='WorkServlet?type=listar'">Listado de
									Empleados</a></li>
						</ul></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle text-white fs-4" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Mantenimiento Candidatos </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item"
								onclick="window.location='RegistroCandidatos.jsp'">Registrar
									Candidato</a></li>
							<li><a class="dropdown-item"
								onclick="location.href='CandidatoServlet?type=listar'">Listado de
									Candidatos</a></li>
						</ul></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle text-white fs-4" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Reportes </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item"
								onclick="window.location='FiltradoEmpleados.jsp'">Filtrado
									de Empleados</a></li>
							<li><a class="dropdown-item active"
								onclick="window.location='FiltradoCandidatos.jsp'">Filtrado
									de Candidatos</a></li>
						</ul></li>
				</ul>
				<form class="d-flex" role="search" action="AuthServlet"
					method="post">
					<input name="type" value="logout" type="hidden">
					<button class="btn btn-danger fs-4" type="submit">Logout</button>
				</form>
			</div>
		</div>
	</nav>
	<br>
	<div class="text-center text-decoration-underline">
		<h1 class="fw-bold">Filtro de Candidatos</h1>
	</div>
	<br>
	<form action="CandidatoServlet">
		<input name = "type" value = "listarObjetoFiltrado" type = "hidden">
		<div class="row g-3 justify-content-end tamaño">
			<div class="col-auto">
				<label class="col-form-label fw-bold">Carrera: </label>
			</div>
			<div class="col-auto">
				<select class="form-control border border-black" name = "cboCarrera">
					<option value = "Psicologia" disable selected hidden>--Selecciona una Opción--</option>
					<option value = "Psicologia" >Psicologia</option>
					<option value = "Computacion e Informatica" >Computacion e Informatica</option>
					<option value = "Marketing" >Marketing</option>
					<option value = "Ingenieria Industrial" >Ingenieria Industrial</option>
			  </select>
			</div>
			<div class="col-auto">
				<input type="submit" value="Filtrar" class="btn btn-primary">
			</div>
		</div>
	</form>
	<br>
	<div class="tamaño">
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombres</th>
					<th>Apellido Paterno</th>
					<th>Apellido Materno</th>
					<th>DNI</th>
					<th>Correo</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dataFiltrada}" var="c">
					<tr>
						<td>${c.idEmpleado}</td>
						<td>${c.nombres}</td>
						<td>${c.apellidoP}</td>
						<td>${c.apellidoM}</td>
						<td>${c.dni}</td>
						<td>${c.correo}</td>
						<td>
							<button type="button" class="btn btn-info btn-lg"
								data-bs-toggle="modal" data-bs-target="#ModalInfo"
								onclick="cargarInfo(${c.idEmpleado})">Info</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="modal fade" id="ModalInfo" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-xl">
				<div class="modal-content">
					<div class="modal-body">
						<div>
							<div class="text-center text-decoration-underline">
								<h1>Informacion del Candidato</h1>
							</div>
							<br>
							<div class="justify-content-center">
								<div class="d-flex justify-content-center">
									<input type="hidden" id="inputId" value="" />
									<div class="row">
										<div class="col-md-4">
											<div class="form-group d-flex align-items-center">
												<label for="inputNombres" class="col-form-label">Nombres
													Completos :</label> <input type="text" id="inputNombres"
													class="form-control" value="" />
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group d-flex align-items-center">
												<label for="inputApellidoP" class="col-form-label">Apellido
													Paterno :</label> <input type="text" id="inputApellidoP"
													class="form-control" value="" />
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group d-flex align-items-center">
												<label for="inputApellidoM" class="col-form-label">Apellido
													Materno :</label> <input type="text" id="inputApellidoM"
													class="form-control" value="" />
											</div>
										</div>
									</div>
								</div>
								<br>
								<div class="d-flex justify-content-center">
									<div class="row">
										<div class="col-md-4">
											<div class="form-group d-flex align-items-center">
												<label for="inputDni" class="col-form-label">DNI:</label> <input
													type="text" id="inputDni" class="form-control" value="" />
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group d-flex align-items-center">
												<label for="inputCarrera" class="col-form-label">Carrera:</label>
												<input type="text" id="inputCarrera" class="form-control"
													value="" />
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group d-flex align-items-center">
												<label for="inputTelefono" class="col-form-label">Telefono:</label>
												<input type="text" id="inputTelefono" class="form-control"
													value="" />
											</div>
										</div>
									</div>
								</div>
								<br>
								<div class="d-flex justify-content-center">
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label for="inputNacimiento" class="col-form-label">Nacimiento:</label>
												<input type="date" id="inputNacimiento" class="form-control"
													value="" />
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label for="inputCorreo" class="col-form-label">Correo:</label>
												<input type="email" id="inputCorreo" class="form-control"
													value="" />
											</div>
										</div>
									</div>
								</div>
								<br>
							</div>
							<div class="modal-footer justify-content-center">
								<button type="button" class="btn btn-danger"
									data-bs-dismiss="modal">Cerrar</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
function cargarInfo(idCandidato) {
    $.ajax({
        url: 'CandidatoServlet?type=infoModal&idCandidato=' + idCandidato,
        type: 'GET',
        dataType: 'json',
        success: function(response) {
            document.getElementById('inputId').value = response.idCandidato;
            document.getElementById('inputNombres').value = response.nombres;
            document.getElementById('inputApellidoP').value = response.apellidoP;
            document.getElementById('inputApellidoM').value = response.apellidoM;
            document.getElementById('inputDni').value = response.dni;
            document.getElementById('inputCarrera').value = response.carrera;
            document.getElementById('inputTelefono').value = response.telefono;
            document.getElementById('inputNacimiento').value = response.fechaNacimiento;
            document.getElementById('inputCorreo').value = response.correo;
            
            
            $('#ModalInfo').modal('show');
        },
        error: function(xhr, status, error) {
            console.log('Error al obtener la información del empleado.');
        }
    });
}

</script>
</html>