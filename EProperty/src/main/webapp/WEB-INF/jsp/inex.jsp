<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<html lang=”en”>
<head>

<title>GL Retail Store</title>
<meta name=”description” content=”AnawesomeHTML5pageYOUbuiltfromscratch!”>
<meta name=”author” content=”Udemy”>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>
<body>
	<div id=”wrapper”>
		<header class=”main_headline”>

			<div class="bodyCss">
				<div class="logo">
					<img src="<c:url value="/resources/images/glLogo.jpg" />" alt=""
						width="80" height="58" /> <input type="search"
						name="searchGLStore"
						placeholder="type the name of item you want to search"
						width="60px" height="50px" class="searchBoxCss" /> <input
						type="button" value="search" name="searchButton" width="60px"
						height="50px" class="searchButtonCss" />
				</div>
			</div>
			<nav>
				<ul>
					<li><a href="/">ELECTRONICS</a>
						<ul>
							<li>
								<table style="width: 300px" class="tableCss">
									<tr>
										<td><a href="/crew">Mobiles</a></td>
										<td><a href="/crew">Cameras</a></td>
										<td><a href="/crew">Computers & Accessories</a></td>
									</tr>
									<tr>
										<td><a href="/crew">Eve</a></td>
										<td><a href="/crew">Jackson</a></td>
										<td><a href="/crew">94</a></td>
									</tr>
								</table>
							</li>
						</ul></li>
					<li><a href="/about">MEN</a>
						<ul>
							<li><a href="/crew">Clothing</a></li>
							<li><a href="/history">Footwear</a></li>
							<li><a href="/vision">Watches</a></li>
						</ul>
						<ul>
							<li><a href="/crew">Clothing</a></li>
							<li><a href="/history">Footwear</a></li>
							<li><a href="/vision">Watches</a></li>
						</ul></li>
					<li><a href="/products">WOMEN</a>
						<ul>
							<li><a href="/crew">Clothing</a></li>
							<li><a href="/history">Footwear</a></li>
							<li><a href="/vision">Watches</a></li>
						</ul></li>
					<li><a href="/services">BABY & KIDS</a>
						<ul>
							<li><a href="/crew">Clothing</a></li>
							<li><a href="/history">Footwear</a></li>
							<li><a href="/vision">Watches</a></li>
						</ul></li>
					<li><a href="/contact">BOOKS & MEDIA</a>
						<ul>
							<li><a href="/email">Games</a></li>
							<li><a href="/contact_form">Books</a></li>
							<li><a href="/pigeon">Music</a></li>
							<li><a href="/crew">Clothing</a></li>
							<li><a href="/history">Footwear</a></li>
							<li><a href="/vision">Watches</a></li>
							<li><a href="/crew">Clothing</a></li>
							<li><a href="/history">Footwear</a></li>
							<li><a href="/vision">Watches</a></li>
							<li><a href="/crew">Clothing</a></li>
							<li><a href="/history">Footwear</a></li>
							<li><a href="/vision">Watches</a></li>
						</ul></li>
					<li><a href="/contact">HOME & KITCHEN</a>
						<ul>
							<li><a href="/email">Kitchen</a></li>
							<li><a href="/contact_form">Bath</a></li>
							<li><a href="/pigeon">Living</a></li>
						</ul></li>
					<li><a href="/contact">OFFERS ZONE</a>
						<ul>
							<li><a href="/email">Offers on Clothing</a></li>
						</ul></li>
				</ul>
			</nav>

		</header>

		<div class="dropDownCss">
			<label class="selectLabel">Select Category</label> <select
				class="categoryList">
				<%
					List rptForm = (List) request.getAttribute("categoryList");
					System.out.println("size is " + rptForm.size());
				%>
				<c:forEach items="${categoryList}" var="section">
					<option value="${section}">${section}</option>
				</c:forEach>
			</select>
		</div>

		<div class="showLandingPageProductCss">
			<label class="selectLabel">Popular Products</label>
			<div class="productItemIndividualCss">
				<label>Clothing</label>
			</div>
			<table class="productTableCss">

				<tr>
					<td><a href="ClothingProduct.html" style="color: #95A9B1">
							<div class="productCss">
								<img src="<c:url value="/resources/images/shirt1.jpg" />"
									alt="Smiley face" height="180" width="230"> <br> <label><span
									style="color: blue">Turtle Men's Solid Formal Shirt<br>Rs.895
								</span></label>
							</div>
					</a></td>
					<td><a href="ClothingProduct.html" style="color: #95A9B1">
							<div class="productCss">
								<img src="<c:url value="/resources/images/shirt2.jpg" />"
									alt="Smiley face" height="180" width="230"> <br> <label><span
									style="color: blue">Turtle Men's Solid Classic Shirt<br>Rs.1095
								</span></label>
							</div>
					</a></td>
					<td><a href="ClothingProduct.html" style="color: #95A9B1"><div
								class="productCss">
								<img src="<c:url value="/resources/images/shirt3.jpg" />"
									alt="Smiley face" height="180" width="230"> <br> <label><span
									style="color: blue">Turtle Men's Solid Partywear Shirt<br>Rs.1595
								</span></label>
							</div></td>
					<td><a href="ClothingProduct.html" style="color: #95A9B1"><div
								class="productCss">
								<img src="<c:url value="/resources/images/shirt4.jpg" />"
									alt="Smiley face" height="180" width="230"> <br> <label><span
									style="color: blue">Turtle Men's Solid Marriage Shirt<br>Rs.1895
								</span></label>
							</div></a></td>
				</tr>

			</table>
		</div>

		<div class="showLandingPageProductCss">
			<div class="productItemIndividualCss">
				<label>Electronics</label>
			</div>
			<table class="productTableCss">
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>

		<div class="showLandingPageProductCss">
			<div class="productItemIndividualCss">
				<label>Books & Media</label>
			</div>
			<table class="productTableCss">
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>

		<footer>
			<center><p>CopyRight to GL Paetec team.</p></center>
		</footer>
	</div>
</body>
</html>