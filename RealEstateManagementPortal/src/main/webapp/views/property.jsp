<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Real Estate Management Portal</title>
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
		<div class="col-md-3 mx auto">
			<div class="card rounded-0">
				<div class="card-header">
					<h3 class="md-0">Create Property</h3>
				</div>
				<div class="card-body">
					<form action="/createProperty" method="post" class="form">
						<div class="form-group">
							<label for="">Property Type</label> <input name="propertyType"
								class="form-control rounded-0" required>
						</div>

						<div class="form-group">
							<label for="">Locality</label> <input name="locality"
								class="form-control rounded-0" required>
						</div>

						<div class="form-group">
							<label for="">Budget</label> <input name="budget"
								class="form-control rounded-0" required>
						</div>

						<button type="submit" class="btn btn-primary float-right">Create</button>
					</form>
				</div>
			</div>
		</div>

		<div class="col-md-3 mx auto">
			<div class="card rounded-0">
				<div class="card-header">
					<h3 class="md-0">Get All Properties</h3>
				</div>
				<div class="form-group">
					<form action="/getAllProperties">
						<button type="submit" class="btn btn-primary float-right">Get</button>
					</form>
				</div>

			</div>
		</div>

		<div class="col-md-3 mx auto">
			<div class="card rounded-0">
				<div class="card-header">
					<h3 class="md-0">Get Properties By Type</h3>
				</div>
				<div class="card-body">
					<form action="/getAllPropertiesByType/{propertyType}" class="form">
						<div class="form-group">
							<label for="">Property Type</label> <input name="propertyType"
								class="form-control rounded-0" required>
						</div>
						<button type="submit" class="btn btn-primary float-right">Get</button>
					</form>
				</div>
			</div>
		</div>

		<div class="col-md-3 mx auto">
			<div class="card rounded-0">
				<div class="card-header">
					<h3 class="md-0">Get Properties By Locality</h3>
				</div>
				<div class="card-body">
					<form action="/getAllPropertiesByLocality/{locality}" class="form">
						<div class="form-group">
							<label for="">Locality</label> <input name="locality"
								class="form-control rounded-0" required>
						</div>
						<button type="submit" class="btn btn-primary float-right">Get</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<br>
	<h3>Properties</h3>
	
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
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
				<c:forEach items="${properties}" var="item">
					<tr>
						<td>${item.id}</td>
						<td>${item.propertyType}</td>
						<td>${item.locality}</td>
						<td>${item.budget}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="container"></div>

</body>
</html>