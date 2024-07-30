<%@ page language="java" contentType="text/html; charset=ISO-8859-1"


    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Home Page</title>
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
   <table border="1">
     <thead>
       <tr>
         <th>Account Id</th>
         <th>Account Number</th>
         <th>Account Type</th>
         <th>Account Balance</th>
        </tr>
      </thead>
      <tbody>
        <c: forEach var="account" items="${accounts}">
          <tr>
            <td>${accountId}</td>
            <td>${accountNumber}</td>
            <td>${accountType}</td>
            <td>${accountBalance}</td>
          </tr>
        </c:forEach>  
      </tbody> 
      </table>
      </div> </div>
</body>
</html>