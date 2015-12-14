<!DOCTYPE html>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sale&Rent</title>

    <!-- Bootstrap Core CSS -->
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

   <style>
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
                    <li>
                        <a href="#">Login</a>
                    </li>
                   
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <!-- Page Heading -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Sales&Rent
                    <small>... Pvt Ltd</small>
                </h1>
            </div>
        </div>
        <!-- /.row -->

        <!-- Project One -->
        <c:forEach var="listValue" items="${userPropertyList }">
   
    
    
   
        <div class="row">
            <div class="col-md-7">
                <a href="#">
                   <img align="left" src="<c:url value='http://res.cloudinary.com/db8aywkdb/image/upload/v1449674496/${listValue.imagePublicId}.jpg'/>" alt="home" title="home" width="230" height="150"/>
                </a>
            </div>
            <div class="col-md-5">
                <h3>House no. ${listValue.houseNumber}</h3>
                <p>
<%--                 <li>House no. ${listValue.houseNumber}</li> --%>
                <li>Address ${listValue.address}</li>
                
        <li>Price   ${listValue.price}</li>
        <li>Property Description   ${listValue.propertyDescription}</li>
                 <li>Locality   ${listValue.locality}</li>
         
                </p>
                
            </div>
        </div>
        <!-- /.row -->
        <hr>
</c:forEach>
  

          <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p></p>
                </div>
            </div>
            <!-- /.row -->
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
