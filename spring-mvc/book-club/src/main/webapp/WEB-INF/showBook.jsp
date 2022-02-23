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
	<div class="container col-6">
		<div class="d-flex d-flex justify-content-between align-items-center mt-3 ">
			<h1>${book.title}</h1>
			<a href="/dashboard">Back To shelves</a>
		</div>
		<c:if test="${book.creator.id == userId}">
			<p>You read read <span class="text-primary">${book.title}</span> by <span class="text-success">${book.author}</span></p>
			<p>Here are your thoughts:</p>
		</c:if>
		<c:if test="${book.creator.id != userId}">
		<p><span class="text-danger">${book.creator.userName}</span> read <span class="text-primary">${book.title}</span> by <span class="text-success">${book.author}</span></p>
		<p>Here are ${book.creator.userName} thoughts:</p>
		</c:if>
		<div class="border-bottom border-top mt-5">
			<p class="mt-3">${book.userThoughts}</p>
		</div>
		<c:if test="${book.creator.id == userId}">
			<div class="d-flex justify-content-end">
				<a href="/books/${book.id}/edit" class="btn btn-primary mt-3"> Edit</a>
			</div>
		</c:if>
	</div>
</body>
</html>