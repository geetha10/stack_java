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
		<h1 class="mt-3">${book.title}</h1>
		<p>Description: ${book.description}</p>
		<p>Language: ${book.language}</p>
		<p>Number Of Pages: ${book.numberOfPages}</p>
	</div>
</body>
</html>