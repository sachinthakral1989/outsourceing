<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
  
 <title>Sale&Rent</title>
 <style>
 .MyDisplayNone{
	   display:none;
	   }
	   .formElement {
    float:left;
    width:150px;
	
}
.inputBox{
	
	height:50px;font-size:20px;
}


 </style>
<script>
function sale() {
    
	$("#formSale").removeClass("MyDisplayNone"); 
	$("#formRent").addClass("MyDisplayNone"); 
}
function rent() {
   $("#formSale").addClass("MyDisplayNone"); 
	$("#formRent").removeClass("MyDisplayNone"); 
}

function propertyLand(period) {

 
   if (period=="House"){
    $("#inputmine").show(); 
    
}
   if (period=="Land"){
  $("#inputmine").hide(); 
}
} 
</script>
  
    <!-- Bootstrap Core CSS -->


    

    <link href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

   

</head>

<body id="page-top"  >
   
  

   
   
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    
                    
     
                    <li>
                        <a href="<c:url value="/login"/>">Login</a>
                    </li>
                    <li>
                        <a href="<c:url value="/page/registeration"/>">Register</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
</br>
</br>
    <!-- Intro Header -->
    <header class="intro">
        <div class="intro-body">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        
						
						 <nav class="navbar  navbar-custom" >
						 <br>
						 <br>
						 <br>
        <div class="container-fluid">
           

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="">
                
                   
                    
                        <button class="btn btn-primary btn-lg"  onclick="sale()" >&nbsp&nbsp Sale &nbsp&nbsp</button>
                    
					
                    
                        <button class="btn btn-primary btn-lg"  onclick="rent()">&nbsp&nbsp Rent &nbsp&nbsp</button>
                
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
	<div id="formSale">
	<form class="form-inline" action="searchProperty.html?${_csrf.parameterName}=${_csrf.token}" method="POST">
  <div class="form-group">
    <div class="input-group formElement">
      <input type="hidden" value="Sale" name="propertySearchFor">
	  <select class="form-control  place"   name="propertySearchType"   onchange="propertyLand(this.value)">
          
         
          <option value="House">House</option>
          <option value="Land">Land</option>
          
        </select>
	  
	  
      
    </div>
	
	<div class="MyDisplayNone  input-group formElement " id="inputmine">
      
	  <select class="form-control  place"  name="bhk"   >
          
          
          <option value="1BHK">1BHK</option>
          <option value="2BHK">2BHK</option>
          <option value="3BHK">3BHK</option>
        </select>
	  
	  
      
    </div>
    <div class="input-group formElement">
      
      <input type="text" class="form-control place" id="InputAmount" name="locality" placeholder="Locality"  >
	  
      
    </div>
	
	<div class="input-group formElement">
      
      <input type="number" class="form-control  place" id="InputMinPrice" name="minPrice" placeholder="min price" >
	  
      
    </div>
	<div class="input-group formElement">
      
      <input type="number" class="form-control  place" id="InputMaxPrice" name="maxPrice" placeholder="max price"  >
	  
      
    </div>
	&nbsp
	<div class="input-group ">
      
<button type="submit" class="btn btn-primary" >&nbsp&nbspSearch&nbsp&nbsp</button>	  
      
    </div>
	
	 
 
	
  </div>
 
</form>
</div>
<div id="formRent" class="MyDisplayNone">
<form class="form-inline " action="searchProperty.html?${_csrf.parameterName}=${_csrf.token}" method="POST">
  <div class="form-group">
         <input type="hidden" value="Rent" name="propertySearchFor">
   
    <div class="input-group formElement">
      
      <input type="text" class="form-control inputBox place" id="InputAmount" name="locality" placeholder="Locality"  >
	  
      
    </div>
	<div class="input-group formElement">
      
	  <select class="form-control inputBox place"   name="bhk"   >
          
          
          <option value="1BHK">1BHK</option>
          <option value="2BHK">2BHK</option>
          <option value="3BHK">3BHK</option>
        </select>
	  
	  
      
    </div>
	<div class="input-group formElement">
      
      <input type="number" class="form-control  place"  id="InputMinPrice" placeholder="min price" >
	  
      
    </div>
	<div class="input-group formElement">
      
      <input type="number" class="form-control place" id="InputMaxPrice" placeholder="max price"  >
	  
      
    </div>
	&nbsp
	<div class="input-group ">
      
<button type="submit" class="btn btn-primary " >&nbsp&nbsp Search &nbsp&nbsp</button>	  
      
    </div>
	
	 
 
	
  </div>
 
</form>
</div>


     
                    </div>
                </div>
            </div>
        </div>
    </header>

   
   

    

  

    <!-- jQuery -->

    

	     <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    

   

</body>

</html>