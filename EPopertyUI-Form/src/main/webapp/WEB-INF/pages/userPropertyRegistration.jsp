<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Register Property</title>

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
<style>
.MyDisplayNone {
	display: none;
}

.MyDisplayAll {
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
<script>
        function actionFunction(period)
		{
		
		    
	        if (period == ""){

			$("#add").addClass("MyDisplayNone");
		
			$("#update").addClass("MyDisplayNone");

			$("#delete").addClass("MyDisplayNone");
		}
		   if (period == "add"){

			$("#update").addClass("MyDisplayNone");
		    $("#delete").addClass("MyDisplayNone");
			$("#add").removeClass("MyDisplayNone");

		}
		 if (period == "update"){
			$("#add").addClass("MyDisplayNone");
		    $("#delete").addClass("MyDisplayNone");
			$("#update").removeClass("MyDisplayNone");
			

		}
		 
	}
	


	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}

	function blurPrice() {
		var v = document.getElementById("inputPrice");

		if (v.value < 0) {
			alert("Price should not be negative");
			v.value = "";
		}
	}
	function focusContractPeriod() {
		document.getElementById("inputContractPeriod").value = "";

	}
	function blurContractPeriod() {
		var v = document.getElementById("inputContractPeriod");
		if (v.value == "")
			v.value = 0;
		if (v.value < 0) {
			alert("SecurityAmount should not be negative");
			v.value = 0;
		}
	}

	function focusSecurityAmount() {
		document.getElementById("inputSecurityAmount").value = "";

	}
	function blurSecurityAmount() {
		var v = document.getElementById("inputSecurityAmount");
		if (v.value == "")
			v.value = 0;
		if (v.value < 0) {
			alert("SecurityAmount should not be negative");
			v.value = 0;
		}
	}

	function propertyType(period) {

		if (period == "") {

			$("#divpropertyType").addClass("MyDisplayNone");
			$("#bhk").addClass("MyDisplayNone");
			$("#price").addClass("MyDisplayNone");
			$("#contractPeriod").addClass("MyDisplayNone");
			$("#securityAmount").addClass("MyDisplayNone");
			$("#address").addClass("MyDisplayNone");
			$("#propertyDescription").addClass("MyDisplayNone");
			$("#image").addClass("MyDisplayNone");
			$("#houseNumber").addClass("MyDisplayNone");
			$("#locality").addClass("MyDisplayNone");

			$("#submitButton").addClass("MyDisplayNone");
		}
		if (period == "Rent") {

			$("#divpropertyType").addClass("MyDisplayNone");
			$("#bhk").removeClass("MyDisplayNone");
			$("#price").removeClass("MyDisplayNone");
			$("#contractPeriod").removeClass("MyDisplayNone");
			$("#securityAmount").removeClass("MyDisplayNone");
			$("#address").removeClass("MyDisplayNone");
			$("#propertyDescription").removeClass("MyDisplayNone");
			$("#image").removeClass("MyDisplayNone");
			$("#houseNumber").removeClass("MyDisplayNone");
			$("#locality").removeClass("MyDisplayNone");
			$("#submitButton").removeClass("MyDisplayNone");

		}
		if (period == "Sale") {
			$("#divpropertyType").removeClass("MyDisplayNone");
			$("#bhk").addClass("MyDisplayNone");
			$("#price").addClass("MyDisplayNone");
			$("#contractPeriod").addClass("MyDisplayNone");
			$("#securityAmount").addClass("MyDisplayNone");
			$("#address").addClass("MyDisplayNone");
			$("#propertyDescription").addClass("MyDisplayNone");
			$("#image").addClass("MyDisplayNone");
			$("#houseNumber").addClass("MyDisplayNone");
			$("#locality").addClass("MyDisplayNone");

		}
	}

	function propertyLand(period) {

		if (period == "") {

			$("#price").addClass("MyDisplayNone");
			$("#address").addClass("MyDisplayNone");
			$("#propertyDescription").addClass("MyDisplayNone");
			$("#image").addClass("MyDisplayNone");
			$("#houseNumber").addClass("MyDisplayNone");
			$("#locality").addClass("MyDisplayNone");
			$("#submitButton").addClass("MyDisplayNone");
		}
		if (period == "House") {

			$("#bhk").removeClass("MyDisplayNone");
			$("#price").removeClass("MyDisplayNone");

			$("#address").removeClass("MyDisplayNone");
			$("#propertyDescription").removeClass("MyDisplayNone");
			$("#image").removeClass("MyDisplayNone");
			$("#houseNumber").removeClass("MyDisplayNone");
			$("#locality").removeClass("MyDisplayNone");
			$("#submitButton").removeClass("MyDisplayNone");
		}
		if (period == "Land") {
			$("#price").removeClass("MyDisplayNone");
			$("#address").removeClass("MyDisplayNone");
			$("#propertyDescription").removeClass("MyDisplayNone");
			$("#bhk").addClass("MyDisplayNone");
			$("#image").removeClass("MyDisplayNone");
			$("#houseNumber").removeClass("MyDisplayNone");
			$("#locality").removeClass("MyDisplayNone");
			$("#submitButton").removeClass("MyDisplayNone");
		}
	}
</script>
</head>
<body style="Background:" #eeee>

<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
           <%-- 
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="<c:url value="/page/searchProperty" />"><span class="glyphicon glyphicon-home"></span> Home</a>
                    </li>
                 </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div> --%>
        
            <!-- Brand and toggle get grouped for better mobile display -->
           
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
        <c:url value="/j_spring_security_logout" var="logoutUrl" />
 <form action="${logoutUrl}" method="post" id="logoutForm">
  <input type="hidden" name="${_csrf.parameterName}"
   value="${_csrf.token}" />
 </form>
   <li><a onclick="formSubmit()"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
      </ul>
                   
            </div>
           
        </div>
      
    </nav>
    <br/>
<br/>
	<div class="container">
		<p>
			<br />
		</p>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="page-header">
							<h1>Register Property</h1>
						</div>
					        
							<form class="form-horizontal " role="form">
							<div class="form-group " >
								<label for="select" class="col-lg-4 control-label">Action&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
								<div class="col-lg-8">
									<select class="form-control" id="select" name="Ex"
										onchange="actionFunction(this.value)">
										<option value="">Please select</option>
										<option value="add">Add</option>
										<option value="update">Update</option>
										<option value="delete">Delete</option>
									</select> <br>

								</div>
							</div>
							</form>
				
                     <ul class="nav MyDisplayNone" id="update">
<li class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
      Update <span class="caret"></span>
    </a>
    <ul class="dropdown-menu">
                     <c:forEach var="listValue" items="${userProperties }">
					

   
                          <li><a href="#" data-toggle="tab" >${listValue.key}</a></li>
        
   
      
</c:forEach>
                         </ul>
                         </li>
		               </ul>	
   
   
						<br>
						<c:if test="${not empty emailMsg}">
							<div class="msg">${emailMsg}</div>
						</c:if>
						<c:if test="${not empty errMsg1}">
							<div class="msg">${errMsg1}</div>
						</c:if>
						<form class="form-horizontal MyDisplayNone" role="form"
							action="userPropertyRegistration.html?${_csrf.parameterName}=${_csrf.token}"
							method="POST" modelAttribute="uploadForm"
							enctype="multipart/form-data" id="add">

							<div class="form-group " >
								<label for="select" class="col-lg-4 control-label">Property
									For&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
								<div class="col-lg-8">
									<select class="form-control" id="select" name="propertyForEx"
										onchange="propertyType(this.value)">
										<option value="">Please select</option>
										<option vale="Sale">Sale</option>
										<option value="Rent">Rent</option>
									</select> <br>

								</div>
							</div>

							<div class="form-group MyDisplayNone" id="divpropertyType">
								<label for="select" class="col-lg-4 control-label">Property
									Type&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
								<div class="col-lg-8">
									<select class="form-control" name="propertyTypeEx"
										onchange="propertyLand(this.value)">

										<option value="">Please select</option>
										<option value="House">House</option>
										<option value="Land">Land</option>

									</select> <br>

								</div>
							</div>

							<div class="form-group MyDisplayNone" id="bhk">
								<label for="select" class="col-lg-4 control-label">BHK&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
								<div class="col-lg-8">
									<select class="form-control" id="select" name="bhk">
										<option value="">Please select</option>
										<option value="1BHK">1BHK</option>
										<option value="2BHK">2BHK</option>
										<option value="3BHK">3BHK</option>

									</select> <br>

								</div>
							</div>

							<div class="form-group MyDisplayNone" id="price">
								<label for="inputEmail" class="col-lg-4 control-label">Price&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
								<div class="col-lg-8">
									<input type="number" class="form-control" id="inputPrice"
										placeholder="Price" name="price" onblur="blurPrice()" required>
								</div>
							</div>

							<div class="form-group MyDisplayNone" id="contractPeriod">
								<label for="inputEmail" class="col-lg-4 control-label">Contract
									Period&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
								<div class="col-lg-8">
									<input type="number" class="form-control"
										id="inputContractPeriod" placeholder="Contract Period"
										name="contractPeriod" value="0"
										onfocus="focusContractPeriod()" onblur="blurContractPeriod()">
								</div>
							</div>

							<div class="form-group MyDisplayNone" id="securityAmount">
								<label for="inputEmail" class="col-lg-4 control-label">Security
									Amount&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
								<div class="col-lg-8">
									<input type="number" class="form-control"
										id="inputSecurityAmount" placeholder="Security Amount"
										name="securityAmount" value="0"
										onfocus="focusSecurityAmount()" onblur="blurSecurityAmount()">
								</div>
							</div>
							<div class="form-group MyDisplayNone" id="houseNumber">
								<label for="inputEmail" class="col-lg-4 control-label">House/Plot
									Number&nbsp&nbsp&nbsp</label>
								<div class="col-lg-8">
									<input type="text" class="form-control" id="inputhouseNumber"
										placeholder="House/Plot Number" name="houseNumber" required>
								</div>
							</div>

							<div class="form-group MyDisplayNone" id="locality">
								<label for="inputEmail" class="col-lg-4 control-label">Locality&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
								<div class="col-lg-8">
									<input type="text" class="form-control" id="inputLocality"
										placeholder="Locality" name="locality" required>
								</div>
							</div>

							<div class="form-group MyDisplayNone" id="address">
								<label for="inputEmail" class="col-lg-4 control-label">Address&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
								<div class="col-lg-8">
									<input type="text" class="form-control" id="inputAddress"
										placeholder="Address" name="address" required>
								</div>
							</div>

							<div class="form-group MyDisplayNone" id="propertyDescription">
								<label for="textArea" class="col-lg-4 control-label">Property
									Description</label>
								<div class="col-lg-8">
									<textarea class="form-control" rows="3" id="textArea"
										name="propertyDescription"></textarea>

								</div>
							</div>


							<div class="form-group MyDisplayNone" id="image">
								<label for="inputEmail" class="col-lg-4 control-label">Image&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>

								<div class="col-lg-8">
									<div style="position: relative;">
										<a class='btn btn-default' href='javascript:;'> Browse
											Image <input type="file" name='file'
											style='position: absolute; z-index: 2; top: 0; left: 0; filter: alpha(opacity = 0); -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)"; opacity: 0; background-color: transparent; color: transparent;'
											name="image" size="40"
											onchange='$("#upload-file-info").html($(this).val());'>
										</a> &nbsp; <span class='label label-info' id="upload-file-info"></span>
									</div>
								</div>
							</div>


							<div class="form-group MyDisplayNone" id="submitButton">
								<div class="col-sm-offset-2 col-sm-10">
									<div class="col-sm-3"></div>

									<div class="col-sm-6">

										<!-- <button type="reset" class="btn btn-default">&nbspReset&nbsp</button> -->
										<button type="submit" class="btn btn-primary">Submit</button>
									</div>
									<div class="col-sm-3"></div>
								</div>
							</div>
							<%--  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> --%>
						</form>
						
						
					</div>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>

		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<link rel="stylesheet"
			href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script
			src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>