<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.datatables.net/2.0.5/css/dataTables.dataTables.min.css"/>
</head>
<body>
<div class="container">
		<div class="row">
			<div class="col-12 text-center">
				<h3>Mantenimiento de Cursos</h3>
			</div>
			<div class="col-12">
				<button type="button" class="btn btn-primary"
					onclick="window.location='subjectRegister.jsp'">Registrar</button>
			</div>
			<br>
			<div class="col-12">
					<table id="tbProduct" class="table">
						<thead>
							<tr class="grilla_campo">
								<th></th>
								<th>Id</th>
								<th>Descripcion</th>
								<th>Stock</th>
								<th>Precio</th>
								<th>Acciones</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lstProductos}" var="p">
								<tr>
									<td>
										<c:if test="${p.stock <20 }">
											no hay stock
										</c:if>
										<c:if test="${p.stock >= 20 }">
											si hay stock
										</c:if>
									</td>
									<td>${p.id}</td>
									<td>${p.descripcion}</td>
									<td>${p.stock}</td>
									<td>${p.precio}</td>
									<td>
										<a
									href="ProductServlet?type=info&id=${p.id}"> Seleccione
								</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</div>
		</div>

		<div class="row"></div>
	</div>
	
	
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
	</script>
<script type="text/javascript"
	src="https://cdn.datatables.net/2.0.5/js/dataTables.min.js">
	</script>
	
<script type="text/javascript">
	$(document).ready(function(){
		$('#tbProduct').DataTable();
	});
</script>
</body>
</html>