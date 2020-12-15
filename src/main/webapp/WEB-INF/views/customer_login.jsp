<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
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
   position:absolute;
   bottom:0;
   width:100%;
   height:55px;   /* Height of the footer */
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
	<nav class="navbar navbar-light bg-dark">

		<span class="navbar-brand mb-0 h1">

			<h3 style="color: white">E-STORE</h3>
		</span>
	</nav>
	<br><br>
	
	<div class="card border-dark mb-3 container text-center" style="max-width: 45rem;">
  <div class="card-header">
    Customer login
   </div>
   <br>
   <div class="text-center">
	<div class="text-danger mb-3" style="max-width: 45rem;">
				<h4 class="alert-heading">${error}</h4>
			</div>
			</div>
  
		
			<form action="customer_page" method="post">
				<div class="form-group">
					<label for="exampleInputEmail1">Email address</label> <input
						type="email" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" name="email" required> <small
						id="emailHelp" class="form-text text-muted">We'll never
						share your email with anyone else.</small>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						type="password" class="form-control" id="exampleInputPassword1"
						name="password" required>
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
			<br>
		</div>
		<!-- Footer -->
<footer id="footer" class="page-footer font-small blue">

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3 footer-dark bg-dark">© Santosh Kumar:
    <a href="https://mdbootstrap.com/"> +91 123456789</a>
  </div>
  <!-- Copyright -->

</footer>
		
</body>
</html>