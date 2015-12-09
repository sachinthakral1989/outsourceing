<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
  <style>


body {
    width: 100%;
    height: 100%;
    font-family: Lora,"Helvetica Neue",Helvetica,Arial,sans-serif;
    color: #fff;
    background-color: #000;
}

html {
    width: 100%;
    height: 100%;
}
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
h4
 {
    margin: -100px 0 35px;
    text-transform: uppercase;
    font-family: Montserrat,"Helvetica Neue",Helvetica,Arial,sans-serif;
    font-weight: 500;
    letter-spacing: 1px;
}





a {
    color: #42dca3;
    -webkit-transition: all .2s ease-in-out;
    -moz-transition: all .2s ease-in-out;
    transition: all .2s ease-in-out;
}





.navbar-custom {
    margin-bottom: 0;
    border-bottom: 1px solid rgba(255,255,255,.3);
    text-transform: uppercase;
    font-family: Montserrat,"Helvetica Neue",Helvetica,Arial,sans-serif;
    background-color: #000;
}




.navbar-custom button {
    color: #fff;
}




.navbar-custom a {
    color: #fff;
}



.navbar-custom .nav li a:hover {
    outline: 0;
    color: rgba(255,255,255,.8);
    background-color: transparent;
}

.navbar-custom .nav li a:focus,
.navbar-custom .nav li a:active {
    outline: 0;
    background-color: transparent;
}

.navbar-custom .nav li.active {
    outline: 0;
}

.navbar-custom .nav li.active a {
    background-color: rgba(255,255,255,.3);
}

.navbar-custom .nav li.active a:hover {
    color: #fff;
}

@media(min-width:768px) {
    .navbar-custom {
        padding: 20px 0;
        border-bottom: 0;
        letter-spacing: 1px;
        background: 0 0;
        -webkit-transition: background .5s ease-in-out,padding .5s ease-in-out;
        -moz-transition: background .5s ease-in-out,padding .5s ease-in-out;
        transition: background .5s ease-in-out,padding .5s ease-in-out;
    }

    .navbar-custom.top-nav-collapse {
        padding: 0;
        border-bottom: 1px solid rgba(255,255,255,.3);
        background: #000;
    }
}

.intro {
    display: table;
    width: 100%;
    height: auto;
    padding: 100px 0;
    text-align: center;
    color: #fff;
    background: url(/img/intro-bg.jpg) no-repeat bottom center scroll;
    background-color: #000;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    background-size: cover;
    -o-background-size: cover;
}

.intro .intro-body {
    display: table-cell;
    vertical-align: middle;
}

.intro .intro-body .brand-heading {
    font-size: 40px;
}

.intro .intro-body .intro-text {
    font-size: 18px;
}

@media(min-width:768px) {
    .intro {
        height: 100%;
        padding: 0;
    }

    .intro .intro-body .brand-heading {
        font-size: 100px;
    }

    .intro .intro-body .intro-text {
        font-size: 26px;
    }
}
















    












	   
	   .place{
	   color: #999;opacity: 1;
	   }
  </style>
     <title>Sale&Rent</title>
	     <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">

   </script>

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
    <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
        <div class="container">
            

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    
                    
                    
                    <li>
                        <a  href="">Login</a>
                    </li>
                    <li>
                        <a href="">Register</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Intro Header -->
    <header class="intro">
        <div class="intro-body">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <h4 class="brand-heading">Sale & Rent</h4>
						
						 <nav class="navbar  navbar-custom" >
        <div class="container-fluid">
           

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                   
                    <li>
                        <a  href="#" onclick="sale()" >Sale</a>
                    </li>
                    <li>
                        <a href="#" onclick="rent()">Rent</a>
                    </li>
                    
                </ul>
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
	  <select class="form-control inputBox place"   name="propertySearchType"   onchange="propertyLand(this.value)">
          
         
          <option value="House">House</option>
          <option value="Land">Land</option>
          
        </select>
	  
	  
      
    </div>
	
	<div class="MyDisplayNone  input-group formElement " id="inputmine">
      
	  <select class="form-control inputBox place"  name="bhk"   >
          
          
          <option value="1BHK">1BHK</option>
          <option value="2BHK">2BHK</option>
          <option value="3BHK">3BHK</option>
        </select>
	  
	  
      
    </div>
    <div class="input-group formElement">
      
      <input type="text" class="form-control inputBox place" id="InputAmount" name="locality" placeholder="Locality"  >
	  
      
    </div>
	
	<div class="input-group formElement">
      
      <input type="number" class="form-control inputBox place" id="InputMinPrice" name="minPrice" placeholder="min price" >
	  
      
    </div>
	<div class="input-group formElement">
      
      <input type="number" class="form-control inputBox place" id="InputMaxPrice" name="maxPrice" placeholder="max price"  >
	  
      
    </div>
	
	<div class="input-group ">
      
<button type="submit" class="btn btn-primary inputBox" >Submit</button>	  
      
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
      
      <input type="number" class="form-control inputBox place"  id="InputMinPrice" placeholder="min price" >
	  
      
    </div>
	<div class="input-group formElement">
      
      <input type="number" class="form-control inputBox place" id="InputMaxPrice" placeholder="max price"  >
	  
      
    </div>
	
	<div class="input-group ">
      
<button type="submit" class="btn btn-primary inputBox" >Submit</button>	  
      
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