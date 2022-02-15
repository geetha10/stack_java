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
		<h1 class="text-center">Send an Omikuji!</h1>
		<form action="/processOmikuji" method="post"> 
	        <div class="form-group">
	            <label for="choosedNumber">Pick any number from 5 to 25</label>
	            <input class="form-control" name="choosedNumber" type="number" min="5" max="25" step="1">
	        </div>
	        <div class="form-group">
	            <label for="city">Enter the name of any city</label>
	            <input class="form-control" name="city" type="text">
	        </div>
	        <div class="form-group">
	            <label for="personName">Enter the name of any real person</label>
	            <input class="form-control" name="personName" type="text">
	        </div>
	        <div class="form-group">
	            <label for="hobby">Enter professional endeavor or hobby</label>
	            <input class="form-control" name="hobby" type="text">
	        </div>
	        <div class="form-group">
	            <label for="thing" >Enter any type of living thing</label>
	            <input class="form-control" name="thing" type="text">
	        </div>
	        <div class="form-group">
	            <label for="niceThing" >Say something nice to someone</label>
	            <textarea class="form-control" name="niceThing" rows="5"></textarea>
	        </div>
	        <p class="text-center m-3">
	            <input type="submit" value="Send" class="btn btn-primary">
	        </p>
    </form>
	</div>
</body>
</html>