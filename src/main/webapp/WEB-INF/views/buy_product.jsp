<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customer page</title>
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
	background-image: url("https://i.ibb.co/SxNKrZ9/admin.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}
</style>
</head>
<body>
<nav class="navbar fixed-top navbar-dark bg-dark">
		<a class="navbar-brand" href="#">E-Store</a> <span class="navbar-text">
			 <a href="customerlogout" class="btn btn-danger">Logout</a>
		
		</span>
	</nav>

	<br>
	<br>
	<br><br>
<div class="container text-center">
         <div class="alert alert-success" role="alert">
				<h4 class="alert-heading">Order Placed</h4>
				<p>Thank you for being our valued customer. We are so grateful for the pleasure of serving you and hope we met your expectations. </p>
			</div>
			<a href="/projectDbms/customerhome" type="button" class="btn btn-primary">go to home</a>
			
    </div>
    <!-- Footer -->
<footer id="footer" class="page-footer font-small blue">

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3 footer-dark bg-dark">© Santosh Kumar:
    <a href="https://mdbootstrap.com/"> +91 123456789</a>
  </div>
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