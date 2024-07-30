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
   <h2>Transaction History</h2>
   <table border="1">
     <thead>
       <tr>
         <th>Transaction ID</th>
         <th>Transaction Type</th>
         <th>Transaction Amount </th>
         <th>Transaction Date</th>
         <th>Transaction Status</th>
        </tr>
      </thead>
      <tbody>
        <c: forEach var="transaction" items="${transactions}">
          <tr>
            <td>${transactionId}</td>
             <td>${transactionType}</td>
              <td>${transactionAmount}</td>
               <td>${transactionDate}</td>
                <td>${transactionStatus}</td>
          </tr>
        </c:forEach>  
      </tbody> 
      </table>
      </div> </div>
</body>
</html>