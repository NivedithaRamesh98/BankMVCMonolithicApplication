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
<script type="text/javascript">

function set() {
if(document.getElementById('accountNumber')) {
  var id1 = document.getElementById('accountNumber').value;
  console.log('r',id1);
  document.getElementById('accountNumber1').value = id1;
  document.getElementById('accountNumber2').value = id1;
  }
}

 </script>
<body>
<div class="login-container">
 <div class="login-form">
   <h1>Welcome, ${customerName}</h1>
   <br>
   <h3>Customer Id: ${customerId}</h3>
   <h3>Customer Email: ${emailId}</h3>
   <h3>Account Number: ${accountNumber}</h3>

   <form action="accountForm">
    <div>
     
    </div>
   </form>
   <br>
   <form action="checkBal">
   <div>
      <label for="accountNumber">Account Number:</label>
      <input type ="text" id="accountNumber" name="accountNumber" required onKeyUp="set()" >

    </div>
    <div>
     <button type="submit">Check Balance</button>
     </div>
   </form>
  
   <form action="depositForm" >
    <div> 
      
      <input type ="hidden" id="accountNumber1" name="accountNumber1" value=''>
      <br>
     <button type="submit">Deposit</button>
     </div>
   </form>

   <form action="withdrawForm" >
    <div> 
     
      <input type ="hidden" id="accountNumber2" name="accountNumber2" value=''>
      <br>
      <button type="submit">Withdraw</button>
     </div>
   </form>
    <br>
    <form action="transferForm" method="post">
     <button type="submit">Transfer</button>
   </form>
   <br>
   <form action="transactionForm" method="post">
     <button type="submit">Transactions</button>
   </form>
   <br>
   <br>
   <form action="logout" method="post">
     <button type="submit"> LOGOUT </button>
   </form> 
   </div> </div>
</body>
</html>