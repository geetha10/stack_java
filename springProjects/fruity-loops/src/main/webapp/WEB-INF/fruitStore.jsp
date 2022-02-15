<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css"/>
<title>Geetha Fruit Store</title>
</head>
<body>
	<div class="container mx-auto">
		<h1 class="text-center">Fruit Store</h1>
		<div class="p-5 bg-secondary">
		<table class="table table-bordered table-hover  mx-auto w-auto bg-white">
			<thead>
				<tr>
					<th>Name</th>
		            <th>Price</th>
	            </tr>    
			</thead>
			<tbody>
			<c:forEach var="fruit" items="${fruits}">
	            <tr>
	                <td>${fruit.name}</td>
	                <td>${fruit.price}</td>             
	            </tr>
	        </c:forEach>
	        </tbody>
        </table>
        </div>
	</div>
</body>
</html>