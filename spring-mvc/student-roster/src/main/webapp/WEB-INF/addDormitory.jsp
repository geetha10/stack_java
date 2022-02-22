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
   <div class="container">
   		<div id="newDojoForm" class="mx-auto col-5">
			<h1>Add New Dormitory</h1>
			<form:form action="/dormitory/new" method="POST" modelAttribute="dormitory">
				<div class="form-group mt-3">
					<form:label path="dormName">Dormitory Name</form:label>
					<form:input path="dormName" type="text" class="form-control" />
					<form:errors path="dormName" class="text-danger" />
				</div>
				<div class="text-center">
					<input type="submit" value="Create Dojo"
						class="btn btn-primary mt-3">
				</div>
			</form:form>
		</div>
   </div>
</body>
</html>