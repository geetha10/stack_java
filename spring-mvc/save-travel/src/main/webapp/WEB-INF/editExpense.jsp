<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Save Tavels APP</title>
</head>
<body>
	<div class="container mx-auto col-4">
		<h1 class="text-center">Edit an Expense</h1>
		<form:form action="/expense/update/${expense.id}" method="post" modelAttribute="expense" >
	        <div class="form-group mx-auto">
	            <form:label path="expenseName">Expense Name</form:label> 
				<form:input path="expenseName"  class="form-control"/>
				<form:errors path="expenseName" class="text-danger"/>
	        </div>
	        <div class="form-group">
	            <form:label path="vendor">Vendor</form:label>
	            <form:input path="vendor" class="form-control"/>
	            <form:errors path="vendor" class="text-danger"/>
	        </div>
	        <div class="form-group">
	            <form:label path="amount">Amount</form:label>
	            <form:input path="amount" class="form-control"/>
	            <form:errors path="amount" class="text-danger"/>
	        </div>
	        <div class="form-group">
	            <form:label path="description">Description</form:label>
	            <form:textarea path="description" rows="5"  class="form-control"/>
	            <form:errors path="description" class="text-danger"/>
	        </div>
	        <p class="text-center m-3">
	            <input type="submit" value="Save Expense" class="btn btn-primary">
	        </p>
    </form:form>
	</div>
</body>
</html>