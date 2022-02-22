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
<script src="/webjars/jquery/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<h1 class="text-center mt-3">${dorm.dormName}Dormitory</h1>
		<form action="/dormitory/${dorm.id}/addStudents" method="POST"
			class="mx-auto col-5">
			<input type="hidden" name="_method" value="put">
			<div>
				<label for="students" class="form-label">Student Names</label> <select
					name="students" class="form-select">
					<c:forEach var="OneStudent" items="${students}">
						<option value="${OneStudent.id}">${OneStudent.firstName}
						</option>
					</c:forEach>
				</select>
			</div>
			<p class="text-center mt-3">
				<input type="submit" value="Add Student" class="btn btn-primary">
			</p>
		</form>
		<table
			class="table table-bordered table-hover table-striped w-auto mx-auto mt-3">
			<thead>
				<tr class="bg-danger bg-gradient">
					<th>Id</th>
					<th>Student Name</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="OneStudent" items="${dorm.students}">
					<tr>
						<td>${OneStudent.id}</td>
						<td>${OneStudent.firstName}</td>
						<td>
							<form action="/removeStudent/dorm/${OneStudent.id}" method="post">
								<input type="hidden" name="dormId" value="${dorm.id}"/>
								<input type="hidden" name="_method" value="put" /> <input
									type="submit" value="Remove" class="btn btn-link">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>