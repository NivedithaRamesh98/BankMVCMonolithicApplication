<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw</title>
<style>
.login-container {
     display: flex;
     justify-content: center;
     align-items: center;
     height: 80vh; /* Set the height of the container to full viewport height */
  }
   .login-form {
     width: 330px; /* Set the width of the form */
 }
.error {
     color: red;
   }
    </style>
</head>
<body>
<div class="login-container">
 <div class="login-form">
  <h3>Withdraw Amount</h3>
    <form action="doWithdraw" method="post">
     <div>
      <label for="withdrawAmount">Withdrawal Amount:</label>
      <input type="text" id="withdrawAmount" name="withdrawAmount" required>
    </div>
    <%-- Display error message if present --%>
    <c:if test="${not empty errorMessage}">
        <div style="color: red;">${errorMessage}</div>
    </c:if>
    <br>
    <label for="depositAmount">Account Number:</label>
    <input type="text" id="accountNumber" name="accountNumber" value="<%= request.getParameter("accountNumber2") %>">  
    <div>
    <br>
     <button type="submit">Confirm Withdraw</button>
     </div><br>
   </form>
   <a href="validateLogin"> Back To Home</a>
   </div.
   </div>
</body>
</html>
