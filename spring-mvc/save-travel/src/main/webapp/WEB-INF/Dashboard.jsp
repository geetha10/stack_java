<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Save Travels APP</title>
</head>
<body>
	<div class="container mx-auto">
		<h1 class="mt-5 bg-secondary p-3">Save Travels</h1>
		<div class="mt-3 ">
			<table class="table table-bordered table-hover table-striped">
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
		                <td class="text-center">
			                <a href="/expense/edit/${expense.id}">Edit </a>
			                <form action="/expense/delete/${expense.id}" method="post">
			                	<input type="hidden" name="_method" value="delete"/>
			                	<button type="button" class="btn btn-link">Delete</button>
			                </form>
		                </td>          
		            </tr>
		        </c:forEach>
		        </tbody>
	        </table>
        </div>
        <div class="form">
		<h1 class="mt-5 bg-secondary p-3 text-center">Add an Expense</h1>
		<form:form action="/expense/new" method="post" modelAttribute="expense" class="col-4 mx-auto mt-3" >
	        <div class="form-group">
	            <form:label path="expenseName">Expense Name</form:label> 
				<form:input path="expenseName"  class="form-control"/>
				<form:errors path="expenseName" class="text-danger"/>
	        </div>
	        <div class="form-group">
	            <form:label path="vendor">Vendor</form:label>
	            <form:input path="vendor" class="form-control" />
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
	</div>
</body>
</html>