package service;
import gestiondeserreurs.ServiceHibernateException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ServiceHibernate  { 

  private static final SessionFactory sessionFactory; 

  static { 
    try { 
   // on lit la configuration du fichier hibernate.cfg.xml
    	System.out.println("je passe");
      sessionFactory = new Configuration().configure().buildSessionFactory(); 
      System.out.println("je suis passé");
    } catch (HibernateException ex) { 
      throw new ServiceHibernateException("Impossible de construire la SessionFactory: " 
            + ex.getMessage(), ex); 
    } 
  } 
  public static final ThreadLocal session = new ThreadLocal();   
  
  public static Session currentSession() throws ServiceHibernateException { 
  Session s=null; 
try 
  {
	 s = (Session) session.get(); 
    // Open a new Session, if this Thread has none yet 
    if (s == null) { 
      s = sessionFactory.openSession(); 
      session.set(s); 
    } 
  }
  catch (HibernateException ex) { 
      throw new ServiceHibernateException("Impossible d'accéder à la SessionFactory: " 
            + ex.getMessage(), ex); 
  } 
  return s;
  } 

  @SuppressWarnings("unchecked")
public static void closeSession() throws ServiceHibernateException { 
try 
   { 
	  Session s = (Session) session.get(); 
    session.set(null); 
    if (s != null) 
      s.close(); 
	  }
    catch (HibernateException ex) { 
        throw new ServiceHibernateException("Impossible de fermer la SessionFactory: " 
              + ex.getMessage(), ex); 
    } 
  } 
}
