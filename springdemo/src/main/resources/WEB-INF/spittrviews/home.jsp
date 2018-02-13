<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spittr</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/WEB-INF/spittrviews/resources/style.css" /> ">
</head>
<body>
<h1>Welcome to Spittr</h1>
<a href="<c:url value="/WEB-INF/spittrviews/spittles" /> ">Spittles</a>
<a href="<c:url value="/WEB-INF/spittrviews/spitter/register" /> ">Register</a>
</body>
</html>