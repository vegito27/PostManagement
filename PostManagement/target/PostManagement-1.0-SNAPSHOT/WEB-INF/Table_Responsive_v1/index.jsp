<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Table V01</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
	<style>

	#header{

	font-weight:600;
	color:white;
	float:right;
	margin-bottom:10px;
	}

	.header1{
	font-weight:600px;
	color:white;
	float:left;
	margin-bottom:10px;

	}

	#profile{
	float:right;
	}

	</style>



</head>



<body>
	
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<button id="profile"  type="button" class="btn btn-info">Edit Profile</button>
				<div class="table100">

					<div id="myprofile">

						<span class="header1"><h1>Hello Rishabh  Users</h1></span>

						<span id ="header" class="badge badge-pill badge-primary">Click aside to edit profile</span>

					</div>

					<table id="example">
						<thead>
							<tr class="table100-head">
								<th class="column1">UserId</th>
								<th class="column2">Name</th>
								<th class="column3">Email</th>
								<th class="column4">Mobile</th>
								<th class="column5">Profile</th>
								<th class="column6">Posts</th>
							</tr>
						</thead>
						<tbody>
								<tr>
									<td class="column1">2017-09-29 01:22</td>
									<td class="column2">200398</td>
									<td class="column3">iPhone X 64Gb Grey</td>
									<td class="column4">$999.00</td>
									<td class="column5"><button type="button" class="btn btn-success">Profile</button></td>
									<td class="column6"><button type="button" class="btn btn-primary">Post</button></td>
								</tr>


						</tbody>

					</table>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
		$(document).ready(function() {
    $('#example').DataTable( {
        "pagingType": "full_numbers"
    } );
} );

	</script>


</html>