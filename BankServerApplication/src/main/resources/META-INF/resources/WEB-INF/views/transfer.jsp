<%@ page language="java" contentType="text/html; charset=ISO-8859-1"


    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer Page</title>
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

<div class="login-container">
 <div class="login-form">
  <body><h3>Account Transfer:</h3>
<form action="doTransfer" method="post">

<br>
<div>
 <label for="fromAccountNumber">Source Account: </label>
 <input type="text" name="fromAccountNumber" placeholder="Enter Account" required></input>
</div>
<br>
<div>
  <label for="toAccountNumber">Destination Account: </label>
  <input type="text" name="toAccountNumber" placeholder="Enter Account" required/>
</div>
<br>
<div>
  <label for="transferAmount">Transfer Amount: </label>
  <input type="text" name="transferAmount" placeholder="Enter Amount" required/>
</div>
<br>
<div>
   <input type="submit" name="btnLogin" value="Confirm Transfer"/> 
</div>
<br>
</form>
</body>
</div></div>

</html>