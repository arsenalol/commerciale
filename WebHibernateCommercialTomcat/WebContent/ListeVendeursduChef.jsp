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
		<header><h3 class="tabs_involved"> Les chefs d'équipe des vendeurs</h3>
  </header>
		<div class="tab_container">

 <form name="deleteForm" method="post" action="Controleur">
 <input type ="hidden" name="uneErreur"  value="${MesErreurs}"  id ="id_erreur" >
 <div id="tab1" class="tab_content">
	<table class="tablesorter" cellspacing="0">
		<thead>
		<tr>
      <th>Nom Vendeur </th>
      <th>Prenom Vendeur </th>
      <th>Nom Chef</th>
      <th>Prenom Chef </th>
      
    	
		</tr>
		</thead>
  <c:forEach  items="${mesvendeurs}"  var="item" >
   <tr>
       <td>${item[0]}</td>
      <td>${item[1]}</td>
       <td>${item[2]}</td>
       <td>${item[3]}</td>
  </tr>
 </c:forEach>
 </table>
	</div>
	</form>
		</div>
		</article>
</body>
</html>