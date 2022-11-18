<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Real Estate Management Portal</title>
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a href="/app" class="navbar-brand">Real Estate</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a href="/property" class="nav-link">Property</a></li>
					<li class="nav-item"><a href="/customer" class="nav-link">Customer</a></li>
					<li class="nav-item"><a href="/executive" class="nav-link">Executive</a></li>
					<li class="nav-item"><a href="/manager" class="nav-link">Manager</a></li>
				</ul>
				<ul class="navbar-nav d-flex">
					<li class="nav-item"><a href="/login" class="nav-link">Logout</a></li>
					<li class="nav-item"><a href="/login" class="nav-link">Login</a></li>
					<li class="nav-item"><a href="/register" class="nav-link">Register</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<h3 class="error">${message}</h3>
	<div class="row pt-4">
		<div class="col-md-4 mx auto">
			<div class="card rounded-0">
				<div class="card-header">
					<h3 class="md-0">Get Executive Details</h3>
				</div>
				<div class="card-body">
					<form action="/getExecutiveDetails" class="form">
						<div class="form-group">
							<label for="">Executive Id</label> <input type="number" name="execid"
								class="form-control rounded-0" required>
						</div>
						<button type="submit" class="btn btn-primary float-right">Get</button>
					</form>
				</div>
			</div>
		</div>

		<div class="col-md-4 mx auto">
			<div class="card rounded-0">
				<div class="card-header">
					<h3 class="md-0">Get Customer Details</h3>
				</div>
				<div class="card-body">
					<form action="/executive/getCustomerDetails" class="form">
						<div class="form-group">
							<label for="">Customer Id</label> <input type="number" name="custid"
								class="form-control rounded-0" required>
						</div>
						<button type="submit" class="btn btn-primary float-right">Get</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="row pt-4">
		<div class="col-md-4 mx auto">
			<div class="card rounded-0">
				<div class="card-header">
					<h3 class="md-0">Executive Details</h3>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item"><b>Name: </b>${executive.name}</li>
					<li class="list-group-item"><b>Contact No: </b>${executive.contactNumber}</li>
					<li class="list-group-item"><b>Locality: </b>${executive.locality}</li>
					<li class="list-group-item"><b>Email ID: </b>${executive.emailId}</li>
				</ul>
			</div>
		</div>

		<div class="col-md-4 mx auto">
			<div class="card rounded-0">
				<div class="card-header">
					<h3 class="md-0">Customer Details</h3>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item"><b>Name: </b>${customer.name}</li>
					<li class="list-group-item"><b>Address: </b>${customer.address}</li>
					<li class="list-group-item"><b>Email ID: </b>${customer.emailId}</li>
					<li class="list-group-item"><b>Contact No: </b>${customer.contactNumber}</li>
				</ul>
			</div>
		</div>
	</div>

	<div class="container"></div>
</body>
</html>