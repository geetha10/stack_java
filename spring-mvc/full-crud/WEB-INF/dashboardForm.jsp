<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Icecream Menu</h1>
	<table>
		<thead>
			<tr>
				<td>ID</td>
				<td>Flavor</td>
				<td>Price</td>
				<td>Description</td>
				<td colspan="2">Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="icecream" items="${icecreams }">
				<tr>
					<td>${icecream.getId() }</td>
					<td><a href="/icecreams/${icecream.id}">${icecream.flavor }</a></td>
					<td>${icecream.price }</td>
					<td>${icecream.description }</td>
					<td> <a href="/icecreams/edit/${icecream.id }"> Edit </a></td>
					<td>
						<form action="/icecreams/delete/${icecream.id }" method="post">
							<input type="hidden" name="_method" value="delete" />
							<button> Delete </button>
						</form>
					
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>Create Ice Cream</h1>
	<form:form action="/icecreams" method="POST"
		modelAttribute="icecream">
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
		<button>Create!</button>
	</form:form>


</body>
</html>