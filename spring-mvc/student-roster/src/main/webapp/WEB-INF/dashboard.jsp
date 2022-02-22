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
		<div class="bg-danger bg-gradient p-3">
			<h1>Dormitory App Dashboard</h1>
		</div>
		<div class="addNew d-flex justify-content-around m-5">
			<a href="/student/new" class="btn btn-primary"> Add a Student</a>
			<a href="/dormitory/new" class="btn btn-primary"> Add a Dormitory</a>
		</div>
		<div id="showAllDojoLovations" class="mx-auto col-5 mt-5">
			<h1 class="bg-danger bg-gradient p-3">All Avialable Dormitories</h1>
			<table
				class="table table-bordered table-hover table-striped w-auto mx-auto mt-3">
				<thead>
					<tr class="bg-danger bg-gradient">
						<th>Id</th>
						<th>Dormitory</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dormitory" items="${dormitories}">
						<tr>
							<td>${dormitory.id}</td>
							<td>${dormitory.dormName}</td>
							<td class="d-flex align-items-center"><a
								href="/dormitory/${dormitory.id}">Add Students</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>