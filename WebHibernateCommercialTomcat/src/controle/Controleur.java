package controle;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hibernate.metier.*;
import gestiondeserreurs.ServiceHibernateException;

/**
 * Servlet implementation class controleur
 */
@WebServlet("/Controleur")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
     private   Commandes  unecommande;
    
	 private static final String ACTION_TYPE = "action";
	 private static final String VOIR_LISTE_COMMANDES  = "voirlescommandes";
	 private static final String AJOUTER_COMMANDE = "ajouterCommande";
	 private static final String AJOUTER_CLIENT = "ajoutClient";
	 private static final String SAUVER_CLIENT  =  "sauverClient";
	 private static final String AJOUTER_VENDEUR = "ajouterVendeur";
	 private static final String SAUVER_VENDEUR  =  "sauverVendeur";
	 private static final String SAUVER_COMMANDE  =  "sauverCommande";
	 private static final String MODIFIER_COMMANDE = "modifierCommande";
	 private static final String FACTURE_COMMANDE = "factureCommande"; 
	 private static final String CHOIX_COMMANDE = "choixcommande";
	 private static final String EFFACER_COMMANDE  = "effacerCommande";
	 
	 
	 private static final String AFFICHER_VENDEUR_CHEF = "vendeurChef";
	 
	 private static final String CHOIX_ARTICLE = "choixArticle";
	 private static final String AFFICHER_ARTICLE = "articleComposant";
	 
	 private static final String ERROR_KEY      = "messageErreur";
	 private static final String ERROR_PAGE     = "/Erreur.jsp";
    
	
    public Controleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		  {
			processusTraiteRequete(request, response);
		  }
		catch( Exception e)
		{
			e.printStackTrace();
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		  {
			processusTraiteRequete(request, response);
		  }
		catch( Exception e)
		{
			e.printStackTrace();
		}


	  }
	
	public  Date conversionChaineenDate(String unedate, String unformat) 
	// le format est une combinaison de MM dd yyyy avec / ou – 
	// exemple  dd/MM/yyyy
	     throws Exception 
	 {
	     Date datesortie;
	   // on définit un format de sortie  
	   SimpleDateFormat defFormat = new SimpleDateFormat(unformat);
	   datesortie = defFormat.parse(unedate);
	   return datesortie;
	}
 protected void processusTraiteRequete(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException, Exception 
  {  
	
	String actionName = request.getParameter(ACTION_TYPE);
      String destinationPage = ERROR_PAGE; 
         // execute l'action
    if( VOIR_LISTE_COMMANDES.equals(actionName))
      {
    	
    	Commandes unecde = new Commandes();
    	
    	try 
          {
    	   request.setAttribute("mescommandes", unecde.getTouteslesCommandes());
    	  destinationPage = "/ListeCommandes.jsp";
    	  
          }
          
         catch (ServiceHibernateException e)
          {
 	        request.setAttribute("MesErreurs", e.getMessage());  
           }    
      }    
    else 
      if(AJOUTER_COMMANDE.equals(actionName))  
      {	 Vendeur unvd = new Vendeur();
         Clientel uncl = new Clientel ();
          // on passe les numéros de client et de vendeur
      try
      {
    	  request.setAttribute("mesnumvendeurs", unvd.getTouslesnumerosVendeurs());
    	  request.setAttribute("mesnumclients", uncl.getTouslesnumerosClients());
    	  unecommande = new Commandes();
    	  request.setAttribute("commande", unecommande);
    	  destinationPage = "/AjouterCommande.jsp";
      }
    catch (ServiceHibernateException e)
           {
        	   request.setAttribute("MesErreurs", e.getMessage());  
           }         
      }
      else if(MODIFIER_COMMANDE.equals(actionName))
    	{  String  id = request.getParameter("id");
    	  unecommande = new Commandes();
        	  try 
              { 
        	    unecommande = unecommande.getUneCommande(id);
        	    DateFormat dateFormatpers = new SimpleDateFormat("yyyy-MM-dd");          
        	    request.setAttribute("idcde",unecommande.getNoCommand());
        	    request.setAttribute("noClient",unecommande.getClientel().getNoClient());
        	    request.setAttribute("noVendeur",unecommande.getVendeur().getNoVendeur());
        	    // on lance la conversion de date en chaine 
                request.setAttribute("dateCde", dateFormatpers.format(unecommande.getDateCde()));
        	    request.setAttribute("facture",unecommande.getFacture());
        	    destinationPage = "/ModifierCommande.jsp";
        	  }
        	  catch (ServiceHibernateException ex)
              {
           	   request.setAttribute("MesErreurs", ex.getMessage());  
              } 
              
          }            
      else 
    	  if(SAUVER_COMMANDE.equals(actionName))
             {   //fabrication de la commande à partir des paramètres de la requête
          // Si la commande n'est pas à créer, il faut la récupérer de la session courante
    	  // Ensuite on peut modifier ses champs
    		 
    	  if (request.getParameter("type").equals("modif"))         
    	  {  // on récupère la commande courante 
    		  // instanciée au moment de l'appel de la page
    		  Clientel unc = new Clientel();
              String num = request.getParameter("noclient");
              Clientel unc2 = unc.getUnClient(num);
              unecommande.setClientel(unc2);
        	
        	// on récupère l'ojet Vendeur correspondant au numéro Client 
              Vendeur unv = new Vendeur ();
              num= request.getParameter("novendeur");
             Vendeur  unv2= unv.getUnVendeur(num);
             unecommande.setVendeur(unv2);
             unecommande.setFacture(request.getParameter("facture").charAt(0));
             unecommande.setDateCde(conversionChaineenDate(request.getParameter("datecde"),"yyyy-MM-dd"));
    		      
    	  }
    	  else
    	  {	  
        	  unecommande = new Commandes();
        	  unecommande.setNoCommand("0");
    	  }
    	 // on récupère l'ojet Client correspondant au numéro Client 
          Clientel unc = new Clientel();
          String num = request.getParameter("noclient");
          Clientel unc2 = unc.getUnClient(num);
          unecommande.setClientel(unc2);
    	 // unecommande.setNoClient(unc);
    	// on récupère l'ojet Vendeur correspondant au numéro Client 
          Vendeur unv = new Vendeur ();
          num= request.getParameter("novendeur");
         Vendeur  unv2= unv.getUnVendeur(num);
         unecommande.setVendeur(unv2);
         unecommande.setFacture(request.getParameter("facture").charAt(0));
          try 
          {
            unecommande.setDateCde(conversionChaineenDate(request.getParameter("datecde"),"yyyy-MM-dd"));
           
             //sauvegarde de la commande       
            if(request.getParameter("type").equals("modif"))
              { destinationPage = "/Controleur?action=voirlescommandes";
            	unecommande.modifier(unecommande);
            	request.setAttribute("mescommandes", unecommande.getTouteslesCommandes());         
            	
               }
             else	
            	  if(request.getParameter("type").equals("ajout"))
                  {    	 destinationPage = "/index.jsp";	 
            		  unecommande.ajouter(unecommande); 
            		  request.setAttribute("mescommandes",unecommande.getTouteslesCommandes());        
            	      
                   }
           
          }
          catch (ServiceHibernateException e)
          {
       	   request.setAttribute("MesErreurs", e.getMessage());  
          }
          catch ( Exception e)
          {
        	  request.setAttribute("MesErreurs",e.getMessage());
          }   
          
        
      }  
    
      else if(EFFACER_COMMANDE.equals(actionName))
      {
          //recuperation de la liste des id a effacer
          String[] ids = request.getParameterValues("id");
          //effacement de la liste des id
          unecommande = new Commandes();
          if(ids != null)
            {   unecommande.effacer(ids); }
          //preparation de la liste
          request.setAttribute("mescommandes", unecommande.getTouteslesCommandes());
           destinationPage = "/Controleur?action=voirlescommandes";
      } 
      else if(AJOUTER_CLIENT.equals(actionName))
      {
          
           destinationPage = "/AjouterClient.jsp";
      } 
      else if(AJOUTER_VENDEUR.equals(actionName))
      {
    	  Vendeur v = new Vendeur();
         request.setAttribute("chefs", v.getTouslesnumerosVendeurs());
         
           destinationPage = "/AjouterVendeur.jsp";
      } 
      else if(SAUVER_CLIENT.equals(actionName))
      {
          
          Clientel c = new Clientel();
          //String numero = request.getParameter("id");
          
          String prenom = request.getParameter("prenom");
          String nom = request.getParameter("nom");
          String societe = request.getParameter("societe");
          String adresse = request.getParameter("adresse");
          String cp = request.getParameter("codePostal");
          String ville = request.getParameter("ville");
          
          c.setNoClient("0");
          c.setPrenomCl(prenom);
          c.setNomCl(nom);
          c.setSociete(societe);
          c.setAdresseCl(adresse);
          c.setCodePostCl(cp);
          c.setVilleCl(ville);
          
          c.ajouter(c);
          destinationPage="/index.jsp";
          
      } else if(SAUVER_VENDEUR.equals(actionName))
      {
          
          Vendeur v = new Vendeur();
          String numero = request.getParameter("id");
          String prenom = request.getParameter("prenom");
          String nom = request.getParameter("nom");
          String date = request.getParameter("dateV");
          String iDchef = request.getParameter("idChef");
          BigDecimal commission = BigDecimal.valueOf(Double.valueOf(request.getParameter("commission")));
          String ville = request.getParameter("ville");
          BigDecimal salaire = BigDecimal.valueOf(Double.valueOf(request.getParameter("salaire")));
          System.out.println("idChef"+iDchef);
          Vendeur chef  = v.getUnVendeur(iDchef);
          v.setNoVendeur("0");
          v.setPrenomVend(prenom);
          v.setNomVend(nom);
          v.setVendeur(chef);
          v.setSalaireVend(salaire);
          v.setDateEmbau(conversionChaineenDate(date,"yyyy-MM-dd"));
          v.setVilleVend(ville);
          v.setCommission(commission);
          
          v.ajouter(v);
          destinationPage="/index.jsp";
          
      } 
      else if (CHOIX_COMMANDE.equals(actionName)) {
    	  Commandes unecommande = new Commandes();
    	  request.setAttribute("idsCommande",unecommande.getTouslesnumerosCommandesFacture());
    	  destinationPage ="/choixCommande.jsp";
      }
      else if ((FACTURE_COMMANDE).equals(actionName)){
    	  String num = request.getParameter("nocommand");
    	  Commandes unecom = new Commandes();
    	  
    	  List<DetailCde> c = unecom.getFactureCommande(num);
    	  
    	
    	 request.setAttribute("detailCde", c);
    	 request.setAttribute("numero", num);
    	 destinationPage ="/factureCommande.jsp";
    	 System.out.println("je suis passé 2");
      }
      
      else if ((AFFICHER_VENDEUR_CHEF.equals(actionName))){
    	
    	 Vendeur v = new Vendeur();
      	List<String> uneListe = v.getTouslesChefVendeurs();
      
      	
      	request.setAttribute("mesvendeurs", uneListe);
    
      	 destinationPage = "/ListeVendeursduChef.jsp";
      }
      else if ((CHOIX_ARTICLE.equals(actionName)))
      {
    	  Articles unarticle = new Articles();
    	  List<String> idArticles = unarticle.getTouslesnumerosComposes();
    	  System.out.println(idArticles.get(0));
    	  request.setAttribute("idsArticle",idArticles);
    	  destinationPage = "/ChoixArticle.jsp";
      }
      else if((AFFICHER_ARTICLE.equals(actionName))){
    	  String num = request.getParameter("noarticle");
    	  Articles unarticle = new Articles();
    	  List<Compose> listeCompose = unarticle.getTouslesComposes(num);
    	  
    	  request.setAttribute("listeCompose", listeCompose);
    	  request.setAttribute("numeroArticle",num);
    	  
    	  destinationPage = "/ListeArticleCompose.jsp";
      }
      else
      {   String messageErreur = "[" + actionName + "] n'est pas une action valide.";
          request.setAttribute(ERROR_KEY, messageErreur);
      }
      // Redirection vers la page jsp appropriee
      RequestDispatcher dispatcher =getServletContext().getRequestDispatcher(destinationPage);
      dispatcher.forward(request, response); 
  }
}
