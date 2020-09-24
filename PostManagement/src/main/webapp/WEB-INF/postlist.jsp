<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap User Management Data Table</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">



    body {
        color: #566787;
		 background: -webkit-linear-gradient(right, #2f91ff, #37bf43, #2f91ff, #00c513);
  background: -o-linear-gradient(right, #2f91ff, #00c513, #2f91ff, #00c513);
  background: -moz-linear-gradient(right, #2f91ff, #00c513, #2f91ff, #00c513);
  background: linear-gradient(right, #2f91ff, #00c513, #2f91ff, #00c513);
		font-family: 'Varela Round', sans-serif;
		font-size: 13px;
	}
	.table-wrapper {
        background: #fff;
        padding: 20px 25px;
        margin: 30px 0;
		border-radius: 3px;
        box-shadow: 0 1px 1px rgba(0,0,0,.05);
    }
	.table-title {
		padding-bottom: 15px;
		background:  -webkit-linear-gradient(left, #3931af, #00c6ff);;
		color: #fff;
		padding: 16px 30px;
		margin: -20px -25px 10px;
		border-radius: 3px 3px 0 0;
    }
    .table-title h2 {
		margin: 5px 0 0;
		font-size: 24px;
	}
	.table-title .btn {
		color: #566787;
		float: right;
		font-size: 13px;
		background: #fff;
		border: none;
		min-width: 50px;
		border-radius: 2px;
		border: none;
		outline: none !important;
		margin-left: 10px;
	}
	.table-title .btn:hover, .table-title .btn:focus {
        color: #566787;
		background: #f2f2f2;
	}
	.table-title .btn i {
		float: left;
		font-size: 21px;
		margin-right: 5px;
	}
	.table-title .btn span {
		float: left;
		margin-top: 2px;
	}
    table.table tr th, table.table tr td {
        border-color: #e9e9e9;
		padding: 12px 15px;
		vertical-align: middle;
    }
	table.table tr th:first-child {
		width: 60px;
	}
	table.table tr th:last-child {
		width: 100px;
	}
    table.table-striped tbody tr:nth-of-type(odd) {
    	background-color: #fcfcfc;
	}
	table.table-striped.table-hover tbody tr:hover {
		background: #f5f5f5;
	}
    table.table th i {
        font-size: 13px;
        margin: 0 5px;
        cursor: pointer;
    }
    table.table td:last-child i {
		opacity: 0.9;
		font-size: 22px;
        margin: 0 5px;
    }
	table.table td a {
		font-weight: bold;
		color: #566787;
		display: inline-block;
		text-decoration: none;
	}
	table.table td a:hover {
		color: #2196F3;

	}
	table.table td a.settings {
        color: #2196F3;
    }
    table.table td a.delete {
        color: #F44336;
    }
    table.table td i {
        font-size: 19px;
    }
	table.table .avatar {
		border-radius: 50%;
		vertical-align: middle;
		margin-right: 10px;
	}
	.status {
		font-size: 30px;
		margin: 2px 2px 0 0;
		display: inline-block;
		vertical-align: middle;
		line-height: 10px;
	}
    .text-success {
        color: #10c469;
    }
    .text-info {
        color: #62c9e8;
    }
    .text-warning {
        color: #FFC107;
    }
    .text-danger {
        color: #ff5b5b;
    }

    .hint-text {
        float: left;
        margin-top: 10px;
        font-size: 13px;
    }
</style>


<script type="text/javascript">

$(document).ready(function(){
	$('[data-toggle="tooltip"]').tooltip();
});

</script>


</head>


<body>


<div class="container">
    <h1 style="color:white;">Hello ${firstname}&nbsp ${lastname} <b style="display:none;">${user.id}</b><form style="float:right" action="addpost.do" method="GET" ><button type="submit" class="btn btn-warning">Add Post</button></form>
    &nbsp&nbsp<form style="float:right" action="logout.do" method="GET" ><button type="submit" class="btn btn-primary">Logout</button></form></h1>


    <div class="table-wrapper">

        <div class="table-title">
            <div class="row">
                <div class="col-sm-5">
                    <h2>POST <b>Management</b></h2>
                </div>

            </div>
        </div>

        <table class="table table-striped table-hover">

            <thead>
            <tr>
                <th>#</th>
                <th>Title</th>
                <th>Post</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>


            <c:forEach items="${posts}" var ="post1">
            <tr>
                <td>${post1.id}</td>
                <td>${post1.title}</td>
                <td>${post1.post}</td>
                <td><a href="editpost.do?id=${post1.id}"><button type="submit" class="btn btn-success">Edit</button></a></td>
                <td>
                    <a href="deletepost.do?id=${post1.id}"><button type="submit" class="btn btn-danger">Delete</button></a> </td>
            </tr>
           </c:forEach>
            </tbody>
        </table>

</div>
</div>

</body>
</html>