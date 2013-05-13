<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="includes/header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language=javascript>
	function verif() {
		if (document.getElementById("id").value == ""
				|| document.getElementById("nom").value == ""
				|| document.getElementById("prenom").value == ""
				|| document.getElementById("dateV").value == ""
				|| document.getElementById("salaire").value == ""
				|| document.getElementById("commission").value == ""
				|| document.getElementById("ville").value == "") {
			alert("Un des champs n'est pas rempli !");
			return false;
		} else
			return true;
	}
	function Chargement() {
		var obj = document.getElementById("id_erreur");
		if (obj.value != '')
			alert('Erreur signalée  : "' + obj.value + "'");
	}
</script>
<body  onLoad="Chargement();">
<section id="main" class="column">
	<article class="module width_full">
		<form method="post" action="Controleur" onsubmit="return verif();">
			<input type="hidden" name="uneErreur" value="${MesErreurs}"
				id="id_erreur"> <input type="hidden" name="action"
				value="sauverVendeur" /> <br> <br>
			<header>
				<h3>Nouveau vendeur</h3>
			</header>
			<div class="module_content">
				

				<fieldset>
					<label>Prenom Vendeur</label>
					<input type="text" name="prenom" value="" id="prenom" />
				</fieldset>

				<fieldset>
					<label>Nom Vendeur</label>
					<input type="text" name="nom" value="" id="nom" />
				</fieldset>

				<fieldset>
					<label>Date d'embauche</label>
					<input type="text" name="dateV" value="" id="dateV" />
				</fieldset>

				<fieldset>
					<label>Ville Vendeur</label>
					<input type="text" name="ville" value="" id="ville" />
				</fieldset>

				<fieldset>
					<label>Salaire Vendeur</label>
					<input type="text" name="salaire" value="" id="salaire" />
				</fieldset>

				<fieldset>
					<label>Commission</label>
					<input type="text" name="commission" value=""
						id="commission" />
				</fieldset>
				
				<fieldset style="width: 48%; float: left; margin-right: 3%;">
					<label>Numéro chef_vendeur</label> <select name="idChef"
						id="idChef" style="width: 92%;">
						<c:forEach items="${chefs}" var="item">
							<option value="${item}">${item}</option>
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