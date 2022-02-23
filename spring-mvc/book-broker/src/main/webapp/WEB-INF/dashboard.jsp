<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Title Here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container ">
		<div
			class="wecomeNote d-flex justify-content-between align-items-center mt-3">
			<p>
				Hello
				<c:out value="${userName}"></c:out>
				. Welcome to
			</p>
			<a href="/logout" class="btn btn-danger ">Logout</a>
		</div>
		<div class="mt-3 ">
			<div class="d-flex justify-content-between">
				<h1>The Book Broker!</h1>
				<a href="/books/new">Add a new book to shelf</a>
			</div>
			<div class="availableBooks">
				<p>Available books to Borrow</p>
				<table class="table table-bordered table-hover table-striped w-auto">
					<thead>
						<tr class="bg-primary">
							<th>ID</th>
							<th>Title</th>
							<th>Author name</th>
							<th>Posted By</th>
							<th>Actions</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${availableBooks}">
							<tr>
								<td>${book.id}</td>
								<td><a href="/books/${book.id}">${book.title}</a></td>
								<td>${book.author}</td>
								<td>${book.creator.userName}</td>
								<td class="d-flex align-items-center"><c:choose>
										<c:when test="${book.creator.id == userId}">
											<a href="books/${book.id}/edit">Edit</a>
											<form action="/books/delete/${book.id}" method="post">
												<input type="hidden" name="_method" value="delete" /> <input
													type="submit" value="Delete" class="btn btn-link">
											</form>
										</c:when>
										<c:otherwise>
											<form action="/books/${book.id}/borrow" method="post">
												<input type="hidden" name="_method" value="put" /> <input
													type="submit" value="Borrow" class="btn btn-link">
											</form>
										</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="borrowedBooks">
				<p>Books I'm Borrowing</p>
				<table class="table table-bordered table-hover table-striped w-auto">
					<thead>
						<tr class="bg-primary">
							<th>ID</th>
							<th>Title</th>
							<th>Author name</th>
							<th>Posted By</th>
							<th>Actions</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${allBooks}">
							<tr>
								<c:if test="${book.borrowedby.id == userId}">
									<td>${book.id}</td>
									<td><a href="/books/${book.id}">${book.title}</a></td>
									<td>${book.author}</td>
									<td>${book.creator.userName}</td>
									<td>
										<form action="/books/${book.id}/return" method="post">
											<input type="hidden" name="_method" value="put" /> <input
												type="submit" value="Return" class="btn btn-link">
										</form>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>