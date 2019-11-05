<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<h1>Register</h1>
<form action="register" method = "post">
    <label><b>User Name</b></label>
    <input type="text" placeholder="Enter user name" name="user" required>
 	<br>
    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
    <br>
    <button type="submit" class="registerbtn">Register</button>
    
</form>  
    <div>
    <p>Already have an account? <a href="Login.jsp">Sign in</a>.</p>
    </div>
</body>
</html>