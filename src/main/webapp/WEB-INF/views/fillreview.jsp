<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer page</title>
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
	<br>
	<br><div class="card border-dark mb-3 container text-center" style="max-width: 45rem;">
	
        <br>
	    <form action="/projectDbms/reviewadded" method="post">
  <div class="form-row">
    <div class="col">
									<input type="text" class="form-control" value="${email}" readonly
										name="email">
								</div>
								<div class="col">
									<input type="text" class="form-control" value="${productid}" readonly
										name="productid">
								</div></div>
  <br>
  <div class="form-group">
    <label for="exampleFormControlTextarea1">Description</label>
    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="description" required></textarea>
  </div>
  <button type="submit" class="btn btn-success">Submit</button>
</form>
<br>
	</div>	
		<!-- <a href="customerhome" type="button" class="btn btn-primary">go to home</a> -->
		
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