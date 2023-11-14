<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class = "navbar navbar-default">
    <div class = "container-fluid">
        <div class = "collapse navbar-collapse" id = "bs-example-navbar-collapse-1">
            <ul class = "nav navbar-nav">
                <li><a href="<c:url value="/book/list"/>">Home</a></li>
                <li><a href="/">Profile</a></li>
                <c:if test="${user != null}">
                    <c:if test="${user.getRole() == 'admin'}">
                        <li><a href="<c:url value="/bookadd"></c:url>">Add book</a></li>
                    </c:if>
                    <li><a class ="nav-link disabled">${user.getUsername()}</a></li>
                </c:if>

                <c:if test="${user == null}">
                    <li><a href="<c:url value="/login"/>">Log in</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>