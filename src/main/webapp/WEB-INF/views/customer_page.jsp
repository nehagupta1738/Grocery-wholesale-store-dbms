<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
	crossorigin="anonymous" />

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

<meta charset="ISO-8859-1">
<title>Customer page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar fixed-top navbar-dark bg-dark">
		<a class="navbar-brand" href="#">E-Store</a> <span class="navbar-text">
			<a data-toggle="modal" data-target="#viewcart" style="margin: 15px;">
				<i class="fas fa-cart-plus" style="color: white"> </i>Cart
		</a> <a data-toggle="modal" data-target="#viewprofile"
			style="margin: 15px;"> <i class="fas fa-user-edit"
				style="color: white"></i>Profile
		</a> <a href="customerlogout" class="btn btn-danger">Logout</a>
		
		</span>
	</nav>

	<div class="container mt-5 text-center">
		<br>
		<br>
		<div class="card text-white bg-dark mb-3 container text-center"
			style="max-width: 50rem;" id="home">
			<h2>Welcome to the customer page</h2>
			<div class="card-header">${email }</div>
		</div>
		<br>

		<!-- **********************************************************************************************************************************-->

		<div class="container text-center">

			<div class="container">
				<a class="btn btn-primary" data-toggle="collapse"
					href="#collapseproduct" role="button" aria-expanded="false"
					aria-controls="collapseExample"> View all Product </a>

				<div class="collapse" id="collapseproduct">
					<div class="card card-body">

						<table style="width: 100%">
							<thead class="thead-dark">
								<tr>
									<th scope="col">ProductId</th>
									<th scope="col">Name</th>
									<th scope="col">CostPrise</th>
									<th scope="col">Customer Review</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="cp" items="${cuspro}">
									<tr>
										<th><c:out value="${cp.productid}"></c:out></th>
										<td><c:out value="${cp.name}"></c:out></td>
										<td><c:out value="${cp.sp}"></c:out></td>
										<td><a href="visitreview/${cp.productid}"><i class="fas fa-chart-bar text-success"></i></a></td>
									</tr>
								</c:forEach>

							</tbody>

						</table>
						<br>


					</div>
				</div>
			</div>

		</div>
		<!-- ******************************************************************************-->
		<!-- cart view-->
		<!-- Modal -->
		<div class="modal fade" id="viewcart" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<table style="width: 100%">
							<thead class="thead-dark">
								<tr>

									<th scope="col">ProductName</th>
									<th scope="col">Quantity</th>
									<th scope="col">Total Prize</th>
									<th scope="col">Delete</th>
									<th scope="col">Order Now</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="c" items="${cart}">
									<tr>

										<td><c:out value="${c.productname}"></c:out></td>
										<td><c:out value="${c.quantity}"></c:out></td>
										<td><c:out value="${c.prise}"></c:out></td>
										<td><a href="delete/${c.cartid }"><i
												class="fas fa-trash-alt text-danger"></i></a></td>
										<td><a href="confirmorder/${c.cartid }"><i
												class="fas fa-check-circle text-success"></i></a></td>

									</tr>

								</c:forEach>


							</tbody>

						</table>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>

		<!-- ********************************************************************************************************************************************************* -->
		<!-- profile view-->
		<!-- Modal -->
		<div class="modal fade" id="viewprofile" tabindex="-1"
			aria-labelledby="exampleModalLabel02" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel02">Profile</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="container mt-5 text-center">
							<form action="customer_profile_updated" method="post">
								<div class="form-row">
									<div class="col">
										<label for="inputAddress">First Name</label> <input
											type="text" class="form-control" value="${customer.fname }"
											name="fname">
									</div>
									<div class="col">
										<label for="inputAddress">Last Name</label> <input type="text"
											class="form-control" value="${customer.lname}" name="lname">
									</div>
								</div>

									<div class="form-group ">
										<label for="inputEmail4">Email</label> <input type="text" class="form-control" value="${ email}"
										readonly name="email">
									</div>
							
								<div class="form-group">
									<label for="inputAddress">Address</label> <input type="text"
										class="form-control" id="inputAddress"
										value="${customer.address }" name="address">
								</div>

								<div class="form-row">
									<div class="form-group col-md-4">
										<label for="inputCity">City</label> <input type="text"
											class="form-control" id="inputCity" value ="${customer.city }" name="city">
									</div>
									<div class="form-group col-md-4">
										<label for="inputState">State</label> <input type="text"
											class="form-control" value="${customer.state}" name="state">
							
									</div>
									<div class="form-group col-md-4">
										<label for="inputZip">Pin</label> <input type="text"
											class="form-control" id="inputZip" value ="${customer.pin}" name="pin" required>
									</div>
								</div>
								<button type="submit" class="btn btn-success">Save changes</button>
						  </form>
						</div>
						
					</div>
				</div>
			</div>

		</div>

		<!-- ********************************************************************************************************************************************************* -->

		<br>
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#exampleModal" aria-expanded="false"
			aria-controls="collapseExample">Add to Cart</button>
		<br>
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Enter Product</h5>

						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="update_cart" method="post">
							<div class="form-row">
								<div class="col">

									<input type="text" class="form-control" value="${ email}"
										readonly name="customeremail">
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="Productid" required
										name="productid">
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="Quantity" required
										name="quantity">
								</div>
							</div>


							<br>
							<button type="submit" class="btn btn-success">Add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- **********************************************************************************************************************************-->
	<br />
	<div class="container text-center">

		<div class="container">
			<a class="btn btn-primary" data-toggle="collapse"
				href="#collapsehistry" role="button" aria-expanded="false"
				aria-controls="collapseExample">view history</a>

			<div class="collapse" id="collapsehistry">
				<div class="card card-body">

					<table style="width: 100%">
						<thead class="thead-dark">
							<tr>
								<th scope="col">ProductId</th>
								<th scope="col">ProductName</th>
								<th scope="col">Quantity</th>
								<th scope="col">Prize</th>
								<th scope="col">Review</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="h" items="${histry}">
								<tr>
									<th><c:out value="${h.productid}"></c:out></th>
									<td><c:out value="${h.productname}"></c:out></td>
									<td><c:out value="${h.quantity}"></c:out></td>
									<td><c:out value="${h.prise}"></c:out></td>
									<td><a href="review/${h.histryid}"><i class="far fa-edit text-success"></i></a></td>
								</tr>
							</c:forEach>

						</tbody>

					</table>
					<br>


				</div>
			</div>
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
