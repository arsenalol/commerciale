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
	<article class="module width_3_quarter">
		<header><h3 class="tabs_involved">Liste des articles de la commande ${numero}</h3>
  
		</header>
		<div class="tab_container">
		 <form name="deleteForm" method="post" action="Controleur">
		 <input type ="hidden" name="uneErreur"  value="${MesErreurs}"  id ="id_erreur" >
			<div id="tab1" class="tab_content">
	<table class="tablesorter" cellspacing="0">
		<thead>
		<tr>
      <th>Numéro Article</th>
      <th>Titre Article</th>
      <th>Quantité commandée</th>
      <th> Prix article</th>
    </tr>
		</thead>
  <c:forEach  items="${detailCde}"  var="item" >
   <tr>
        <td>${item.articles.noArticle}</td>
      <td>${item.articles.libArticle}</td>
       <td>${item.qteCdee}</td>
       <td>${item.articles.prixArt}</td>
       <c:set var ="total" value="${item.articles.prixArt + total}"/>
				
		
       
  </tr>
 </c:forEach>
 <tr>
		<td>Coût total de la commande : ${total}</td>
		</tr>
	</table>
	</div>
	</form>
		</div>
		</article>
</body>
</html>