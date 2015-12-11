<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>CreateBroker</title>

<!-- Bootstrap -->
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="http://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <![endif]-->
</head>
<body style="Background:" #eeee>
	<div class="container">
		<p>
			<br />
		</p>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="page-header">
							<h1>Create Broker</h1>
						</div>
						<c:url var="addUrl" value="/createbroker" />
						<%-- <form action='${addUrl}' modelAttribute="register" method="post"> --%>
						<form name='createBrokerForm'
							action='/EPopertyUI-Form/createBroker.html?${_csrf.parameterName}=${_csrf.token}' method='POST'>
							<div class="form-group">
								<label for="inputfn3">FirstName</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-user"></span></span> <input type="text"
										class="form-control" placeholder="FirstName" id="inputfn3"
										name="firstName">
								</div>
							</div>
							<div class="form-group">
								<label for="inputfn3">LastName</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-user"></span></span> <input type="text"
										class="form-control" placeholder="LastName" id="inputfn3"
										name="lastName">
								</div>
							</div>
							<div class="form-group">
								<label for="inputfn3">UserName</label>
								<div class="input-group">
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-user"></span></span> <input type="text"
										class="form-control" placeholder="UserName" id="inputfn3"
										name="userName">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-star"></span></span> <input
											type="password" class="form-control" placeholder="Password"
											id="exampleInputPassword1" name="enKey">
									</div>
								</div>
								<div class="form-group">
									<label for="inputfn3">NetworkId</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-asterisk"></span></span> <input
											type="text" class="form-control" placeholder="NetworkId"
											id="inputfn3" name="networkId">
									</div>
								</div>
								<div class="form-group">
									<label for="inputfn3">BrokerId</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-user"></span></span> <input type="text"
											class="form-control" placeholder="BrokerId" id="inputfn3"
											name="brokerId">
									</div>
								</div>
								<div class="form-group">
									<label for="inputfn3">BranchId</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-book"></span></span> <input type="text"
											class="form-control" placeholder="BranchId" id="inputfn3"
											name="branchId">
									</div>
								</div>
								<div class="form-group">
									<label for="inputfn3">ChannelId</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-book"></span></span> <input type="text"
											class="form-control" placeholder="ChannelId" id="inputfn3"
											name="channelId">
									</div>
								</div>
								<div class="form-group">
									<label for="inputfn3">ChannelName</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-book"></span></span> <input type="text"
											class="form-control" placeholder="ChannelName" id="inputfn3"
											name="channelName">
									</div>
								</div>
								<hr />
								<div>
									<button type="submit" class="btn btn-primary"
										style="margin: 5px">Submit</button>
									<button type="button" class="btn btn-success" onclick="myFunction()" value="Reset form">Reset</button>
								</div>

								<p>
									<br />
								</p>
						</form>
						<script>
							function myFunction() {
								document.getElementById("createBrokerForm")
										.reset();
							}
						</script>

					</div>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>

		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.min.js"></script>
</body>
</html>