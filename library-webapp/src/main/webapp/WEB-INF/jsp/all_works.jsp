<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <link href="<c:url value='/css/style.css' />" type="text/css" rel="stylesheet" media="screen,projection"/>
 <link href="<c:url value='/css/bootstrap.min.css' />" type="text/css" rel="stylesheet" media="screen,projection"/>
<script src="<c:url value='/js/main.js' />"></script>
<%@include file="header.jsp" %>
<div class"container container-marge">
  <h1> Tous les livres de votre bibliotheque </h1>
  <table class="table">
     <thead class="thead-dark">
      <tr>
       <th scope="col" style="text-align:center">Titre</th>
       <th scope="col" style="text-align:center">Auteur</th>
       <th scope="col" style="text-align:center">Sommaire</th>
       <th scope="col" style="text-align:center">Nombre de livres disponibles</th>
       <th scope="col"></th>
      </tr>
     </thead>
      <c:forEach items="${ works }" var="work" varStatus="status">
         <tbody>
          <tr>
           <td style="text-align:center"><c:out value="${ work.title }"/></td>
           <td style="text-align:center"><c:out value="${ work.author.firstName}"/><c:out value="${ work.author.lastName}"/></td>
           <td style="text-align:center"><c:out value="${ work.summary }"/></td>
           <c:if test="${nbAvailableBooks.get(work.books.id) > 0 }" var="variable">
              <td id="number" style="text-align:center"><c:out value="${ nbAvailableBooks.get(work.books.id) }"/></td>
           </c:if>
           <c:if test="${nbAvailableBooks.get(work.books.id) == 0 }" var="variable">
              <td></td>
           </c:if>
           <td>
               <form method = "POST" action = "/loan/create?id=${work.id}">
                    <c:if test="${nbAvailableBooks.get(work.books.id) == 0 }" var="variable">
                        <button id="loan" class="btn btn-primary" disabled>Emprunter</button>
                    </c:if>
                    <c:if test="${nbAvailableBooks.get(work.books.id) > 0 }" var="variable">
                       <button id="loan" class="btn btn-primary">Emprunter</button>
                    </c:if>
               </form>
           </td>
          </tr>
         </tbody>
      </c:forEach>
  </table>
  <br/><br/>
</div>
