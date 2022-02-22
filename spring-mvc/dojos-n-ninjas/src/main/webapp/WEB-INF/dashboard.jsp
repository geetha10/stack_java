<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Title Here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container mx-auto">
		<div
			class="d-flex justify-content-around m-3 p-3 bg-danger bg-gradient">
			<h1>Dashboard</h1>
			<a href="/ninja/new"> Add a Ninja</a>
		</div>
		<div id="newDojoForm" class="mx-auto col-5">
			<h1>Add Dojo Locations</h1>
			<form:form action="/dojo/new" method="POST" modelAttribute="dojo">
				<div class="form-group mt-3">
					<form:label path="dojoName">First Name</form:label>
					<form:input path="dojoName" type="text" class="form-control" />
					<form:errors path="dojoName" class="text-danger" />
				</div>
				<div class="text-center">
					<input type="submit" value="Create Dojo"
						class="btn btn-primary mt-3">
				</div>
			</form:form>
		</div>
		<div id="showAllDojoLovations" class="mx-auto col-5 mt-5">
			<h1 class="bg-danger bg-gradient p-3">All Dojo Locations</h1>
			<table
				class="table table-bordered table-hover table-striped w-auto mx-auto mt-3">
				<thead>
					<tr class="bg-danger bg-gradient">
						<th>Id</th>
						<th>Location</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dojoLocation" items="${dojoLocations}">
						<tr>
							<td>${dojoLocation.id}</td>
							<td>${dojoLocation.dojoName}</td>
							<td class="d-flex align-items-center"><a
								href="/dojo/ninjas/${dojoLocation.id}">See Students</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>