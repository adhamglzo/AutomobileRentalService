<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><meta charset="ISO-8859-1">
		<title></title>
		<link rel="stylesheet" href="./content/css/rentOut.css" type="text/css"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
</head>
<body>
<div class="background" id="bookForm">
    <div class="booking-form">
        <h2>Update Admin Form</h2>
        <form action="UpdateAdminController" method="post">
            <!-- <label for="platNo">Car Id:</label>
            <input type="text" name="carID" id="platNo" required> -->

			<label for="admin_id">Name:</label>
            <input type="text" name="admin_id" id="admin_id" value="<c:out value="${admin.admin_id}"/>" readonly required>
       
            <label for="admin_name">Name:</label>
            <input type="text" name="admin_name" id="admin_name" value="<c:out value="${admin.admin_name}"/>" required>
       
            <label for="admin_password">Password:</label>
            <input type="password" name="admin_password" id="admin_password" value="<c:out value="${admin.admin_password}"/>" required>
       
            <label for="admin_address">Address:</label>
            <input type="text" name="admin_address" id="admin_address" value="<c:out value="${admin.admin_address}"/>" required>
           
            <label for="admin_pNum">Phone Number:</label>
            <input type="text" name="admin_pNum" id="admin_pNum" value="<c:out value="${admin.admin_pNum}"/>" required>

            <label for="admin_email">Email:</label>
            <input type="text" name="admin_email" id="admin_email" value="<c:out value="${admin.admin_email}"/>" required>

            <label for="admin_title">Title:</label>
            <input type="text" name="admin_title" id="admin_title" value="<c:out value="${admin.admin_title}"/>" required>

            <label for="admin_department">Department:</label>
            <input type="text" name="admin_department" id="admin_department"  value="<c:out value="${admin.admin_department}"/>" required>
            
            

            <button type="submit">Update Admin Details</button>
        </form>
    </div>
  </div>
</body>
</html>