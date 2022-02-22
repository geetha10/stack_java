<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Title Here</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1 class="mt-3 text-center">Edit Person</h1>
	<form:form action="/persons/edit/${person.id}" method="POST" modelAttribute="person" class="mx-auto col-5">
	<c:out value="Person id:${person.id}"></c:out>
	<input type="hidden" name="_method" value="put">
	
	<div class="form-group mt-3">
		<form:label path="firstName">First Name</form:label> 
		<form:input path="firstName" type="text"  class="form-control"/>
		<form:errors path="firstName" class="text-danger"/>
	</div>
	
	<div class="form-group mt-3">
		<form:label path="lastName">Last Name</form:label>
		<form:input path="lastName" type="text" class="form-control"/>
		<form:errors path="lastName" class="text-danger"/>
	</div>
	
	<p class="text-center mt-3">
		<input type="submit" value="Edit Person" class="btn btn-primary">
	</p>
</form:form>
</body>
</html>