<%@ page language="java" contentType="text/html; charset=ISO-8859-1"


    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit Page</title>
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
   <h3>Deposit Amount</h3>
   
   <form action="doDeposit" method="post" modelAttribute="deposit">
   <div>
      <label for="depositAmount">Depositing Amount:</label>
      <input type ="text" id=depositAmount" name="depositAmount" required>
      <br>
      <%-- Display error message if present --%>
    <c:if test="${not empty errorMessage}">
        <div style="color: red;">${errorMessage}</div>
    </c:if>
      <br>
      <label for="depositAmount">Account Number:</label>
       <input type ="text" id=accountNumber" name="accountNumber" value=<%= request.getParameter("accountNumber1") %>>
    </div>
    <br>
    <div>
     <button type="submit">Confirm Deposit</button>
     </div>
   </form>
   <br>
   <a href="validateLogin"> Back To Home</a>
</form>
</div> </div>
</body>
</html>