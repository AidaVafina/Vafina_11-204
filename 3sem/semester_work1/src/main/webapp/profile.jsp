<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/psrts/_header.jsp" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css"href="styles/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="styles/styles2.css">

    <style>
        .user-info {
            margin-top: 40px;
        }
        .btn {
            color: white;
            font-size: 16px;
            cursor: pointer;
            margin-top: 10px;
            padding: 10px 20px;
            background-color: #4e4647;
            border: none;
            border-radius: 5px;
            text-decoration: none;
        }
        .btn:hover {
            background-color: #999;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Your profile</h1>
        <div class="user-info">
        <p>Name: ${user.name}</p>
        <p>Surname:  ${user.surname}</p>
        <p>Password: ${user.password}</p>
        </div>
        <a href="editProfile.jsp" class="btn btn-primary">Edit Profile</a>
    </div>
</body>
</html>
