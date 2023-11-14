<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to our website</title>
    <link rel="stylesheet" type="text/css"href="styles/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="styles/styles.css">

</head>
<body>
<p>Please login or register to continue</p>

<form action="login" method="POST">
    <h2>Login</h2>
    <label for="username">Name:</label>
    <input type="text" id="username" name="username" required>

    <label for="surname">Surname:</label>
    <input type="text" id="surname" name="surname" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <button type="submit">Login</button>
</form>
</body>
</html>
