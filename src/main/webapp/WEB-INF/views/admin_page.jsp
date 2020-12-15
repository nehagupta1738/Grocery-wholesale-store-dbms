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
<title>Admin page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">E-STORE</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="#adminhome">Home <span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="#admincustomer">Customer
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#adminproduct">Product</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#admincompany">Company</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#adminworkers">Workers</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#adminowner">godawn owner</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#admingodawn">godawn </a>
				</li>
			</ul>
		<span class="navbar-text">	
       <a data-toggle="modal" data-target="#viewadminprofile"
			style="margin: 15px;"> <i class="fas fa-user-edit"
				style="color: white"></i>Profile</a>
			</span>	
			<span class="navbar-text"> <a href="logout" class="btn btn-danger">Logout</a>
			</span>
			
		</div>
	 </nav>
	<!-- ********************************************************************************************************************************************************* -->
		<!-- profile view-->
		<!-- Modal -->
		<div class="modal fade" id="viewadminprofile" tabindex="-1"
			aria-labelledby="exampleModalLabel00" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel00">Profile</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="container mt-5 text-center">
						<form action="admin_profile_updated" method="post">
								<div class="form-row">
									<div class="col">
										<label for="inputAddress">First Name</label> <input
											type="text" class="form-control" value="${admin.firstname }"
											name="firstname">
									</div>
									<div class="col">
										<label for="inputAddress">Last Name</label> <input type="text"
											class="form-control" value="${admin.lastname}" name="lastname">
									</div>
								</div>

									<div class="form-group ">
										<label for="inputEmail4">Email</label> <input type="text" class="form-control" value="${ email}"
										readonly name="email">
									</div>
							
										<label for="inputphone">Phone</label> <input type="text"
											class="form-control" id="inputphone" value ="${admin.phone}" name="phone">
									
								<br>
								<button type="submit" class="btn btn-success">Save changes</button>
						  </form> 
						</div>
				</div>
				
						
					</div>
				</div>
			</div>

		</div>

		<!-- ********************************************************************************************************************************************************* -->


	<!-- **********************************************************************************************************************************-->

	<div class="container text-center"></div>
	<hr>

	<div class="container mt-5 text-center">
		<br>
		<div class="card text-white bg-dark mb-3 container text-center" style="max-width: 50rem;" id="adminhome">
			<h2>Welcome to the admin page</h2>
			<div class="card-header">${email }</div>
		</div>
		 
		
<!-- *********************************************************************************************** -->
<a class="btn btn-dark" data-toggle="collapse"
				href="#collapseExample00" role="button" aria-expanded="false"
				aria-controls="collapseExample"> View Profit </a>
<br>     <div class="col d-flex justify-content-center">
			<div class="collapse" id="collapseExample00">
				<div class="card card-body" >
				<div class="text-center">&#x20B9;${profit}</div>
				</div>
				</div>
				</div>
		<br>		
				
		<div class="card border-dark mb-3 container text-center" style="max-width: 50rem;" id="admincustomer">
		<div class="card-header " style="max-width: 50rem;">
    Customer
  </div>
		<br>
		<form class="form" >
			<a class="btn btn-primary" data-toggle="collapse"
				href="#collapseExample" role="button" aria-expanded="false"
				aria-controls="collapseExample"> View all Customer </a>

			<div class="collapse" id="collapseExample">
				<div class="card card-body">
					<table style="width: 100%">
						<thead class="thead-dark">
							<tr>
								<th scope="col">id</th>
								<th scope="col">FirstName</th>
								<th scope="col">LastName</th>
								<th scope="col">Email</th>
								<th scope="col">Address</th>
								<th scope="col">State</th>
								<th scope="col">city</th>
								<th scope="col">Pin</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach begin="0" end="${n}" var="customer" items="${cuslist}">
								<tr>
									<th><c:out value="${customer.customerid}"></c:out></th>
									<td><c:out value="${customer.fname}"></c:out></td>
									<td><c:out value="${customer.lname}"></c:out></td>
									<td><c:out value="${customer.email}"></c:out></td>

									<td><c:out value="${customer.address}"></c:out></td>
									<td><c:out value="${customer.state}"></c:out></td>
									<td><c:out value="${customer.city}"></c:out></td>
									<td><c:out value="${customer.pin}"></c:out></td>
								</tr>

							</c:forEach>


						</tbody>

					</table>

				</div>
			</div>
		</form>
		<br>
		<form action="showcustomer" method="post">
			<input type="search" placeholder="Search customer by id"
				aria-label="Search" name="id">
			<button type="submit">Search</button>
		</form>
		<br>
	</div>
	
</div>


	<!--************************************************************************************************************************************** -->
	<!-- product area -->
	<br>
	<br>
     <div class="card border-dark mb-3 container text-center" style="max-width: 50rem;" id="adminproduct">
		<div class="card-header " style="max-width: 50rem;">
    Product
  </div>
		<br>
		<div class="container" >
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
								<th scope="col">SellingPrise</th>
								<th scope="col">Quantity</th>
								<th scope="col">Companyid</th>
								<th scope="col">Godawn No.</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="p" items="${prolist}">
								<tr>
									<th><c:out value="${p.productid}"></c:out></th>
									<td><c:out value="${p.name}"></c:out></td>
									<td><c:out value="${p.cp}"></c:out></td>
									<td><c:out value="${p.sp}"></c:out></td>
									<td><c:out value="${p.quantity}"></c:out></td>
									<td><c:out value="${p.company_id}"></c:out></td>
									<td><c:out value="${p.godawn_no}"></c:out></td>
								</tr>
							</c:forEach>

						</tbody>

					</table>
					<br>


				</div>
			</div>
		</div>


<!-- ___________________________________________________________________________________________________________________________________________________________________________-->
		<br>
		<!-- Button trigger modal -->
	<!-- 	<button type="button" class="btn btn-primary btn-xs" data-toggle="modal"
			data-target="#exampleModal" aria-expanded="false" aria-controls="collapseExample" width="30px">Add New Product</button>
		 -->
		 <div class="container" >
		 <a class="btn btn-primary" data-toggle="modal"
				href="#exampleModal" role="button" aria-expanded="false"
				aria-controls="collapseExample"> Add New Product </a>
		
		<br>
		<br>
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Add Product</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="add_product" method="post">
							<div class="form-row">
								<div class="col">
									<input type="text" class="form-control" placeholder="Name"
										name="name">
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="CP"
										name="cp">
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="SP"
										name="sp">
								</div>
								</div>
								<br>
								<div class="form-row">
								<div class="col">
									<input type="text" class="form-control" placeholder="Quantity"
										name="quantity">
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="CompanyId"
										name="company_id">
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="GodawnNo"
										name="godawn_no">
								</div>
							</div>
							<br>
							<button type="submit" class="btn btn-success">add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<form action="showproduct" method="post">
			<input type="search" placeholder="Search product by id"
				aria-label="Search" name="id2">
			<button type="submit">Search</button>
		</form>


		<br>
		<form action="deleteproduct" method="post">
			<input type="search" placeholder="enter product id"
				aria-label="Search" name="id3">
			<button type="submit">Delete</button>
		</form>
		</div>
<!------------------------------------------------------------------------------------------------------------------------------------------------------->
		<br>
		<div class="container text-center">

			<div class="container" id="adminproduct">
				<a class="btn btn-primary" data-toggle="collapse"
					href="#collapseproduct2" role="button" aria-expanded="false"
					aria-controls="collapseExample"> View empty Product </a>

				<div class="collapse" id="collapseproduct2">
					<div class="card card-body">

						<table style="width: 100%">
							<thead class="thead-dark">
								<tr>
									<th scope="col">ProductId</th>
									<th scope="col">Name</th>
									<th scope="col">CostPrise</th>
									<th scope="col">SellingPrise</th>
									<th scope="col">Quantity</th>
									<th scope="col">Companyid</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="ep" items="${empro}">
									<tr>
										<th><c:out value="${ep.productid}"></c:out></th>
										<td><c:out value="${ep.name}"></c:out></td>
										<td><c:out value="${ep.cp}"></c:out></td>
										<td><c:out value="${ep.sp}"></c:out></td>
										<td><c:out value="${ep.quantity}"></c:out></td>
										<td><c:out value="${ep.company_id}"></c:out></td>
									</tr>
								</c:forEach>

							</tbody>

						</table>
						<br>


					</div>
				</div>
			</div>

		</div>

<br>
	</div>

<br>


<!--*********************************************************************************************************************************************************** -->
	<!-- company -->
	<br>
	<div class="card border-dark mb-3 container text-center" style="max-width: 50rem;" id="admincompany">
	<div class="card-header " style="max-width: 50rem;">
    Company
  </div>
	<br>
		<div class="container">
			<a class="btn btn-primary" data-toggle="collapse"
				href="#collapsecompany" role="button" aria-expanded="false"
				aria-controls="collapseExample"> View all Company </a>

			<div class="collapse" id="collapsecompany">
				<div class="card card-body">

					<table style="width: 50%">
						<thead class="thead-dark">
							<tr>
								<th scope="col">CompanyId</th>
								<th scope="col">Name</th>
								
								<th scope="col">Address</th>
								<th scope="col">Email</th>
								<th scope="col">Phone</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="cm" items="${comp}">
								<tr>
									<th><c:out value="${cm.companyid}"></c:out></th>
									
									<td><c:out value="${cm.name}"></c:out></td>
									<td><c:out value="${cm.address}"></c:out></td>
									<td><c:out value="${cm.email}"></c:out></td>
									<td><c:out value="${cm.phone}"></c:out></td>
								</tr>
							</c:forEach>

						</tbody>

					</table>
					<br>


				</div>
			</div>
		</div>


<!-- ___________________________________________________________________________________________________________________________________________________________________________-->
		<br>
		<!-- Button trigger modal -->
		<div class="container">
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#exampleModalcomp">Add New company</button>
		
		<!-- Modal -->
		<div class="modal fade" id="exampleModalcomp" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Add Company</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="add_company" method="post">
							<div class="form-row">
								<div class="col">
									<input type="text" class="form-control" placeholder="Name"
										name="name">
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="City"
										name="city">
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="Address"
										name="address">
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="Email"
										name="email">
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="Phone"
										name="phone">
								</div>
							</div>
							<br>
							<button type="submit" class="btn btn-success">add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		</div>
		<br>
		<form action="showcompany" method="post">
			<input type="search" placeholder="Search company by id"
				aria-label="Search" name="id4">
			<button type="submit">Search</button>
		</form>


		<br>
		<form action="deletecompany" method="post">
			<input type="search" placeholder="enter company id"
				aria-label="Search" name="id5">
			<button type="submit">Delete</button>
		</form>
		<br>
</div>



<!--*********************************************************************************************************************************************************** -->
	
	
	<!-- worker -->
	<br>
	<br>
	<div class="card border-dark mb-3 container text-center" style="max-width: 50rem;" id="adminworkers">
	<div class="card-header " style="max-width: 50rem;">
    Worker
  </div>
	<br>

		<div class="container" >
			<a class="btn btn-primary" data-toggle="collapse"
				href="#collapseworkers" role="button" aria-expanded="false"
				aria-controls="collapseExample"> View all Workers </a>

			<div class="collapse" id="collapseworkers">
				<div class="card card-body">

					<table style="width: 100%">
						<thead class="thead-dark">
							<tr>
								<th scope="col">WorkersId</th>
								<th scope="col">FirstName</th>
								<th scope="col">LastName</th>
								<th scope="col">Sallery</th>
								<th scope="col">Phone</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="wr" items="${wor}">
								<tr>
									<th><c:out value="${wr.workersid}"></c:out></th>
									<td><c:out value="${wr.fname}"></c:out></td>
									<td><c:out value="${wr.sname}"></c:out></td>
									<td><c:out value="${wr.sallery}"></c:out></td>
									<td><c:out value="${wr.phone}"></c:out></td>
								</tr>
							</c:forEach>

						</tbody>

					</table>
					<br>


				</div>
			</div>
		</div>


<!-- ___________________________________________________________________________________________________________________________________________________________________________-->
		<br>
		<!-- Button trigger modal -->
		<div class="container">
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#exampleModalwor">Add New worker</button>
		<br>
		<!-- Modal -->
		<div class="modal fade" id="exampleModalwor" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Add worker</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="add_workers" method="post">
							<div class="form-row">
								<div class="col">
									<input type="text" class="form-control" placeholder="F.Name"
										name="fname">
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="L.Name"
										name="sname">
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="sallery"
										name="sallery">
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="Phone"
										name="phone">
								</div>
							</div>
							<br>
							<button type="submit" class="btn btn-success">add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<br>
		<form action="showworkers" method="post">
			<input type="search" placeholder="Search worker by id"
				aria-label="Search" name="id6">
			<button type="submit">Search</button>
		</form>


		<br>
		<form action="deleteworkers" method="post">
			<input type="search" placeholder="enter worker id"
				aria-label="Search" name="id7">
			<button type="submit">Delete</button>
		</form>

<!-- ___________________________________________________________________________________________________________________________________________________________________________-->
		<br>
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#exampleModalworupdate">update worker sallery</button>
		<br>
		<!-- Modal -->
		<div class="modal fade" id="exampleModalworupdate" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Enter detail</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="updateworkers" method="post">
							<div class="form-row">
								<div class="col">
									<input type="text" class="form-control" placeholder="enter id"
										name="id8">
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="new sallery"
										name="newsallery">
								</div>
								
							</div>
							<br>
							
							<button type="submit" class="btn btn-success">update</button>
						</form>
						
					</div>
				</div>
			</div>
		</div>
</div>
<br>	
</div>

<!--*********************************************************************************************************************************************************** -->
<!-- godawn owners -->
	<br>
	<br>
	<div class="card border-dark mb-3 container text-center" style="max-width: 50rem;" id="adminowner">
	<div class="card-header " style="max-width: 50rem;">
    Godawn's owners
  </div>
	<br>

		<div class="container" >
			<a class="btn btn-primary" data-toggle="collapse"
				href="#collapseowner" role="button" aria-expanded="false"
				aria-controls="collapseExample"> View all Godawn's owners </a>

			<div class="collapse" id="collapseowner">
				<div class="card card-body">

					<table style="width: 100%">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Owner's Id</th>
								<th scope="col">FirstName</th>
								<th scope="col">LastName</th>
								<th scope="col">Phone</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="ow" items="${owner}">
								<tr>
									<th><c:out value="${ow.ownerid}"></c:out></th>
									<td><c:out value="${ow.firstname}"></c:out></td>
									<td><c:out value="${ow.lastname}"></c:out></td>
									<td><c:out value="${ow.phone}"></c:out></td>
								</tr>
							</c:forEach>

						</tbody>

					</table>
					<br>


				</div>
			</div>
		</div>


<!-- ___________________________________________________________________________________________________________________________________________________________________________-->
		<br>
		<!-- Button trigger modal -->
		<div class="container">
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#exampleModalowner">Add New godawn owner</button>
		<br>
		<br>
		<!-- Modal -->
		<div class="modal fade" id="exampleModalowner" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Add G.owner</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="add_owner" method="post">
							<div class="form-row">
								<div class="col">
									<input type="text" class="form-control" placeholder="F.Name"
										name="firstname">
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="L.Name"
										name="lastname">
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="Phone"
										name="phone">
								</div>
							</div>
							<br>
							<button type="submit" class="btn btn-success">add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		</div>
		<form action="showowner" method="post">
			<input type="search" placeholder="Search G.owner by id"
				aria-label="Search" name="id9">
			<button type="submit">Search</button>
		</form>


		<br>
		<form action="deleteowner" method="post">
			<input type="search" placeholder="enter G.owner id"
				aria-label="Search" name="id10">
			<button type="submit">Delete</button>
		</form>
<br>

</div>

<!--*********************************************************************************************************************************************************** -->
<!-- godawn -->
	<br>
	<br>
	<div class="card border-dark mb-3 container text-center" style="max-width: 50rem;" id="admingodawn">
	<div class="card-header " style="max-width: 50rem;">
    Godawn
  </div>
	<br>

		<div class="container" >
			<a class="btn btn-primary" data-toggle="collapse"
				href="#collapsgodawn" role="button" aria-expanded="false"
				aria-controls="collapseExample"> View all Godawn </a>

			<div class="collapse" id="collapsgodawn">
				<div class="card card-body">

					<table style="width: 100%">
						<thead class="thead-dark">
							<tr>
								<th scope="col">godawn No</th>
								<th scope="col">House_no</th>
								<th scope="col">Rent</th>
								<th scope="col">owner's id</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="go" items="${godawn}">
								<tr>
									<th><c:out value="${go.godawn_no}"></c:out></th>
									<td><c:out value="${go.house_no}"></c:out></td>
									<td><c:out value="${go.rent}"></c:out></td>
									<td><c:out value="${go.ownerid}"></c:out></td>
								</tr>
							</c:forEach>

						</tbody>

					</table>
					<br>


				</div>
			</div>
		</div>


<!-- ___________________________________________________________________________________________________________________________________________________________________________-->
		<br>
		<!-- Button trigger modal -->
		<div class="container">
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#exampleModalgodawn">Add New godawn</button>
		<br>
		<br>
		<!-- Modal -->
		<div class="modal fade" id="exampleModalgodawn" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Add Godawn</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="add_godawn" method="post">
							<div class="form-row">
								<div class="col">
									<input type="text" class="form-control" placeholder="House no."
										name="house_no">
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="Rent"
										name="rent">
								</div>
								<div class="col">
									<input type="text" class="form-control" placeholder="owner's id"
										name="ownerid">
								</div>
							</div>
							<br>
							<button type="submit" class="btn btn-success">add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		</div>
		<form action="showgodawn" method="post">
			<input type="search" placeholder="Search Godawn by id"
				aria-label="Search" name="id11">
			<button type="submit">Search</button>
		</form>


		<br>
		<form action="deletegodawn" method="post">
			<input type="search" placeholder="enter godawn no"
				aria-label="Search" name="id12">
			<button type="submit">Delete</button>
		</form>
<br>

</div>
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