<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Header</title>

    <script src = "<c:url value="/js/bootstrap.min.js"/>"></script>

    <link rel="stylesheet" href="<c:url value="/styles/bootstrap.min.css"/>">

</head>
<body>
<header>
    <nav>
        <div class="profile">
            <img src="${pageContext.request.contextPath}/pictures/logo.jpg" alt="Profile Picture">
        </div>
        <ul class="menu">
            <li><a href="<%= request.getContextPath() %>/welcome.jsp">Home</a></li>
            <li><a href="<%= request.getContextPath() %>/profile">Profile</a></li>
            <li><a href="<%= request.getContextPath() %>/bookadd.jsp">Add book</a></li>
            <li><a href="<%= request.getContextPath() %>/calendar.jsp">Calendar</a></li>
            </ul>
    </nav>
</header>
</body>
</html>
