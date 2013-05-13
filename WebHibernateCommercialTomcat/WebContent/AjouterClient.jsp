<jsp:include page="includes/header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language=javascript>
  function verif()
  {
  if(document.getElementById("id").value == "" || 
     document.getElementById("prenom").value == "" || 
     document.getElementById("nom").value == "" ||
     document.getElementById("societe").value == "" ||
     document.getElementById("ville").value == "" ||
     document.getElementById("codePostal").value == "" ||
	   document.getElementById("adresse").value == "")
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
<section id="main" class="column"> <article
		class="module width_full">
  <form method="post" action="Controleur" onsubmit="return verif();">
  <input type ="hidden" name="uneErreur"  value="${MesErreurs}"  id ="id_erreur" >
  <input type="hidden" name="action" value="sauverClient" />
  <br>
		<br> 
		<header>
			<h3>Nouveau client</h3>
		</header>
		<div class="module_content">
    
    <fieldset>
      <label>Prenom client</label>
  		<input type="text" name="prenom" value="" id="prenom"/>
    </fieldset>
     
     <fieldset>
      <label>Nom client</label>
  		<input type="text" name="nom" value="" id="nom"/>
    </fieldset>
    
    <fieldset>
      <label>Societe</label>
  		<input type="text" name="societe" value="" id="societe"/>
    </fieldset>
    
    <fieldset>
      <label>Adresse</label>
  		<input type="text" name="adresse" value="" id="adresse"/>
    </fieldset>
    
    <fieldset>
      <label>Code postal</label>
  		<input type="text" name="codePostal" value="" id="codePostal"/>
    </fieldset>
    
    <fieldset>
      <label>Ville</label>
  		<input type="text" name="ville" value="" id="ville"/>
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