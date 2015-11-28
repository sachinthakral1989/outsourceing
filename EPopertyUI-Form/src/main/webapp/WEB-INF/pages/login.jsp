<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html lang="en">
  <head>
  <style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
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
  <body onload='document.loginForm.username.focus();' style="Background:"#eeee>
  
    <div class="container">
    <p><br/></p>
   	<div class="row">
  		<div class="col-md-8"></div>
  		<div class="col-md-4">
  			<div class="panel panel-default">
  				<div class="panel-body">
  					<div class="page-header">
  						<h1>Login</h1>
					</div>
					<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
    					<form name='loginForm'
			            action="<c:url value='/j_spring_security_check' />" method='POST'>
  							<div class="form-group">
    							<label for="exampleInputEmail1">Email</label>
    							<div class="input-group">
  									<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
  										<input type="text" class="form-control" placeholder="Username" name="username" >
								</div>
  							</div>
  							<div class="form-group">
    							<label for="exampleInputPassword1">Password</label>
    							<div class="input-group">
  									<span class="input-group-addon"><span class="glyphicon glyphicon-star"></span></span>
  										<input type="password" class="form-control" placeholder="Password" name="password" >
								</div>
  							</div>
  							<hr/>
  							<button type="submit" class="btn btn-primary">Login <span class="glyphicon glyphicon-lock"></span></button>
  							<p><br/></p>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</form>
  				</div>
		</div>
	</div>
</div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>