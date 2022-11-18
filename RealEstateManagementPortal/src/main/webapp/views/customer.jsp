<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
					<h3 class="md-0">Create Customer</h3>
				</div>
				<div class="card-body">
					<form action="/createCustomer" method="post" class="form">
						<div class="form-group">
							<label for="">Name</label> <input name="name"
								class="form-control rounded-0" required>
						</div>

						<div class="form-group">
							<label for="">Address</label> <input name="address"
								class="form-control rounded-0" required>
						</div>

						<div class="form-group">
							<label for="">Email Id</label> <input name="emailId"
								class="form-control rounded-0" required>
						</div>

						<div class="form-group">
							<label for="">Contact Number</label> <input name="contactNumber"
								class="form-control rounded-0" required>
						</div>

						<button type="submit" class="btn btn-primary float-right">Create</button>
					</form>
				</div>
			</div>
		</div>

		<div class="col-md-4 mx auto">
			<div class="card rounded-0">
				<div class="card-header">
					<h3 class="md-0">Assign Requirements</h3>
				</div>

				<div class="card-body">
					<form action="/assignRequirements" class="form">
						<div class="form-group">
							<label for="">Customer Id</label> <input type="number"
								name="customerId" value="put" class="form-control rounded-0"
								required>
						</div>

						<div class="form-group">
							<label for="">Requirement Id</label> <input type="number"
								name="requirementId" class="form-control rounded-0" value="put"
								required>
						</div>

						<button type="submit" class="btn btn-primary float-right">Assign</button>
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
					<form action="/getCustomerDetails" class="form">
						<div class="form-group">
							<label for="">customer Id</label> <input type="number"
								name="custid" class="form-control rounded-0" required>
						</div>
						<button type="submit" class="btn btn-primary float-right">Get</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="row pt-4">
		<div class="col-md-3 mx auto">
			<div class="card rounded-0">
				<div class="card-header">
					<h3 class="md-0">Get All Customers</h3>
				</div>
				<div class="card-body">
					<form action="/getAllCustomers">
						<button type="submit" class="btn btn-primary float-right">Get</button>
					</form>
				</div>
			</div>
		</div>

		<div class="col-md-3 mx auto">
			<div class="card rounded-0">
				<div class="card-header">
					<h3 class="md-0">Get All Requirements</h3>
				</div>
				<div class="card-body">
					<form action="/customer/getAllRequirements">
						<button type="submit" class="btn btn-primary float-right">Get</button>
					</form>
				</div>
			</div>
		</div>

		<div class="col-md-3 mx auto">
			<div class="card rounded-0">
				<div class="card-header">
					<h3 class="md-0">Get All Properties</h3>
				</div>
				<div class="card-body">
					<form action="/customer/getAllProperties">
						<button type="submit" class="btn btn-primary float-right">Get</button>
					</form>
				</div>
			</div>
		</div>

		<div class="col-md-3 mx auto">
			<div class="card rounded-0">
				<div class="card-header">
					<h3 class="md-0">Customer Details</h3>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item"><b>Name: </b> ${cust.name}</li>
					<li class="list-group-item"><b>Address: </b> ${cust.address}</li>
					<li class="list-group-item"><b>Email Id: </b> ${cust.emailId}</li>
					<li class="list-group-item"><b>Contact Number: </b>${cust.contactNumber}</li>
					<li>
						<ul class="list-group list-group-flush">
							<li><b>Requirements</b></li>
							<c:forEach items="${cust.requirements}" var="item">
								<li class="list-group-item"><b>Id: </b>${item.id}</li>
								<li class="list-group-item"><b>Property Type: </b>${item.propertyType}</li>
								<li class="list-group-item"><b>Locality: </b>${item.locality}</li>
								<li class="list-group-item"><b>Budget: </b>${item.budget}</li>
								<br>
							</c:forEach>
						</ul>
					</li>
				</ul>
			</div>
		</div>

	</div>

	<br>


	<h3>Customers</h3>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Address</th>
					<th scope="col">Email Id</th>
					<th scope="col">Contact Number</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customers}" var="customer">
					<tr>
						<td>${customer.id}</td>
						<td>${customer.name}</td>
						<td>${customer.address}</td>
						<td>${customer.emailId}</td>
						<td>${customer.contactNumber}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<br>
	<h3>Requirements</h3>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Property Type</th>
					<th scope="col">Locality</th>
					<th scope="col">Budget</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requirements}" var="requirement">
					<tr>
						<td>${requirement.id}</td>
						<td>${requirement.propertyType}</td>
						<td>${requirement.locality}</td>
						<td>${requirement.budget}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<br>
	<h3>Properties</h3>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Property Type</th>
					<th scope="col">Locality</th>
					<th scope="col">Budget</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${properties}" var="property">
					<tr>
						<td>${property.id}</td>
						<td>${property.propertyType}</td>
						<td>${property.locality}</td>
						<td>${property.budget}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="container"></div>
</body>
</html>