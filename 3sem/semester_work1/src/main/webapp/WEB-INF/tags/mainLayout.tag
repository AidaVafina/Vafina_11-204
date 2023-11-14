<%@tag description="Default Layout Tag" pageEncoding="UTF-8"%>
<%@attribute name="title"%>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
    <meta charset="UTF-8">
    <title>${title}</title>

    <link rel="stylesheet" href="<c:url value="/styles/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/styles/styles2.css"/>">
</head>
<body>
<%@include file="/WEB-INF/view/psrts/_nav.jsp"%>
<div class = "container">
    <jsp:doBody/>
</div>
</body>
</html>