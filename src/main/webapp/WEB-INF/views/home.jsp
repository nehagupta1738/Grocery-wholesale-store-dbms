<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<style>
#footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 55px; /* Height of the footer */
}

body {
	background-image: url("resources/image/home.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}
</style>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">E-STORE</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">

				
			</ul>
			<span class="navbar-text"> Not yet logged in! </span>
		</div>
	</nav>

	<br>
	<br>
	<br>

	<div class="col d-flex justify-content-center">


		<!-- <div class="container text-center"> -->
		<div class="card text-danger border-danger mb-3"
			style="max-width: 540px;">
			<div class="row no-gutters">
				<div class="col-md-6">
					<img src="resources/image/adminhome.png"
						class="card-img" alt="...">
				</div>

				<div class="col-md-6">
					<div class="card-body">
						<h5 class="card-title">Admin Page</h5>
						<p class="card-text">Please login here to see and do the
							change in product,customer,company,godawns and other details</p>
						<a type="button" href="admin_login" class="btn btn-danger btn-sm">Signin</a>


					</div>
				</div>

			</div>
		</div>

	</div>
	<br>
	<br>
	<div class="col d-flex justify-content-center">

		<div class="card text-danger border-danger mb-3"
			style="max-width: 540px;">
			<div class="row no-gutters">
				<div class="col-md-6">
					<div class="card-body">
						<h5 class="card-title">Customer Page</h5>
						<p class="card-text">Please signup here to buy the products ,
							if already did then signin</p>
						<div class="btn-group" role="group" aria-label="Basic example">
							<a type="button" href="customersignup" class="btn btn-danger">Signup</a>
							<a type="button" href="customer_signin" class="btn btn-danger">Signin</a>

						</div>

					</div>
				</div>
				<div class="col-md-6">
					<img src="resources/image/customerhome.jpg"
						class="card-img" alt="...">
				</div>

			</div>
		</div>
	</div>

	<footer id="footer" class="page-footer font-small blue">
		<br>
		<!-- Copyright -->
		<!-- <font color="WHITE"> -->
		<marquee>
			<font color="WHITE"> Welcome to the E-STORE online website .
				Our team of professional captioners are ready to get to work as soon
				as you submit your order.</font>
		</marquee>
		<!-- </font> -->
		<!-- Copyright -->

	</footer>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
		integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>
</html>