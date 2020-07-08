<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>home</title>
    <link href="<c:url value='/css/main.css' />" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="<c:url value='/webjars/bootstrap/4.0.0/css/bootstrap.min.css'/>"/>
    <script src="<c:url value='/webjars/jquery/3.0.0/jquery.min.js' />"></script>
    <script src="<c:url value='/webjars/bootstrap/4.0.0/js/bootstrap.min.js' />"></script>
</head>
<body>
    <%@include file="header.jsp" %>
    <header id="showcase">
      <div class="showcase-content">
        <h1 class="l-heading">
          Hello! Bienvenue dans la nouvelle bibliotheque de votre ville
        </h1>
        <p class="lead">
          Votre bibliotheque est ouvert du lundi au vendredi.
        </p>
      </div>
    </header>
</body>
</html>