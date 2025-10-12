<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><meta charset="ISO-8859-1">
		<title></title>
		<link rel="stylesheet" href="content/css/rentOuts.css" type="text/css"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
</head>
<body>
<div class="background" id="bookForm">
    <div class="booking-form">
        <h2>Update Car Details</h2>
         <button onclick="location.href='homePage.html'">Cancel</button>
        <form action="updateCarController" method="post">
            <!-- <label for="platNo">Car Id:</label>
            <input type="text" name="carID" id="platNo" required> -->

			<label for="car_id">Id:</label>
            <input type="text" name="car_id" value="<c:out value="${car.car_id}"/>"  readonly><br>
            
            <label for="car_plate">Plate Number:</label>
            <input type="text" name="car_plate" value="<c:out value="${car.car_plate}"/>" readonly><br>
       
            <label for="car_brand">Brand:</label>
            <input type="text" name="car_brand" value="<c:out value="${car.car_brand}"/>" readonly><br>
            
            <label for="car_model">Model:</label>
            <input type="text" name="car_model" value="<c:out value="${car.car_model}"/>" readonly><br>
            
            <label for="car_type">Type:</label>
            <input type="text" name="car_type" value="<c:out value="${car.car_type}"/>" readonly><br>
            
            <label for="car_color">Color:</label>
            <input type="text" name="car_color" value="<c:out value="${car.car_color}"/>" readonly><br>
            
            <label for="no_of_seats">No. Of Seats:</label>
            <input type="number" name="no_of_seats" value="<c:out value="${car.no_of_seats}"/>" readonly><br>
            
            <label for="price_per_day">Price/Day:</label>
            <input type="text" name="price_per_day" value="<c:out value="${car.price_per_day}"/>" readonly><br>
            
            <label for="availability">Availability:</label>
            <input type="text" name="availability" value="<c:out value="${car.availability}"/>"  ><br>
             
            <label for="user_id">No. Of Seats:</label>
            <input type="text" name="user_id" value="<c:out value="${car.user_id}"/>"  readonly><br>           

            <button type="submit">Update Car</button>
            
        </form>
       
    </div>
  </div>
</body>
</html>