<%@ page language="java" contentType="text/html; charset=ISO-8859-1"


    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<style>
.login-container {
     display: flex;
     justify-content: center;
     align-items: center;
     height: 80vh; /* Set the height of the container to full viewport height */
  }
   .login-form {
     width: 320px; /* Set the width of the form */
 }
.error {
     color: red;
   }
    </style>
</head>
<body>
<div class="login-container">
 <div class="login-form">
   <h1>New Registration</h1>
   
   <form action="registerDetails" method="get">
    <div>
      <label for="customerId">Customer ID:</label>
      <input type ="text" id=customerId" name="customerId" >
      <div class="error">${loginForm.customerId}</div>
    </div> 
    <br>
    <div>
      <label for="customerEmailId">Customer Email Id:</label>
      <input type ="text" id=customerEmailId" name="customerEmailId" >
      <div class="error">${loginForm.customerEmailId}</div>
    </div> 
    <br>
    <div>
      <label for="customerName">Customer Name:</label>
      <input type ="text" id=customerName" name="customerName" >
      <div class="error">${loginForm.customerName}</div>
    </div> 
    <br>
    <div>
      <label for="userName">User Name:</label>
      <input type ="text" id=userName" name="userName" >
      <div class="error">${loginForm.userName}</div>
    </div>
    <br>
    <div>
      <label for="Password">Password:</label>
      <input type ="text" id=Password" name="Password">
      <div class="error">${loginForm.Password}</div>
    </div>
    <br>
    <div>
     <button type="submit" name="btnLogin" value="Register">Register</button>
     </div>
   </form>
  </div>
  </div>
</body>
</html>