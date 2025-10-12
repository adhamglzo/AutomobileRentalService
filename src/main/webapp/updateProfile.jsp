<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Automobile Rental Service</title>
  <link rel="stylesheet" href="./content/css/profile_2.css">
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
        <img src="content/setting3.png" class="user-pic" onclick="toggleMenu()">

        <div class="sub-menu-wrap" id="subMenu">
          <div class="sub-menu">
            <div div class="user-info">
              <i class="ri-profile-line"></i>
              <h2>Personal info</h2>
            </div>
            <hr>

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
      <h1>Profile <strong>Setting</strong>  <strong></strong> </h1>
	  <h4>Update Details</h4>
    </div>
  </header>

  <section class="car-form-panel">
    <div class="form-instructions">
      <h2 id="enter-details">PROFILE DETAILS</h2>
    </div>
    <div class="car-form">
      <form action="updateProfileController" method="post">

        <label for="rrID">User ID :</label>
        <input type="text" id="rrID" name="rrID" value="<c:out value="${renter_renting.rr_id}"/>" readonly><br>

        <label for="userName">User Name :</label>
        <input type="text" name="userName" value="<c:out value="${user.user_name}"/>" ><br>

        <label for="userPassword">User Password :</label>
        <input type="text" id="userPassword" name="userPassword" value="<c:out value="${user.user_password}"/>" ><br>
        
        <label for="userEmail">E-mail :</label>
        <input type="text" id="userEmail" name="userEmail" value="<c:out value="${user.user_email}"/>" ><br>

        <label for="userAddress">User Address :</label>
        <input type="text" id="userAddress" name="userAddress" value="<c:out value="${renter_renting.rr_address}"/>" ><br>
        
        <label for="phoneName">Phone Number :</label>
        <input type="text" id="phoneName" name="phoneName" value="<c:out value="${renter_renting.rr_pNum}"/>" ><br>
        
        <label for="license">License :</label>
        <input type="text" id="license" name="license" value="<c:out value="${renter_renting.rr_license}"/>" ><br>
        
        <label for="experience">Experience :</label>
        <input type="text" id="experience" name="experience" value="<c:out value="${renter_renting.rr_experience}"/>" ><br>

        <input type="submit" id="btn-submit" value="COMFIRM">
      </form>
      
    </div>    
    
  </section>

  <script src="./js/homePage.js"></script>

</body>

</html>