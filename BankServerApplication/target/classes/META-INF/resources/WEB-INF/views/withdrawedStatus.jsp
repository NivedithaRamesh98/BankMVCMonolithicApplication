<%@ page language="java" contentType="text/html; charset=ISO-8859-1"


    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw Status</title>
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
  <h3>Withdraw Amount:</h3>
  <h3>${transectionAmount}</h3>
  <br>
  <h3>Withdraw Transaction:</h3>
  <p>Transaction Id: ${transectionId}</p>
  <p>Transaction Type: ${transectionType}</p>
  <p>Transaction Date: ${transectionDate}</p>
  <p>Transaction Amount: ${transectionAmount}</p>
  <p>Check Balance: ${accountBalance}</p>
  <p>Transaction Status: ${transectionStatus}</p>
  <br>
  <br>
  <a href="/validateLogin"> Back to Home</a>
</div></div>
</body>
</html>