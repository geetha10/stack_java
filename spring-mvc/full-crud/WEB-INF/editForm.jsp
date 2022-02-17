<%@ page isErrorPage="true" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Edit Ice Cream</h1>
	<form:form action="/icecreams/edit/${icecream.id }" method="POST" modelAttribute="icecream">
	<input type="hidden" name="_method" value="put" />
		<div>
			<form:label path="flavor"> Flavor </form:label>
			<form:input type="text" path="flavor" />
			<form:errors path="flavor" />
		</div>
		<div>
			<form:label path="price"> Price </form:label>
			<form:input type="number" step="0.01" path="price" />
			<form:errors path="price" />
		</div>
		<div>
			<form:label path="description"> Description </form:label>
			<form:textarea path="description"></form:textarea>
		</div>
		<button> Edit!</button>
	</form:form>


</body>
</html>