<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="entidades.Subject"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Procurar que en este apartado siempre vayan los css -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body onload="listSubject();">
	<div class="container">
		<div class="row">
			<div class="col-12 text-center">
				<h3>Mantenimiento de Cursos</h3>
			</div>
			<div class="col-12">
				<button type="button" class="btn btn-success btn-lg"
					onclick="openDialog()">Registrar</button>
			</div>
			<br> 
			<br>
			<div class="col-12">
					<table class="table">
						<thead>
							<tr>
								<th>Id</th>
								<th>Nombre</th>
								<th>Nivel</th>
								<th>Código</th>
								<th>Profesor</th>
								<th>Opciones</th>
							</tr>
						</thead>
						<tbody id="tbody">
						</tbody>
					</table>
					
					<div class="modal fade" id="modalForm" role="dialog">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
								<h4 class="modal-title" id="myModalLabel">Registrar Curso</h4>
								<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>			
								</div>
								
								<div class="modal-body">
									<form action="" role="form">
										<input type="hidden" id="inputType" value="register">
										
										<div class="form-group">
											<label>Codigo</label>
											<input class="form-control" type="text" id="inputCode">
										</div>
										<div class="form-group">
											<label>Nombre</label>
											<input class="form-control" type="text" id="inputName">
										</div>
										<div class="form-group">
											<label>Nivel</label>
											<input class="form-control" type="text" id="inputLevel">
										</div>
										<div class="form-group">
											<label>Profesor</label>
											<input class="form-control" type="text" id="inputTeacher">
										</div>
									</form>
								</div>
								
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
									<button type="button" class="btn btn-primary submitBtn" onClick="registrarCurso()">Registrar</button>
								</div>
							</div>
						</div>
					</div>
			</div>
		</div>

		<div class="row"></div>
	</div>
	
<!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
	</script>
<script type="text/javascript">
function listSubject(){
	var data = {type:"list"};
	
	$.ajax({
		type: 'POST',
		contentType: "application/json",
		url: 'SubjectServlet',
		data: JSON.stringify(data),
		success: function(result) {
			var cursos = $.parseJSON(result);
			var tblData = "";
			
			for(var i=0; i<cursos.length; i++){
				tblData +="<tr><td>"+cursos[i].id+"</td>"+
				"<td>"+cursos[i].name+"</td>"+
				"<td>"+cursos[i].level+"</td>"+
				"<td>"+cursos[i].code+"</td>"+
				"<td>"+cursos[i].teacher+"</td>"+
				"<td></td>"+
				"</tr>";
			}
			$('#tbody').html(tblData);
		},
		error: function(){
			
		}
	});
}

function openDialog(){
	$('#modalForm').modal('show');
}

function registrarCurso(){
	var codVar = $('#inputCode').val();
	var nameVar = $('#inputName').val();
	var levelVar = $('#inputLevel').val();
	var teacherVar = $('#inputTeacher').val();
	var typeVar = $('#inputType').val();
	
	var data = {type:typeVar,code:codVar,name:nameVar,level:levelVar,teacher:teacherVar};
	
	$.ajax({
		type: 'POST',
		contentType: "application/json",
		url: 'SubjectServlet',
		data: JSON.stringify(data),
		success: function(result) {
			listSubject();
		},
		error: function(){
			
		}
	});
}
</script>
</body>
</html>