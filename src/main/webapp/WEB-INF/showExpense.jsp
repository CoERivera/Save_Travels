<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
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
<style>
	.table, .table tbody, .table tr, .table td{
		border:none;
	}
</style>
</head>
<body>
	<div class="container mt-5">
		<div class="d-flex justify-content-between">
			<h1 style="color: blue;">Expense Details</h1>
			<h2>
				<a href="/expenses">Go back</a>
			</h2>
		</div>
		<div class="card-body mt-5">
			<table class="table">
				<tbody>
					<tr>
						<td>Expense Name:</td>
						<td><c:out value="${expense.getExpenseName()}" /></td>
					</tr>
					<tr>
						<td>Description:</td>
						<td><c:out value="${expense.getDescription()}" /></td>
					</tr>
					<tr>
						<td>Vendor:</td>
						<td><c:out value="${expense.getVendorName()}" /></td>
					</tr>
					<tr>
						<td>Amount Spent:</td>
						<td><c:out value="${expense.getFormattedAmount()}" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>