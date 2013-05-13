<jsp:include page="includes/header.jsp" />
<script language=javascript>
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
<input type ="hidden" name="uneErreur"  value="${MesErreurs}"  id ="id_erreur" >
  <H1>${MesErreurs}</H1>
</article><!-- end of styles article -->
		<div class="spacer"></div>
	</section>
</body>
</html>

