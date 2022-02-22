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
	<div class="container mx-auto">
		<h1>Save Travels</h1>
		<div class="mt-3 ">
			<table class="table table-bordered table-hover table-striped w-auto">
				<thead>
					<tr class="bg-primary">
						<th >ID</th>
						<th>Expense</th>
			            <th>Vendor</th>
			            <th>Description</th>
			            <th>Amount</th>	
			            <th>Actions</th>
		            </tr>    
				</thead>
				<tbody>
				<c:forEach var="expense" items="${expenses}">
		            <tr>
		            	<td>${expense.id}</td>
		                <td>${expense.expenseName}</td>
		                <td>${expense.vendor}</td> 
		                <td>${expense.description}</td>
		                <td>${expense.amount}</td> 
		                <td class="d-flex align-items-center">
			                <a href="/expense/edit/${expense.id}">Edit </a>
			                <form action="/expense/delete/${expense.id}" method="post">
			                	<input type="hidden" name="_method" value="delete"/>
			       
			                	<input type="submit" value="Delete" class="btn btn-link">
			                </form>
		                </td>          
		            </tr>
		        </c:forEach>
		        </tbody>
	        </table>
        </div>
        <div class="form">
		<h1>Add an Expense</h1>
		<form:form action="/expense/new" method="post" modelAttribute="expense" class="col-4  mt-3" >
	        <div class="form-group">
	            <form:label path="expenseName">Expense Name</form:label> 
				<form:input path="expenseName" type="text" class="form-control"/>
				<form:errors path="expenseName" class="text-danger"/>
	        </div>
	        <div class="form-group">
	            <form:label path="vendor">Vendor</form:label>
	            <form:input path="vendor" type="text" class="form-control" />
	            <form:errors path="vendor" class="text-danger"/>
	        </div>
	        <div class="form-group">
	            <form:label path="amount">Amount</form:label>
	            <form:input path="amount" type="number" class="form-control"/>
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
	</div>
</body>
</html>