<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Register Property</title>

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
  						<h1>Register Property</h1>
					</div>
    					<form>
  							<div class="form-group">
    							<label for="dropdownMenu1">SaleOrRent</label>
    							<div class="dropdown">
  									<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
    								Dropdown
    								<span class="caret"></span>
 							 		</button>
	  									<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
										    <li><a href="#">Sale</a></li>
										    <li><a href="#">Rent</a></li>
										    <li role="separator" class="divider"></li>
										    <li><a href="#">Lease</a></li>
	  									</ul>
								</div>
  							</div>
  							<div class="form-group">
    							<label for="dropdownMenu2">Property Type</label>
    							<div class="dropdown">
  									<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
    								Dropdown
    								<span class="caret"></span>
 							 		</button>
	  									<ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
										    <li><a href="#">House</a></li>
										    <li><a href="#">Land</a></li>
	  									</ul>
								</div>
  							</div>
  							<div class="form-group">
    							<label for="inputfn3">Number of Rooms</label>
    							<div class="input-group">
  									<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
  										<input type="text" class="form-control" placeholder="Number of Rooms" id="inputfn3" >
								</div>
  							</div>
  							<hr/>
  							<button type="submit" class="btn btn-primary">Submit</button>
  							
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