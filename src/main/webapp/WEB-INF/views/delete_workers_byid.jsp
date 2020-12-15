<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin page</title>
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
	background-image: url("resources/image/admin.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}
</style>
</head>
<body>
<nav class="navbar fixed-top navbar-dark bg-dark">
		<a class="navbar-brand" href="#">E-Store</a> <span class="navbar-text">
			 <a href="logout" class="btn btn-danger">Logout</a>
		
		</span>
	</nav>

	<br>
	<br>
	<br><br>
	<div class="container text-center">
		<c:if test="${r==0}">
			<div class="alert alert-danger" role="alert">
				<h4 class="alert-heading">Not Found!</h4>
				<p>${r } worker has been deleted from the workers table</p>
			</div>
       </c:if>
       <c:if test="${r==1}">
         <div class="alert alert-success" role="alert">
				<h4 class="alert-heading">Well done!</h4>
				<p>${r } worker has been deleted from the worker table</p>
			</div>
       </c:if>
<a href="adminhome" type="button" class="btn btn-primary">go to home</a>
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