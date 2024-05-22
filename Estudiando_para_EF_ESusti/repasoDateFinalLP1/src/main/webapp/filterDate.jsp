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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
						<%
						List<Subject> listSubject = (List<Subject>) request.getAttribute("dataSubject");
						%>
	<div
		class="container min-vh-100 d-flex justify-content-center align-items-center">
		<div class="row">
			<div class="col-12">
			</div>

			<div class="col-12">
			<form action="SubjectServlet">
			<input type="hidden" name="type" value="filterDate" id="date">
			<input type="date" name="dtStart" id="date">
			<input type="date" name="dtEnd" id="date"><button type="submit" class="btn btn-primary">filtrar</button></form>
			
				<table class="table">
					<thead>
						<tr>
							<th>Nombre del curso</th>
							<th>Cantidad de vacantes</th>
							<th>Fecha de inicio</th>
						</tr>
					</thead>
					<tbody>
						<%
						if (listSubject != null) {
							for (Subject item : listSubject) {
						%>
						<tr>
							<td><%=item.getName()%></td>
							<td><%=item.getAvailable()%></td>
							<td><%=item.getDate()%></td>
						</tr>
						<%
						}
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
		
	</script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/2.0.5/js/dataTables.min.js">
		
	</script>
</body>
</html>