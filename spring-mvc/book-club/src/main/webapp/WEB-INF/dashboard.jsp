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
	<div class="container ">
		<div class="wecomeNote d-flex justify-content-between align-items-center mt-3">
  		<h1 >Welcome <c:out value="${userName}"></c:out> </h1>
  		<a href="/logout" class="btn btn-danger ">Logout</a>
  		</div>
  		<div class="mt-3 ">
  			<div class="d-flex justify-content-between">
  				<p>Books from everyone's shelves</p>
  				<a href="/books/new">Add a new book to shelf</a>
  			</div>
			<table class="table table-bordered table-hover table-striped w-auto">
				<thead>
					<tr class="bg-primary">
						<th >ID</th>
						<th>Title</th>
			            <th>Author name</th>
			            <th>Posted By</th>
			          
		            </tr>    
				</thead>
				<tbody>
				<c:forEach var="book" items="${books}">
		            <tr>
		            	<td>${book.id}</td>
		                <td><a href="/books/${book.id}">${book.title}</a></td>
		                <td>${book.author}</td> 
		                <td>${book.creator.userName}</td>         
		            </tr>
		        </c:forEach>
		        </tbody>
	        </table>
        </div>
   </div>
</body>
</html>