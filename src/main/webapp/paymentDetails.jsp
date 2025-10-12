<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Automobile Rental Service</title>
  <link rel="stylesheet" href="./content/css/bookingDetails.css">
  <link href="https://cdn.jsdelivr.net/npm/remixicon@3.5.0/fonts/remixicon.min.css" rel="stylesheet">
  <script src="https://unpkg.com/scrollreveal@4.0.9/dist/scrollreveal.js"></script>
</head>

<body>

<input type="checkbox" id="bars">
  <nav class="nav-bar" id="navbar">
    <div class="content">
      <div class="logo nav__logo">
        <a href="#"><img src="content/carBackground.png" alt="logo" />
        <h1>MyCars</h1>
        </a>
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

            <a href="#" class="sub-menu-link">
              <img src="content/profile.png" alt="">
              <p>Profie</p>
              <span>></span>
            </a>
            <a href="frontPage.html" class="sub-menu-link">
              <img src="content/logout.png" alt="">
              <p>Logout</p>
              <span>></span>
            </a>

          </div>
        </div>
      
      </ul>

      <label for='bars' class="icon-bars"><i class="ri-bar-chart-2-fill"></i></label>
    </div>
  </nav>

  <header class="home" id="home">
    <div class="content">
      <h1> CONFIRM <strong>DETAILS <br>	</strong> BEFORE <strong>PAYMENT</strong> </h1>
      <h4>Below is the car and booking details</h4>  
    </div>
  </header>

  <section class="car-form-panel">
    <div class="form-instructions">
      <h2 id="user-id">USER ID : <c:out value="${bridge.rr_id}"/></h2>
      
      <br></br>
      <h2 id="enter-details">CAR DETAILS</h2>
    </div>
    <!-- car table -->
    <div class="car-form1">
      <table>
      
          <tr>
            <td><strong>Car ID:</strong></td>
            <td> <c:out value="${bridge.car_id}"/> </td>
          </tr>
          <tr>
            <td><strong>Car Type:</strong></td>
            <td> <c:out value="${bridge.car_type}"/> </td>
          </tr>
          <tr>
            <td><strong>Car Brand:</strong></td>
            <td> <c:out value="${bridge.car_brand}"/> </td>
          </tr>
          <tr>
            <td><strong>Car Model:</strong></td>
            <td> <c:out value="${bridge.car_model}"/> </td>
          </tr>
          <tr>
            <td><strong>Car Color:</strong></td>
            <td> <c:out value="${bridge.car_color}"/> </td>
          </tr>
          <tr>
            <td><strong>Number of Seats:</strong></td>
            <td> <c:out value="${bridge.no_of_seats}"/> </td>
          </tr>
          <tr>
            <td><strong>Price/hour (RM):</strong></td>
            <td> <c:out value="${bridge.price_per_day}"/> </td>
          </tr>
          
      </table>
    </div>

    <!-- Booking table -->
    <div class="form-instructions">
      <h2 id="booking-details">BOOKING DETAILS</h2>
    </div>
    <div class="car-form1">
      <table>
      	<tr>
          <td><strong>Booking ID:</strong></td>
          <td> <c:out value="${bridge.booking_id}"/> </td>
        </tr>
        <tr>
          <td><strong>Booking Date:</strong></td>
          <td> <c:out value="${bridge.booking_date}"/> </td>
        </tr>
        <tr>
          <td><strong>Pickup Location:</strong></td>
          <td> <c:out value="${bridge.pickup_location}"/> </td>
        </tr>
        <tr>
          <td><strong>Drop Location:</strong></td>
          <td> <c:out value="${bridge.drop_location}"/> </td>
        </tr>
        
      </table>
    </div>
    
    <!-- Payment form -->
    <div class="form-instructions">
      <h2 id="enter-details">ENTER DETAILS FOR PAYMENT</h2>
    </div>
    <div class="car-form">
      <form action="addPaymentController" method="post">

        <label for="payment_type">Payment Type:</label>
        <input type="text" id="payment_type" name="payment_type" required>
        
        <label for="booking_id">Booking ID:</label>
        <input type="text" id="booking_id" name="booking_id"  value="<c:out value="${bridge.booking_id}"/>" required readonly>

        <input type="submit" id="btn-submit" value="PAY" onclick="location.href='#'">
      </form>
      
    </div>   

  </section>

  <script src="./js/homePage.js"></script>

</body>

</html>
