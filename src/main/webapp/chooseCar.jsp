<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Automobile Rental Service</title>
<link rel="stylesheet" href="./content/css/chooseCar.css">
<link
	href="https://cdn.jsdelivr.net/npm/remixicon@3.5.0/fonts/remixicon.min.css"
	rel="stylesheet">
<script src="https://unpkg.com/scrollreveal@4.0.9/dist/scrollreveal.js"></script>
</head>
<body>
	<input type="checkbox" id="bars">
	<nav class="nav-bar" id="navbar">
		<div class="content">
			<div class="logo nav__logo">
				<a href="#"><img src="content/carBackground.png" alt="logo" />
					<h1>MyCars</h1> </a>
			</div>

			<ul class="navigation">
				<li class="link"><a href="homePage.html">home</a></li>
				<li class="link"><a href="bookingCar.html">cars</a></li>
				<img src="content/setting3.png" class="user-pic" onclick="toggleMenu()">

				<div class="sub-menu-wrap" id="subMenu">
					<div class="sub-menu">
						<div div class="user-info">
							<i class="ri-profile-line"></i>
							<h2>Personal info</h2>
						</div>
						<hr>

						<a href="#" class="sub-menu-link"> <img
							src="content/profile.png" alt="">
							<p>Profie</p> <span>></span>
						</a> <a href="frontPage.html" class="sub-menu-link"> <img
							src="content/logout.png" alt="">
							<p>Logout</p> <span>></span>
						</a>

					</div>
				</div>
			</ul>
			<label for='bars' class="icon-bars"><i
				class="ri-bar-chart-2-fill"></i></label>
		</div>
	</nav>

	<header class="home" id="home">
		<div class="content">
			<h1>
				CHOOSE <strong>CAR</strong> BEFORE <strong>RENT</strong>
			</h1>
			<h4>Below is the car list</h4>
		</div>
	</header>
	<div class="admin-panel">
		<h2 id="booking-details">List of Cars</h2>
		<div class="car-form">
			<table>
				<tr>
					<th>No</th>
					<th>Car ID</th>
					<th>Car Type</th>
					<th>Car Brand</th>
					<th>Car Model</th>
					<th>Availability</th>
					<th colspan="3">Actions</th>
				</tr>
				
				<c:forEach items="${cars}" var="car" varStatus="cars">
   				<tr>
        			<td> <c:out value="${cars.index + 1}"/> </td>
        			<td> <c:out value="${car.car_id}"/> </td>
        			<td> <c:out value="${car.car_type}"/> </td>
        			<td> <c:out value="${car.car_brand}"/> </td>
        			<td> <c:out value="${car.car_model}"/> </td>
        			<td> <c:out value="${car.availability}"/> </td>
        			<td>
            			<c:if test="${car.availability != 'Unavailable'}">
                		<a class="choose" href="chooseController?id=<c:out value="${car.car_id}"/>">choose</a>
            			</c:if>
        			</td>
    			</tr>
				</c:forEach>

				
			</table>
		</div>
	</div>

	<script src="./js/homePage.js"></script>

</body>
</html>