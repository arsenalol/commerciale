<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/header.jsp" />
	<section id="main" class="column">
		<c:if test="${(message == 'ajoutVendeur')}">
		<h4 class="alert_success">Le vendeur a ete ajoute</h4>
		</c:if>
		
		<c:if test="${(message == 'ajoutClient')}">
		<h4 class="alert_success">Le client a ete ajoute</h4>
		</c:if>
		
		<c:if test="${(message == 'ajout')}">
		<h4 class="alert_success">La commande a ete ajoutee</h4>
		</c:if>	
	
		<article class="module width_full">
			<header><h3>Message d'accueil</h3></header>
				<div class="module_content">
					<h1>Bienvenue dans l'application Commerciale de Polytech</h1>
					<p>Utilise le menu a gauche pour ajouter,modifier et consulter des informations sur les clients, les commandes, les articles et les vendeurs.
				</div>
		</article><!-- end of styles article -->
		<div class="spacer"></div>
	</section>
</body>
</html>

