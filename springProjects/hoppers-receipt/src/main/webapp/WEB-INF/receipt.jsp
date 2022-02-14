<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Hopper Receipt </title>
</head>
<body>
	<h1>Customer Name: <c:out value="${name}"></c:out>
	</h1>
	<p>
	    Item Name: <c:out value="${itemName}"/>
	</p>
	<p>
	    Description: <c:out value="${description}"/>
	</p>
	<p>
	    Price: <c:out value="${price}"/>
	</p>
	<p>
	    Vendor: <c:out value="${vendor}"/>
	</p>
	
	<script type="text/javascript" src="/js/app.js"></script>
</body>
</html>