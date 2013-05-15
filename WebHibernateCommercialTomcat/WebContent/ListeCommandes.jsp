<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %>
<script language="JavaScript">
      function checkAll(field)
      {
          for (i=0; i < field.length; i++)
          {   field[i].checked = true; }
      }
      function Chargement()
      {
          var obj = document.getElementById("id_erreur");
          if (obj.value!='')
             alert('Erreur signalée  : "'+obj.value+"'");
      }
  </script>
</head>
<body  onLoad="Chargement();">
<jsp:include page="includes/header.jsp" />
<section id="main" class="column">
	<c:if test="${(message == 'supprimer')}">
		<h4 class="alert_success">La commande a été supprimée</h4>
		</c:if>
		
		<c:if test="${(message == 'modif')}">
		<h4 class="alert_success">La modification a été prise en compte</h4>
		</c:if>
	<article class="module width_3_quarter">
	

		
				<header><h3 class="tabs_involved">Liste des Commandes</h3>
		
		</header>
		<div class="tab_container">
		
 <form name="deleteForm" method="post" action="Controleur">
 <input type ="hidden" name="uneErreur"  value="${MesErreurs}"  id ="id_erreur" >
  <input type="hidden" name="action" value="effacerCommande" />
  
	<div id="tab1" class="tab_content">
	<table class="tablesorter" cellspacing="0">
		<thead>
		<tr>
      <th><a href="javascript:checkAll(document.deleteForm.id)">Supprimer</a></th>
      <th>Action</th>
      <th>Numero</th>
      <th>Nom Vendeur</th>
      <th>Nom Client</th>
      <th>Date Commande </th>
    </tr>
    </thead>
  <c:forEach  items="${mescommandes}"  var="item" >
   <tr>
    <td><input type="checkbox" name="id" value="${item[0]}"></td>
      <td><a href="Controleur?action=modifierCommande&id=${item[0]}">Modifier</a></td>
      <td>${item[0]}</td>
      <td>${item[1]}</td>
       <td>${item[2]}</td>
      <td>
      <fmt:formatDate type="both" dateStyle="short"
          timeStyle="short" value="${item[3]}" pattern="dd/MM/yyyy"/>
      </td>     
  </tr>
 </c:forEach>
  <tr>
			<td colspan="5">
			
					<input type="submit" name="Delete Checked"
                                           value="Effacer les jouets coches"  class="alt_btn"/>
			
		</tr>
	</table>
	</div>
	</form>
		</div>
		</article>
		</section>
</body>
</html>
