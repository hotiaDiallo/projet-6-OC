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
 <script src="<c:url value='/webjars/jquery/3.0.0/jquery.min.js' />"></script>
 <script src="<c:url value='/webjars/bootstrap/4.0.0/js/bootstrap.min.js' />"></script>
</head>
<body>
    <%@include file="header.jsp" %>
    <div class="container" style="padding-top: 30px">
      <form id="form" class="form" method = "POST" action = "/ouvrages">
        <h2>Recherche de livres</h2>
        <div class="form-group">
          <label for="title">Recherche par titre</label>
          <input type="text" class="form-control" id="title" name="title" placeholder="Le titre de l'ouvrage" />
        </div>
        <div class="form-group" style="border-top: 2px solid #CCC;"></div>
        <div class="form-group">
          <label for="author">Recherche par auteur</label>
          <input type="text" class="form-control" id="author" name="author" placeholder="L'auteur de l'ouvrage" />
        </div>
        <button type="submit" class="btn btn-primary btn-block">Valider</button>
      </form>
      <h4 style="color:red"><c:out value="${ messageToDisplay }"/></h4>
    </div>
</body>
</html>