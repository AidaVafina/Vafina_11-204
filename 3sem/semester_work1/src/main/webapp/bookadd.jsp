<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/psrts/_header.jsp" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Profile</title>
    <meta charset="UTF-8">

    <link rel="stylesheet" type="text/css"href="styles/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="styles/styles2.css">

    <script src="${pageContext.request.contextPath}/js/addbook.js"></script>

    <style>
        .container {
            max-width: 800px;
            margin: auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            overflow-y: auto;
        }

        .book-item {
            margin-top: 20px;
            padding: 10px;
            background-color: #dfdfdf;
            border-radius: 5px;
            text-align: left;
        }
    </style>
</head>
<body>
<div class="container-form-booklist">
    <form class="form-container">
        <h1>Add book</h1>
        <input type="text" id="title" name="title" placeholder="Title"><br>
        <input type="text" id="author" name="author" placeholder="Author"><br>
        <input type="text" id="age" name="age" placeholder="Age"><br>
        <input type="text" id="description" name="description" placeholder="Description"><br>
        <button type="button" onclick="addBook(event)">Add</button>
    </form>
    <div id="bookList"></div>
</div>
</body>
</html>

