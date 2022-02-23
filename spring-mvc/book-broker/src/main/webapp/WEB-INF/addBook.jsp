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
	<div class="container col-5">
		<div class="d-flex d-flex justify-content-between align-items-center mt-3 ">
			<h1 class="mt-3 text-center">Add New Book</h1>
			<a href="/dashboard">Back To shelves</a>
		</div>


		<form:form action="/books/new" method="POST" modelAttribute="book"
			class="mx-auto">
			<div class="form-group mt-3">
				<form:label path="title">Title</form:label>
				<form:input path="title" type="text" class="form-control" />
				<form:errors path="title" class="text-danger" />
			</div>
			<div class="form-group mt-3">
				<form:label path="author">Author</form:label>
				<form:input path="author" type="text" class="form-control" />
				<form:errors path="author" class="text-danger" />
			</div>
			<div class="form-group mt-3">
				<form:label path="userThoughts">Creator Thoughts</form:label>
				<form:textarea path="userThoughts" type="text" class="form-control"
					rows="5" />
				<form:errors path="userThoughts" class="text-danger" />
			</div>
			<form:input type="hidden" path="creator" value="${userId}"></form:input>
			<p class="text-center mt-3">
				<input type="submit" value="Save Book" class="btn btn-primary">
			</p>
		</form:form>
	</div>
</body>
</html>
