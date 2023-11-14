<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ include file="/WEB-INF/view/psrts/_header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>

    <link rel="stylesheet" type="text/css"href="styles/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="styles/styles2.css">

</head>
<body>

<div class="content">
    <h1>What book would you like to read?</h1>

    <div class="form-container">
        <form>
            <input type="text" name="query" placeholder="enter book title...">
            <button type="submit" style="color: #ffe0e5">Search</button>
        </form>
    </div>

</div>
</body>
</html>
