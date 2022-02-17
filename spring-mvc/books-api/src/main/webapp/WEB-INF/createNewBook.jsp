<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Books API</title>
</head>
<body>
	<div class="container mx-auto">
		<h1 class="text-center">Create a new Book</h1>
		<form:form action="/books/new" method="post" modelAttribute="book" >
	        <div class="form-group mx-auto">
	            <form:label path="title">Title</form:label> 
				<form:errors path="title" class="form-control text-danger"></form:errors>
				<form:input path="title"  class="form-control"/>
	        </div>
	        <div class="form-group">
	            <form:label path="description">Description</form:label>
	            <form:errors path="description" class="form-control text-danger"></form:errors>
	            <form:textarea path="description" rows="5"  class="form-control"/>
	        </div>
	        <div class="form-group">
	            <form:label path="language">Language</form:label>
	            <form:errors path="language" class="form-control text-danger"></form:errors>
	            <form:input path="language" class="form-control" />
	        </div>
	        <div class="form-group">
	            <form:label path="numberOfPages">Number of pages</form:label>
	            <form:errors path="numberOfPages" class="form-control text-danger"></form:errors>
	            <form:input path="numberOfPages" class="form-control" />
	        </div>
	        <p class="text-center m-3">
	            <input type="submit" value="Save Book" class="btn btn-primary">
	        </p>
    </form:form>
	</div>
</body>
</html>