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
        
        <li><a href="#">Admin</a></li>
          </ul>
          
          <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
      </ul>
                   
            </div>
           
        </div>
      
    </nav>
    


    
    
    <!-- Page Content -->
    <div class="container">

        <!-- Page Heading -->
        <table class="table table-striped">
    <thead>
      <tr>
        <th>UserName</th>
        <th>Broker Id</th>
        <th>Network Id</th>
         <th>Branch Id</th>
        <th> 
         <a href="<c:url value="/page/createbroker"/>" class="btn btn-default"><span class="glyphicon glyphicon-plus-sign"></span>
          Add Broker
        </a></th>
      </tr>
    </thead>
    <tbody>
        <!-- Project One -->
      
       <c:forEach var="listValue" items="${ brokerDtos}">
       
         <c:choose>
		    
    <c:when test="${listValue.activeStatus == 'Y'}">
       <c:set  var="status"  value=' none'/>
    </c:when>
    <c:when test="${listValue.activeStatus == 'N'}">
        <c:set var="status" value=''/>
    </c:when>
    <c:otherwise>
        <c:set var="status"  value=''/>
    </c:otherwise>
</c:choose>

	   
   <tr>
        <td>${listValue.userName}</td>
        <td>${listValue.brokerId}</td>
      <td>${listValue.networkId}</td>
      <td>${listValue.branchId}</td>
       
	   <td>
	   <button type="button" class="btn btn-success" display=${status} >Approve</button>
        <button type="button" class="btn btn-danger" display=${status}>Reject</button>
        <c:if test="${status=='Y'}">
   <p>Approved<p>
</c:if>
 <c:if test="${status=='N'}">
   <p>Rejected<p>
</c:if>
      </td>
	  
	  </tr>
	  
    </c:forEach>
    </tbody>
  </table>
   <script src=" https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>
