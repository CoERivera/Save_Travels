<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<title>Save Travels</title>
</head>
<body>
	<div class="container mt-5">
		<h1 style="color: blue;">Save Travels</h1>
		<table
			class="table table-striped table-success table-bordered border-success mt-5">
			<thead>
				<tr>
					<th scope="col">Expense</th>
					<th scope="col">Vendor</th>
					<th scope="col">Amount</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${expenses}">
					<tr>
						<td><a href="/expenses/${expense.getId()}"><c:out value="${expense.getExpenseName()}" /></a></td>
						<td><c:out value="${expense.getVendorName()}" /></td>
						<td><c:out value="${expense.getFormattedAmount()}" /></td>
						<td class="d-flex justify-content-around">
							<a href="expenses/${expense.getId()}/edit">
								<button  class="btn btn-warning">Edit</button>
							</a> 
							<form:form action="/expenses/${expense.getId()}" method="post">
								<input type="hidden" name="_method" value="delete">
								<input class="btn btn-danger" type="submit" value="Delete">
							</form:form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="card-body mt-5">
			<h2 style="color: blue;">Add an Expense:</h2>
			<h4 style="color: red;">fields must not be blank</h4>
			<form:form class="mt-4" action="/expenses" method="post"
				modelAttribute="expense">
				<div class="form-group mt-3">
					<form:label path="expenseName">Expense Name:</form:label>
					<form:errors style="color:red;" path="expenseName" />
					<form:input class="form-control mt-1" path="expenseName" />
				</div>
				<div class="form-group mt-3">
					<form:label path="vendorName">Vendor:</form:label>
					<form:errors style="color:red;" path="vendorName" />
					<form:input class="form-control mt-1" path="vendorName" />
				</div>
				<div class="form-group mt-3">
					<form:label path="amount">Amount (do not include $):</form:label>
					<form:errors style="color:red;" path="amount" />
					<form:input class="form-control mt-1" path="amount" />
				</div>
				<div class="form-group mt-3">
					<form:label path="description">Description:</form:label>
					<form:errors style="color:red;" path="description" />
					<form:textarea class="form-control mt-1" rows="3"
						style="resize:none;" path="description" />
				</div>
				<div class="d-flex justify-content-end">
					<input class="btn btn-success mt-3" type="submit"
						value="Create Expense">
				</div>

			</form:form>

		</div>
	</div>
</body>
</html>