
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>User&Broker</title>

    <!-- Bootstrap Core CSS -->
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
	
	<style>
	.MyDisplayNone{
	   display:none;
	   }
   body {
    padding-top: 70px; /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
}

footer {
    margin: 50px 0;
}

   </style>

   
   

</head>

<body>
	
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
           
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                   <li class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="">
      Select User<span class="caret"></span>
    </a>
    <ul class="dropdown-menu">
      <li>
                        <a href="<c:url value="/viewUsers.html"/>">User</a>
                    </li>
                    <li>
                        <a href="<c:url value="/viewBrokers.html"/>">Broker</a>
                    </li>
    </ul>
  </li>
          </ul>
          
          <ul class="nav navbar-nav navbar-right">
        <li><a href="<c:url value="j_spring_security_logout"/>"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
      </ul>
                   
            </div>
           
        </div>
      
    </nav>
    <!-- Page Content -->
    
        
  <script src=" https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>
