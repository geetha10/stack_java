<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Books API</title>
</head>
<body>
	<div class="container mx-auto">
		<h1 class="text-center">Book Store</h1>
		<div class="p-5 bg-secondary">
		<table class="table table-bordered table-hover  mx-auto w-auto bg-white">
			<thead>
				<tr>
					<th>Title</th>
		            <th>Description</th>
		            <th>Language</th>
		            <th>Pages</th>	
	            </tr>    
			</thead>
			<tbody>
			<c:forEach var="book" items="${books}">
	            <tr>
	                <td> <a href="/books/${book.id}">${book.title}</a></td>
	                <td>${book.description}</td> 
	                <td>${book.language}</td>
	                <td>${book.numberOfPages}</td>             
	            </tr>
	        </c:forEach>
	        </tbody>
        </table>
        </div>
	</div>
</body>
</html>