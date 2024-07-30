<%@ page language="java" contentType="text/html; charset=ISO-8859-1"


    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Details</title>
<style>
.login-container {
     display: flex;
     justify-content: center;
     align-items: center;
     height: 80vh; /* Set the height of the container to full viewport height */
  }
   .login-form {
     width: 300px; /* Set the width of the form */
 }
.error {
     color: red;
   }
    </style>
</head>
<body>
<div class="login-container">
 <div class="login-form">
   <h2>Account Details</h2>
   
   <form action="addAccount" method="get">
    <div>
      <label for="accountNumber">Account Number:</label>
      <input type ="text" id=accountNumber" name="accountNumber" required>
    </div> 
    <br>
    <div>
      <label for="accountType">Account Type:</label>
      <input type ="text" id=accountType" name="accountType" required>
    </div> 
    <br>
    <div>
      <label for="accountBalance">Account Balance:</label>
      <input type ="text" id="accountBalance" name="accountBalance" required>
    </div> 
    <br>
    <br>
    <div>
     <button type="submit" name="accBtn" value="Register">Add</button>
     </div>
     <br>
     <a href="/addCustomer"> Back to Welcome page</a>
   </form>
  </div> </div>
</body>
</html>