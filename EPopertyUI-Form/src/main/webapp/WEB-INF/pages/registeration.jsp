<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Login</title>

    <!-- Bootstrap -->
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <![endif]-->
  </head>
  <body style="Background:"#eeee>
    <div class="container">
    <p><br/></p>
   	<div class="row">
  		<div class="col-md-2"></div>
  		<div class="col-md-6">
  		<div class="panel panel-default">
  				<div class="panel-body">
  					<div class="page-header">
  						<h1>Registeration Form </h1>
					</div>
						<c:url var="addUrl" value="/sendEmailToRecipient"/>
    					 <%-- <form action='${addUrl}' modelAttribute="register" method="post"> --%>
    					<form name='registerationForm' action='/EPopertyUI-Form/sendEmailToRecipient.html' method='POST'>
    					<div class="form-group">
    							<label for="inputfn3">Full Name</label>
    							<div class="input-group">
  									<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
  										<input type="text" class="form-control" placeholder="Full Name" id="inputfn3" name="fullName">
								</div>
  							</div>
  							<div class="form-group">
    							<label for="exampleInputEmail1">Email</label>
    							<div class="input-group">
  									<span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
  										<input type="text" class="form-control" placeholder="Email" id="exampleInputEmail1"  name="email">
								</div>
  							</div>
  							<div class="form-group">
    							<label for="exampleInputPassword1">Password</label>
    							<div class="input-group">
  									<span class="input-group-addon"><span class="glyphicon glyphicon-star"></span></span>
  										<input type="password" class="form-control" placeholder="Password" id="exampleInputPassword1" name="enKey">
								</div>
  							</div>
  							<hr/>
  							<button type="submit" class="btn btn-primary">Register</button>
  							<button type="button" class="btn btn-success">Back to Login</button>
  							<p><br/></p>
						</form>
						
  				</div>
  		</div>
  		<div class="col-md-2"></div>
		</div>
	</div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>