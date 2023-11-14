<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/psrts/_header.jsp" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="styles/styles2.css">

    <style>
        .user-info {
            margin-top: 40px;
        }

    </style>
</head>
<body>
<body>

<div class="container">
    <h1>Update your details</h1>
    <div class="user-info">
        <form action="/editProfile" method="post">
        <label for="newName">New Name:</label>
            <input type="text" id="newName" name="newName">
            <br>
            <label for="newSurname">New Surname:</label>
            <input type="text" id="newSurname" name="newSurname">
            <br>
            <label for="newPassword">New Password:</label>
            <input type="password" id="newPassword" name="newPassword">
            <br>
            <input type="submit" value="Save">
        </form>
    </div>
</div>
</body>
</body>
</html>