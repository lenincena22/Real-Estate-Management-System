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

	<div class="row pt-5">
		<div class="col-md-6 mx auto">
			<div class="card rounded-0">
				<div class="card-header">
					<h3 class="md-0">Login</h3>
				</div>
				<div class="card-body">
					<form class="form">
						<div class="form-group">
							<label for="">User Name</label> <input name="username"
								class="form-control rounded-0" required>
						</div>

						<div class="form-group">
							<label for="">Password</label> <input type="password"
								name="password" class="form-control rounded-0" required>
						</div>

						<div class="form-group">
							<label for="">Role</label> <select class="form-select"
								aria-label="Default select example" name="selRole1" required>
								<option value="Manager">Manager</option>
								<option value="Executive">Executive</option>
								<option value="Customer">Customer</option>
							</select>
						</div>

						<button type="button" class="btn btn-primary float-right mt-4">Login</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="container"></div>

</body>
</html>