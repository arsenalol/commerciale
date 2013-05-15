<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %>

<script language="JavaScript">
      function Chargement()
      {
          var obj = document.getElementById("id_erreur");
          if (obj.value!='')
             alert('Erreur signalée  : "'+obj.value+"'");
      }
  </script>
<body  onLoad="Chargement();">
<jsp:include page="includes/header.jsp" />
<section id="main" class="column">
	<article class="module width_3_quarter">
		<header><h3 class="tabs_involved">Liste des composants de l'article ${numeroArticle}</h3>
  
		</header>
		<div class="tab_container">
 <form name="deleteForm" method="post" action="Controleur">
 <input type ="hidden" name="uneErreur"  value="${MesErreurs}"  id ="id_erreur" >
 <div id="tab1" class="tab_content">
	<table class="tablesorter" cellspacing="0">
		<thead>
		<tr>
      <th>Numero compose </th>
      <th>Nom compose </th>
      <th>Quantite de composant</th>
   </tr>
		</thead>
  <c:forEach  items="${listeCompose}"  var="item" >
   <tr>
       <td>${item.articlesByNoComposant.noArticle}</td>
      <td>${item.articlesByNoComposant.libArticle}</td>
       <td>${item.qteComposant}</td>
  </tr>
 </c:forEach>
 </table>
	</div>
	</form>
		</div>
		</article>
</section>