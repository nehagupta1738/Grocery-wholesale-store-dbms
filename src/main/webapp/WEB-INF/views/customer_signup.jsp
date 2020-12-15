<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer register</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
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
    Customer Sign up
   </div>
   <br>
  <div class="text-center">
	<div class="text-danger mb-3" style="max-width: 45rem;">
				<h4 class="alert-heading">${error}</h4>
			</div>
			</div>
<div class="container mt-5 text-center">
   <form action="customerlogin" method="post">
  <div class="form-row">
    <div class="col">
    <label for="inputAddress">First Name</label>
      <input type="text" class="form-control" placeholder="First name" name="fname" required>
    </div>
    <div class="col">
    <label for="inputAddress">Last Name</label>
      <input type="text" class="form-control" placeholder="Last name" name="lname">
    </div>
  </div>
 
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Email</label>
      <input type="email" class="form-control" id="inputEmail4" name="email" required>
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Password</label>
      <input type="password" class="form-control" id="inputPassword4" name="password" minlength="8" required >
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">Address</label>
    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" name="address">
  </div>

  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity">City</label>
      <input type="text" class="form-control" id="inputCity" name="city">
    </div>
    <div class="form-group col-md-4">
      <label for="inputState">State</label>
      <select id="inputState" class="form-control" name="state">
        <option selected>Choose...</option>
        <option>Bihar</option>
        <option>Uttar Pradesh</option>
      </select>
    </div>
    <div class="form-group col-md-2">
      <label for="inputZip">Pin</label>
      <input type="text" class="form-control" id="inputZip" name="pin" required>
    </div>
  </div>
  
  <button type="submit"  class="btn btn-success">Sign Up</button>
</form>
<br>
</div>
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