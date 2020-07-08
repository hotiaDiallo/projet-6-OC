
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link href="<c:url value='/css/main.css' />" type="text/css" rel="stylesheet" media="screen,projection"/>
<nav id="navbar">
    <div class="container">
      <ul>
        <li><a class="current" href="/">Accueil</a></li>
        <li><a href="${contextPath}/loan/my-loans">Prets</a></li>
        <li><a href="${contextPath}/ouvrages/all">Livres</a></li>
        <li><a href="${contextPath}/ouvrages/rechercher">Rechercher</a></li>
        <li><a href="${contextPath}/user/login">Connexion</a></li>

        <%--
        <c:choose>
           <c:when test="${!empty sessionScope.userInfo && sessionScope.userInfo.connected == 'connected' }">
              <li><a href="${contextPath}/user/deconnexion">Deconnexion</a></li>
           </c:when>
           <c:otherwise>
              <li><a href="${contextPath}/user/login">Connexion</a></li>
           </c:otherwise>
       </c:choose>
       --%>
      </ul>
    </div>
</nav>