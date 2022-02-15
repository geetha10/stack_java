<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css"/>
<title>Counter</title>
</head>
<body>
	<div class="container mx-auto">
		<h1 class="text-center m-3">
			You have visited http://localhost:8080/counter ${count} times
		</h1>
	</div>
</body>
</html>