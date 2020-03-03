<%--
  Created by IntelliJ IDEA.
  User: lukas
  Date: 02-03-2020
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Webshop</title>
</head>
<body>

<h2> Velkommen til din webshop. <h2>
 <br>
 <br>
 <br>

${requestScope.besked}


<form action="LogInServlet" method="post">
    <label for="fname">Brugernavn:</label><br>
    <input type="text" id="fname" name="name"><br>
    <label for="lname">Kodeord:</label><br>
    <input type="text" id="lname" name="kodeord"><br><br>
    <input type="submit" value="login">
</form>

</body>
</html>
