<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css"/>
<title>Omikuji Fortune Telling App</title>
</head>
<body>
	<div class="container mx-auto">
		<h1 class="text-center mt-3">Here's your Omikuji</h1>
		<p>
			In ${choosedNumber} years, you will live in ${city}
			with ${personName} as your roommate, selling ${hobby} for living. 
			The next time you see a ${thing}, you will have a good luck.
			Also, ${niceThing}
		</p>
        
	</div>
</body>
</html>