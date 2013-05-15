<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="includes/header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script language=javascript type="text/javascript">
  function verif()
  {
  if(document.getElementById("id").value == "" || 
     document.getElementById("noClient").value == "" || 
     document.getElementById("noVendeur").value == "" ||
     document.getElementById("datecde").value == "" ||
	   document.getElementById("facture").value == "")
       { alert("Un des champs n'est pas rempli !"); 
         return false; 
       }
  else
    return true;
  }
  function Chargement()
  {
      var obj = document.getElementById("id_erreur");
      if (obj.value!='')
         alert('Erreur signalée  : "'+obj.value+"'");
  }
	
  </script>
  <body  onLoad="Chargement();">
<section id="main" class="column">
	<article class="module width_full">

		<form method="post" action="Controleur" onsubmit="return verif();">
			<input type="hidden" name="type" value="ajout" id="type" /> <input
				type="hidden" name="uneErreur" value="${MesErreurs}" id="id_erreur">
			<input type="hidden" name="action" value="sauverCommande" /><br>
			<br>
			<header>
				<h3>Nouvelle commande</h3>
			</header>
			<div class="module_content">
				

				<fieldset>
					<label>Date de commande</label>
					<input type="text" name="datecde" value="" id="datepicker" READONLY/>
				</fieldset>
				<fieldset>
					<label>Facture</label>
					<input type="text" name="facture" value="" id="facture" />
				</fieldset>
				
				<fieldset style="width: 48%; float: left; margin-right: 3%;">
					<label>Numéro Client</label> <select name="noclient" id="noClient"
						style="width: 92%;">
						<c:forEach items="${mesnumclients}" var="item">
							<option value='<c:out value="${item}"/>'>
								<c:out value="${item}" />
							</option>
						</c:forEach>
					</select>
				</fieldset>

			<fieldset style="width: 48%; float: left; margin-right: 3%;">
					<label>Numéro Vendeur</label> <select name="novendeur" id="noVendeur"
						style="width: 92%;">
						<c:forEach items="${mesnumvendeurs}" var="item">
								<option value='<c:out value="${item}"/>'>
									<c:out value="${item}" />
								</option>
							</c:forEach>
					</select>
				</fieldset>
	 	</div>
			
			<div class="clear"></div>
		<div class="submit_link">
		
			<input type="submit"  value="Ajouter" class="alt_btn">
			
		</div>
	
	</form>
	</article>
	</section>
</body>
</html>