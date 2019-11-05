<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log in</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<h1>Sign in</h1>
	<form action="login" method = "post">
    <label for="user"><b>User Name</b></label>
    <input type="text" placeholder="Enter user name" name="user" required>
 	<br>
    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
    <br>
    <button type="submit" class="registerbtn">Sign in</button>
    
</form>  
</body>
</html>