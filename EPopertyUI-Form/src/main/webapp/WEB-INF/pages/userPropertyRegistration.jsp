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
	<style>
	   
	   .MyDisplayNone{
	   display:none;
	   }
	.MyDisplayAll{
	   display:;
	   }
	</style>
	<script>
	
	
function propertyType(period) {

  if (period=="") {
      
  $("#divpropertyType").addClass("MyDisplayNone"); 
    $("#bhk").addClass("MyDisplayNone"); 
     $("#price").addClass("MyDisplayNone"); 
     $("#contractPeriod").addClass("MyDisplayNone"); 
     $("#securityAmount").addClass("MyDisplayNone"); 
     $("#address").addClass("MyDisplayNone"); 
          $("#propertyDescription").addClass("MyDisplayNone"); 
          $("#image").addClass("MyDisplayNone"); 
}
   if (period=="Rent"){
   
     $("#divpropertyType").addClass("MyDisplayNone"); 
     $("#bhk").removeClass("MyDisplayNone"); 
     $("#price").removeClass("MyDisplayNone"); 
     $("#contractPeriod").removeClass("MyDisplayNone"); 
     $("#securityAmount").removeClass("MyDisplayNone"); 
     $("#address").removeClass("MyDisplayNone"); 
          $("#propertyDescription").removeClass("MyDisplayNone"); 
          $("#image").removeClass("MyDisplayNone"); 

 
    
 
}
   if (period=="Sale"){
  $("#divpropertyType").removeClass("MyDisplayNone"); 
    $("#bhk").addClass("MyDisplayNone"); 
     $("#price").addClass("MyDisplayNone"); 
     $("#contractPeriod").addClass("MyDisplayNone"); 
     $("#securityAmount").addClass("MyDisplayNone"); 
     $("#address").addClass("MyDisplayNone"); 
          $("#propertyDescription").addClass("MyDisplayNone"); 
          $("#image").addClass("MyDisplayNone"); 

}
} 

function propertyLand(period) {

  if (period=="") {
      
    $("#price").addClass("MyDisplayNone"); 
    $("#address").addClass("MyDisplayNone"); 
    $("#propertyDescription").addClass("MyDisplayNone"); 
    $("#image").addClass("MyDisplayNone"); 
}
   if (period=="House"){
  
    $("#bhk").removeClass("MyDisplayNone"); 
    $("#price").removeClass("MyDisplayNone"); 
    
    $("#address").removeClass("MyDisplayNone"); 
    $("#propertyDescription").removeClass("MyDisplayNone"); 
    $("#image").removeClass("MyDisplayNone"); 
}
   if (period=="Land"){
  $("#price").removeClass("MyDisplayNone"); 
    $("#address").removeClass("MyDisplayNone"); 
      $("#propertyDescription").removeClass("MyDisplayNone"); 
       $("#bhk").addClass("MyDisplayNone"); 
	             $("#image").removeClass("MyDisplayNone"); 

}
} 


</script>
  </head>
  <body style="Background:"#eeee>
    <div class="container">
    <p><br/></p>
   	<div class="row">
  		<div class="col-md-3"></div>
  		<div class="col-md-6">
  		<div class="panel panel-default">
  				<div class="panel-body">
  					<div class="page-header">
  						<h1>Register Property</h1>
					</div>
					<c:if test="${not empty successMsg}">
							<div class="msg">${successMsg}</div>
						</c:if>
    				 <form class="form-horizontal" role="form"  action="userPropertyRegistration.html" method="POST">
					 
					 <div class="form-group">
      <label for="select" class="col-lg-4 control-label">Property For&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
      <div class="col-lg-8">
        <select class="form-control" id="select"  name="propertyForEx" onchange="propertyType(this.value)" >
        <option value=""> Please select</option>
		<option vale="Sale">Sale</option>
          <option value="Rent">Rent</option>
        </select>
        <br>
        
      </div>
    </div>
					 
   		 <div class="form-group MyDisplayNone" id="divpropertyType" >
      <label for="select" class="col-lg-4 control-label">Property Type&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
      <div class="col-lg-8">
        <select class="form-control"   name="propertyTypeEx" onchange="propertyLand(this.value)" >
          
          <option value="">Please select</option>
          <option value="House">House</option>
          <option value="Land">Land</option>
          
        </select>
        <br>
        
      </div>
    </div>
	
	   		 <div class="form-group MyDisplayNone" id="bhk" >
      <label for="select" class="col-lg-4 control-label">BHK&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
      <div class="col-lg-8">
        <select class="form-control" id="select" name="bhk">
           <option value="">Please select</option>
		  <option value="1BHK">1BHK</option>
          <option value="2BHK">2BHK</option>
          <option value="3BHK">3BHK</option>
         
        </select>
        <br>
        
      </div>
    </div>
	
	  
	
	
	
	<div class="form-group MyDisplayNone" id="price">
      <label for="inputEmail" class="col-lg-4 control-label">Price&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
      <div class="col-lg-8">
        <input type="text" class="form-control" id="inputEmail" placeholder="Price" name="price">
      </div>
    </div>
	
	<div class="form-group MyDisplayNone" id="contractPeriod">
      <label for="inputEmail" class="col-lg-4 control-label">Contract Period&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
      <div class="col-lg-8">
        <input type="text" class="form-control" id="inputEmail" placeholder="Contract Period"  name="contractPeriod" value="0">
      </div>"
    </div>
	
	<div class="form-group MyDisplayNone"  id="securityAmount">
      <label for="inputEmail" class="col-lg-4 control-label">Security Amount&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
      <div class="col-lg-8">
        <input type="text" class="form-control" id="inputEmail" placeholder="Security Amount" name="securityAmount" value="0">
      </div>
    </div>
	
	<div class="form-group MyDisplayNone" id="address">
      <label for="inputEmail" class="col-lg-4 control-label">Address&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
      <div class="col-lg-8">
        <input type="text" class="form-control" id="inputEmail" placeholder="Address" name="address">
      </div>
    </div>
	
	 <div class="form-group MyDisplayNone" id="propertyDescription">
      <label for="textArea" class="col-lg-4 control-label">Property Description</label>
      <div class="col-lg-8">
        <textarea class="form-control" rows="3" id="textArea" name="propertyDescription"></textarea>
       
      </div>
    </div>
	 
	 
    
     <!-- <div class="form-group MyDisplayNone" id="image">
	 <label for="inputEmail" class="col-lg-4 control-label">Image&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
     
	 <div class="col-lg-8">
      <div style="position:relative;">
		<a class='btn btn-default' href='javascript:;'>
			Browse
			<input type="file" style='position:absolute;z-index:2;top:0;left:0;filter: alpha(opacity=0);-ms-filter:"progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";opacity:0;background-color:transparent;color:transparent;' name="image" size="40"  onchange='$("#upload-file-info").html($(this).val());'>
		</a>
		&nbsp;
		<span class='label label-info' id="upload-file-info"></span>
	</div>
	 </div>
      </div> --> 
    
	
    <div class="form-group" >        
      <div class="col-sm-offset-2 col-sm-10">
         <div  class="col-sm-3"></div>
		
         <div  class="col-sm-6">

        <!-- <button type="reset" class="btn btn-default">&nbspReset&nbsp</button> -->
        <button type="submit" class="btn btn-primary">Submit</button>
        </div>
        <div  class="col-sm-3"></div>
      </div>
    </div>
    <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
  </form>
  				</div>
  		</div>
  		<div class="col-md-3"></div>
		</div>
	</div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  </body>
</html>