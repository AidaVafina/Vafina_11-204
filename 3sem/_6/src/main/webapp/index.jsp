<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/styles.css">
</head>
<body>
   <div class="container">
       <h2>Hello</h2>

       <form action="${pageContext.request.contextPath}/nameForm" method="GET">
           <input type="submit" value="Go to /nameForm">
       </form>
       <form action="${pageContext.request.contextPath}/createPet" method="GET">
           <input type="submit" value="Go to /createPet">
       </form>
       <form action="${pageContext.request.contextPath}/getPets" method="GET">
           <input type="submit" value="Go to /getPets">
       </form>
       <form action="${pageContext.request.contextPath}/removePet" method="GET">
           <input type="submit" value="Go to /removePet">
       </form>
       <form action="${pageContext.request.contextPath}/updatePet" method="GET">
           <input type="submit" value="Go to /updatePet">
       </form>
   </div>
</body>
</html>
