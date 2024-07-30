<%@ page language="java" contentType="text/html; charset=ISO-8859-1"


    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
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
<div class="login-container">
 <div class="login-form">
<body><h1>Bank Login</h1>

<form action="/addCustomer" method="post" modelAttribute="user">
  <div class="error">
            <spring:bind path="*" >
                <c:if test="${status.error}">
                    <c:forEach items="${status.errorMessage}" var="error">
                        ${error}
                    </c:forEach>
                </c:if>
            </spring:bind>
        </div>
 <div>
 <label for="userName">User Name: </label>
<input type="text" id="username" name="username" value="${loginForm.username}" />
 <div class="error">${loginForm.usernameError}</div></div>
<br>
<div>
  <label for="password">Password: </label>
  <input type="password" id="password" name="password" value="${loginForm.password}" />
  <div class="error">${loginForm.passwordError}</div>
</div>
<br>
<div>
   <input type="submit" name="btnLogin" value="LOGIN"/> 
</div>
<br>
</form>
<div>
 <form action="register" method="post" modelAttribute="new">
   <input type="submit" name="btnLogin" value="Register"/> 
   </form>
</div>
</form>
<div th:if=${error}">
<p th:text=${error}"></p>
</body>
</div> </div>
</html>