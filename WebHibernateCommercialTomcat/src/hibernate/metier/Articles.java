package hibernate.metier;

// Generated 12 avr. 2013 15:49:55 by Hibernate Tools 4.0.0

import gestiondeserreurs.ServiceHibernateException;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import service.ServiceHibernate;

/**
 * Articles generated by hbm2java
 */
public class Articles implements java.io.Serializable {

	private String noArticle;
	private String libArticle;
	private BigDecimal qteDispo;
	private String villeArt;
	private BigDecimal prixArt;
	private char interrompu;
	private Set composesForNoComposant = new HashSet(0);
	private Set composesForNoCompose = new HashSet(0);
	private Set detailCdes = new HashSet(0);

	public Articles() {
	}

	public Articles(String noArticle, String libArticle, BigDecimal qteDispo,
			String villeArt, BigDecimal prixArt, char interrompu) {
		this.noArticle = noArticle;
		this.libArticle = libArticle;
		this.qteDispo = qteDispo;
		this.villeArt = villeArt;
		this.prixArt = prixArt;
		this.interrompu = interrompu;
	}

	public Articles(String noArticle, String libArticle, BigDecimal qteDispo,
			String villeArt, BigDecimal prixArt, char interrompu,
			Set composesForNoComposant, Set composesForNoCompose, Set detailCdes) {
		this.noArticle = noArticle;
		this.libArticle = libArticle;
		this.qteDispo = qteDispo;
		this.villeArt = villeArt;
		this.prixArt = prixArt;
		this.interrompu = interrompu;
		this.composesForNoComposant = composesForNoComposant;
		this.composesForNoCompose = composesForNoCompose;
		this.detailCdes = detailCdes;
	}

	public String getNoArticle() {
		return this.noArticle;
	}

	public void setNoArticle(String noArticle) {
		this.noArticle = noArticle;
	}

	public String getLibArticle() {
		return this.libArticle;
	}

	public void setLibArticle(String libArticle) {
		this.libArticle = libArticle;
	}

	public BigDecimal getQteDispo() {
		return this.qteDispo;
	}

	public void setQteDispo(BigDecimal qteDispo) {
		this.qteDispo = qteDispo;
	}

	public String getVilleArt() {
		return this.villeArt;
	}

	public void setVilleArt(String villeArt) {
		this.villeArt = villeArt;
	}

	public BigDecimal getPrixArt() {
		return this.prixArt;
	}

	public void setPrixArt(BigDecimal prixArt) {
		this.prixArt = prixArt;
	}

	public char getInterrompu() {
		return this.interrompu;
	}

	public void setInterrompu(char interrompu) {
		this.interrompu = interrompu;
	}

	public Set getComposesForNoComposant() {
		return this.composesForNoComposant;
	}

	public void setComposesForNoComposant(Set composesForNoComposant) {
		this.composesForNoComposant = composesForNoComposant;
	}

	public Set getComposesForNoCompose() {
		return this.composesForNoCompose;
	}

	public void setComposesForNoCompose(Set composesForNoCompose) {
		this.composesForNoCompose = composesForNoCompose;
	}

	public Set getDetailCdes() {
		return this.detailCdes;
	}

	public void setDetailCdes(Set detailCdes) {
		this.detailCdes = detailCdes;
	}

//  ***************************************
    //  On r�cup�re tous les num�ros des articles compos�s
    //  ***************************************
	public List<String> getTouslesnumerosComposes() {
		
		 List<String>  mesNumeros=null;
         try
       {       	         	
         Session	session = ServiceHibernate.currentSession();    
         //On passe une requ�te SQL  en utilisant les noms des fichiers hbm
         String marequete ="SELECT DISTINCT c.id.noCompose ";
         marequete= marequete + " FROM Compose as c";
         Query query =   session.createQuery(marequete);
         mesNumeros =  query.list();  
       }
         catch (HibernateException ex) {   
          	 throw new ServiceHibernateException("Impossible d'acc�der � la SessionFactory: " 
                       + ex.getMessage(), ex); 
          }
       return mesNumeros;
		
	}

	public List<Compose> getTouslesComposes(String num) {
		
		 List<Compose>  mesComposes=null;
         try
       {       	         	
         Session	session = ServiceHibernate.currentSession();    
         //On passe une requ�te SQL  en utilisant les noms des fichiers hbm
         String marequete ="SELECT c ";
         marequete= marequete + " FROM Compose as c ";
         marequete= marequete + " WHERE c.id.noCompose = " +num;
         Query query =   session.createQuery(marequete);
         mesComposes =  query.list();  
       }
         catch (HibernateException ex) {   
          	 throw new ServiceHibernateException("Impossible d'acc�der � la SessionFactory: " 
                       + ex.getMessage(), ex); 
          }
       return mesComposes;
	}

}
