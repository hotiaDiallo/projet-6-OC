<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>LibraryExample</title>
 <link href="<c:url value='/css/style.css' />" type="text/css" rel="stylesheet" media="screen,projection"/>
 <link href="<c:url value='/css/bootstrap.min.css' />" type="text/css" rel="stylesheet" media="screen,projection"/>
 <link href="<c:url value='/webjars/bootstrap/4.0.0/css/bootstrap.min.css'/>"/>
 <script src="<c:url value='/webjars/jquery/3.0.0/jquery.min.js' />"></script>
 <script src="<c:url value='/webjars/bootstrap/4.0.0/js/bootstrap.min.js' />"></script>
</head>
<body>
  <%@include file="header.jsp" %>
  <div class="container" style="padding-top: 50px">
    <h2>Connexion</h2>
    <form method = "POST" action = "/user/connexion">
      <div class="form-group">
        <label for="email">Adresse mail</label>
        <input type="email" class="form-control" id="email" name="email" placeholder="Votre email"/>
      </div>
      <div class="form-group">
        <label for="password">Mot de passe</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="Votre mot de passe" />
      </div>
      <button type="submit" class="btn btn-primary btn-block">Valider</button>
    </form>
    <h4 style="color : red"><c:out value="${ messageToDisplay }"/></h4>
  </div>
</body>
</html>
