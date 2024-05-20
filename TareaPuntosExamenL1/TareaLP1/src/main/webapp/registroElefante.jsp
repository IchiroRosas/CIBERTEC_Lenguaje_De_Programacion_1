<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar nuevo elefante</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<br>
	<div class="container">
		<h3>Nuevo elefante</h3>
			<form action="ElefanteServlet" method="post" name="registroNuevo">
			<input type="hidden" name="type" value="register">
				<div class="mb-3">
					<label>Nombre</label>
					<input type="text" class="form-control" name="txtNombre">
				</div>
				<div class="mb-3">
					<label>Origen</label>
					<input type="text" class="form-control" name="txtOrigen" placeholder="Ejemplo: Africa">
				</div>
				<div class="mb-3">
					<label>Patas</label>
					<input type="text" class="form-control" name="txtPatas" placeholder="Ejemplo: 4">
				</div>
				<div class="mb-3">
					<label>Orejas</label>
					<input type="text" class="form-control" name="txtOrejas" placeholder="Ejemplo: 2">
				</div>
				<div class="mb-3">
					<label>Trompa</label>
					<input type="text" class="form-control" name="txtTrompa" placeholder="Ejemplo: SI">
				</div>
				<div class="mb-3">
					<label>Peso(Kg)</label>
					<input type="text" class="form-control" name="txtPeso" placeholder="Ejemplo: 6000.00">
				</div>
				<div class="mb-3">
					<label>Fecha de nacimiento</label>
					<input type="date" class="form-control" name="txtFechaNacimiento">
				</div>
			<button type="submit" class="btn btn-primary">Registrar</button>
			<button type="button" class="btn btn-primary" onclick="window.location='ElefanteServlet?type=list'">Volver al listado</button>					
			</form>
			
	</div>
	
</body>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<script type="text/javascript">	//

	$(function(){
		$("form[name='registroNuevo']").validate({
			rules:{
				txtNombre:{
					required:true
				},
				txtOrigen:{
					required:true
				},
				
				txtPatas:{
					required:true
				},
				txtOrejas:{
					required:true
				},
				txtTrompa:{
					required:true
				},
				txtPeso:{
					required:true
				},
				txtFechaNacimiento:{
					required:true
				}
			},
			messages:{
				txtNombre:"Ingrese nombre.",
				txtOrigen:"Ingrese lugar de origen.",
				txtPatas:"Ingrese número de patas.",
				txtOrejas:"Ingrese número de orejas.",
				txtTrompa:"Ingrese si tiene o no trompa.",
				txtPeso:"Ingrese peso en Kg.",
				txtFechaNacimiento:"Seleccione fecha de nacimiento."
			},
			submitHandler:function(form){
				form.submit();
			}
			
		});
		
		$("form[name='registroNuevo']").submit(function(event){
			event.preventDefault();
			if($(this).valid()) {
				alert("Registrado con éxito.");
				this.submit();
			} else {
				alert("Error al registrar.");
			}
		});
		
	});

</script>

</html>