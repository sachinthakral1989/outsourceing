<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Share a Deal</title>

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

  </head>
  <body style="Background:"#eeee>
  <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
       <div class="container-fluid">
    <div class="navbar-header">
      
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">ALL <span class="sr-only">(current)</span></a></li>
        <li><a href="#">MOBILES</a></li>
		<li><a href="#">COMPUTERS</a></li>
		<li><a href="#">GAMING</a></li>
       
      </ul>
	   <ul class="nav navbar-nav navbar-right">
        <li><a href="#">SIGNIN</a></li>
      </ul>
	   <ul class="nav navbar-nav navbar-right">
        <li><a href="#">SIGNUP</a></li>
      </ul>
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
       
      </form>
     
    </div>
  </div>
        <!-- /.container -->
    </nav>
  
  <p><br/></p><p><br/></p>
    <div class="container">
    <p><br/></p>
   	<div class="row">
  		<div class="col-md-2"></div>
  		<div class="col-md-8">
  		<div class="panel panel-default">
  				<div class="panel-body">
  					<div class="page-header">
  						<h1>Share a Deal</h1>
					</div>
					<c:if test="${not empty emailMsg}">
							<div class="msg">${emailMsg}</div>
						</c:if>
						<c:if test="${not empty errMsg1}">
							<div class="msg">${errMsg1}</div>
						</c:if>
    				 <form class="form-horizontal" role="form"
  							action="submitDeal.html?${_csrf.parameterName}=${_csrf.token}"  method="POST"  
    				 modelAttribute="uploadForm" enctype="multipart/form-data">
					 
		
					 <div class="form-group " id="dealUrl">
      <label for="inputDealUrl" class="col-lg-4 control-label">Deal Url&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
      <div class="col-lg-8">
        <input type="text" class="form-control" id="inputDealUrl" placeholder="Deal Url"  name="url" >
      </div>
    </div>
	
	
	<div class="form-group " id="dealTitle">
      <label for="inputDealTitle" class="col-lg-4 control-label">Deal Title&nbsp&nbsp&nbsp&nbsp</label>
      <div class="col-lg-8">
        <input type="text" class="form-control" id="inputDealTitle" placeholder="Deal Title"  name="title" >
      </div>
    </div>
					 
		

      <div class="form-group " id="price">
      <label for="inputPrice" class="col-lg-4 control-label">Price&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
      <div class="col-lg-8">
        <input type="number" class="form-control" id="inputPrice" placeholder="Price" name="price" onblur="blurPrice()" required>
      </div>
    </div>		
  
	
	   		 <div class="form-group " id="dealTopic" >
      <label for="select" class="col-lg-4 control-label">Deal Topic&nbsp&nbsp</label>
      <div class="col-lg-8">
        <select class="form-control" id="inputDealTopic" name="topic">
           <option value=""></option>
		  <option value="Mobiles">Mobiles</option>
          <option value="Computers">Computers</option>
          <option value="Gaming">Gaming</option>
         
        </select>
        <br>
        
      </div>
    </div>
	
	  
	
	
	
	
	
	
	
	
	
	
	
	
	
	 <div class="form-group " id="dealDescription">
      <label for="textArea" class="col-lg-4 control-label">Description</label>
      <div class="col-lg-8">
        <textarea class="form-control" rows="4" id="inputDealDescription" name="description" ></textarea>
       
      </div>
    </div>
	 
    
       <div class="form-group " id="image">
	 <label for="inputEmail" class="col-lg-4 control-label">Image&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
     
	 <div class="col-lg-8">
      <div style="position:relative;">
		<a class='btn btn-default' href='javascript:;'>
			Browse Image
			<input type="file" name='file' style='position:absolute;z-index:2;top:0;left:0;filter: 
alpha(opacity=0);-ms-filter:"progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";opacity:0;background-color:transparent;color:transparent;' name="image" size="40"  
onchange='$("#upload-file-info").html($(this).val());'>
		</a>
		&nbsp;
		<span class='label label-info' id="upload-file-info"></span>
	</div>
	 </div>
      </div>
    
	
    <div class="form-group " id="submitButton" >        
      <div class="col-sm-offset-2 col-sm-10">
         <div  class="col-sm-3"></div>
		
         <div  class="col-sm-6">

        <!-- <button type="reset" class="btn btn-default">&nbspReset&nbsp</button> -->
        <button type="submit" class="btn btn-primary">Submit Deal</button>
        </div>
        <div  class="col-sm-2"></div>
      </div>
    </div>
	</br>
     </br>
	
  </form>
  				</div>
  		</div>
  		<div class="col-md-3"></div>
		</div>
	</div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  
  <script src="jquery.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  </body>
</html>