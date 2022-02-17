<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Show One</h1>
	<ul>
		<li> Flavor : ${icecream.flavor }</li>
		<li> Price : ${icecream.price }</li>
		<li> Description : ${icecream.description }</li>
	</ul>
</body>
</html>