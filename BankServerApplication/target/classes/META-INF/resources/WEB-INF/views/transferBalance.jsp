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
 <h2>Transfer Successfull</h2>
 <br>
  
  <h3>Deposited Amount:</h3>
  <h3>${transferAmount}</h3>
  <br>
  <h3>Transaction Details:</h3>
  <p>Transaction Id: ${transactionId}</p>
  <p>Transaction Type: ${transactionType}</p>
  <p>Transaction Date: ${transactionDate}</p>
  <p>Transaction Amount: ${transactionAmount}</p>
  <p>Transaction Status: ${transactionStatus}</p>
  <br>
  <br>
  <a href="/addCustomer"> Back to Home</a>
</div></div>
</body>
</html>