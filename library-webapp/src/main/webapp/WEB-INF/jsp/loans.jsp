<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="<c:url value='/css/style.css' />" type="text/css" rel="stylesheet" media="screen,projection"/>
 <link href="<c:url value='/css/bootstrap.min.css' />" type="text/css" rel="stylesheet" media="screen,projection"/>

<%@include file="header.jsp" %>
<div class"container">
  <h1> Vos prets </h1>
       <table class="table">
         <thead class="thead-dark">
          <tr>
           <th scope="col">Utilisateur</th>
           <th scope="col">Ouvrage</th>
           <th scope="col">Date de pret</th>
           <th scope="col">Date de restitution</th>
           <th scope="col">Status du pret</th>
           <th scope="col">Prolonger</th>
           <th scope="col">Restituer</th>
          </tr>
         </thead>
       <c:forEach items="${ loans }" var="loan" varStatus="status">
         <tbody>
          <tr>
           <td><c:out value="${ loan.user.firstName }"/><c:out value=" "/><c:out value="${ loan.user.lastName }"/></td>
           <td><c:out value="${ loan.book.esbn }"/></td>
           <td><c:out value="${ borrowingDate }"/></td>
           <td><c:out value="${ returningDate }"/></td>
           <td><c:out value="${ loan.loanStatus }"/></td>
           <td>
             <form method = "POST" action = "/loan/prolonger?id=${loan.id}">
             <c:choose>
                 <c:when test="${ loan.loanStatus == 'activated' }">
                    <button class="btn btn-primary">Prolonger</button>
                 </c:when>
                 <c:otherwise>
                    <button class="btn btn-primary" disabled>Prolonger</button>
                 </c:otherwise>
             </c:choose>
             </form>
           </td>
           <td>
              <form method = "POST" action = "/loan/restituer?id=${loan.id}">
                  <c:choose>
                       <c:when test="${ loan.loanStatus == 'returned' }">
                          <button class="btn btn-primary" disabled>Restituer</button>
                       </c:when>
                       <c:otherwise>
                          <button class="btn btn-primary">Restituer</button>
                       </c:otherwise>
                   </c:choose>
              </form>
            </td>
          </tr>
         </tbody>
       </c:forEach>
      </table>
  </div>
</div>