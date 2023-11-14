<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/psrts/_header.jsp" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calendar</title>

    <link rel="stylesheet" type="text/css" href="styles/styles2.css">
    <link rel="stylesheet" type="text/css"href="styles/bootstrap.min.css">


    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #ffe0e5;
            height: 100vh;
        }

        .container {
            width: 400px;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            margin-bottom: 20px;
        }

        label {
            display: inline-block;
            width: 100px;
            text-align: right;
            margin-right: 10px;
        }

        input {
            width: 240px;
            height: 30px;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;
        }

        button {
            width: 100%;
            height: 40px;
            background-color: #4e4647;
            border: none;
            border-radius: 5px;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #999;
        }
    </style>

</head>
<body>
<form>
    <div class="container">
        <h1 class="logo">Make an appointment</h1>
        <form class="form-container">
            <label for="date">Дата:</label>
            <input type="date" id="date" name="date"><br>

            <label for="time">Время:</label>
            <input type="time" id="time" name="time"><br>

            <label for="location">Место:</label>
            <input type="text" id="location" name="location"><br>

            <label for="subject">Тема:</label>
            <input type="text" id="subject" name="subject"><br>

            <button type="submit">create</button>
        </form>
    </div>
</form>

</body>
</html>
