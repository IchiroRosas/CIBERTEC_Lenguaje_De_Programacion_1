<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar nueva atención</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<br>
	<div class="container">
		<h3>Nuevo registro</h3>
			<form action="LibroServlet" method="post" name="registroNuevo">
			<input type="hidden" name="type" value="register">
				<div class="mb-3">
					<label>Código</label>
					<input type="text" class="form-control" name="txtCodigo">
				</div>
				<div class="mb-3">
					<label>Nombre del Libro</label>
					<input type="text" class="form-control" name="txtNombreLibro">
				</div>
				<div class="mb-3">
					<label>Edición</label>
					<input type="text" class="form-control" name="txtEdicion">
				</div>
				<div class="mb-3">
					<label>Tipo</label>
					<input type="text" class="form-control" name="txtTipo">
				</div>
				<div class="mb-3">
					<label>Precio(S/.)</label>
					<input type="text" class="form-control" name="txtPrecio" placeholder="Ejemplo: 56.80">
				</div>
				<div class="mb-3">
					<label>Stock</label>
					<input type="text" class="form-control" name="txtStock">
				</div>
				<div class="mb-3">
					<label>Fecha de compra</label>
					<input type="date" class="form-control" name="txtFechaCompra">
				</div>
			<button type="submit" class="btn btn-primary">Registrar</button>
			<button type="button" class="btn btn-primary" onclick="window.location='LibroServlet?type=list'">Volver al Historial</button>					
			</form>
			
	</div>
	
</body>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<script type="text/javascript">	//

	$(function(){
		$("form[name='registroNuevo']").validate({
			rules:{
				txtCodigo:{
					required:true,
					minlength:5
				},
				txtNombreLibro:{
					required:true
				},
				
				txtEdicion:{
					required:true
				},
				txtTipo:{
					required:true
				},
				txtPrecio:{
					required:true
				},
				txtStock:{
					required:true
				},
				txtFechaCompra:{
					required:true
				}
			},
			messages:{
				txtCodigo:{
					required:"Ingrese código.",
					minlength:"Código debe tener almenos 5 números."
				},
				txtNombreLibro:"Ingrese nombre del libro.",
				txtEdicion:"Ingrese número de edición.",
				txtTipo:"Ingrese tipo de libro.",
				txtPrecio:"Ingrese precio",
				txtStock:"Ingrese stock.",
				txtFechaCompra:"Seleccione fecha de compra."
			},
			submitHandler:function(form){
				form.submit();
			}
			
		}); //Aquí acaba la validación
		
		$("form[name='registroNuevo']").submit(function(event){
			event.preventDefault();
			if($(this).valid()) {
				alert("Registrado con éxito.");
				this.submit();
			} else {
				alert("Error al registrar.");
			}
		});
		
	}); //Aquí acaba la función

</script>

</html>