<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="includes/header.jsp" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script> function Chargement()
{
    var obj = document.getElementById("id_erreur");
    if (obj.value!='')
       alert('Erreur signalée  : "'+obj.value+"'");
}
</script>
<body  onLoad="Chargement();">
<section id="main" class="column">

	<article class="module width_full">
		<header>
			<h3>Choisir une commande</h3>
			</header>
		<div class="module_content">
<form method="post" action="Controleur" onsubmit="return verif();">
  <input type ="hidden" name="uneErreur"  value="${MesErreurs}"  id ="id_erreur" >
  <input type="hidden" name="action" value="factureCommande" />
	<fieldset style="width: 48%; float: left; margin-right: 3%;">
      <label>Commande</label>
      <select name="nocommand"  id="nocommand">
         <c:forEach  items="${idsCommande}"  var="item"  >
          <option value='<c:out value="${item}"/>'><c:out value="${item}"/></option>                
       </c:forEach>
   </select>
   </fieldset>
   <div class="clear"></div>

			<input type="submit"  value="Afficher" class="alt_btn">
				
			</form>
		</div>
	</article>
</section>