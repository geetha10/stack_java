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
   <div id="container" class="mx-auto col-5 mt-5">
			<h1 class="bg-danger bg-gradient p-3"> ${dojo.dojoname} Location ninjas</h1>
			<table class="table table-bordered table-hover table-striped w-auto mx-auto mt-3">
				<thead>
					<tr class="bg-danger bg-gradient">
						<th >Id</th>
						<th>First Name</th>
			            <th>Last Name</th>
			            <th>Age</th>
		            </tr>    
				</thead>
				<tbody>
				<c:forEach var="ninja" items="${ninjas}">
		            <tr>
		            	<td>${ninja.id}</td>
		            	<td>${ninja.firstName}</td>
		                <td>${ninja.lastName}</td>
		                <td>${ninja.age}</td>          
		            </tr>
		        </c:forEach>
		        </tbody>
	        </table>
		</div>
</body>
</html>