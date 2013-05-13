package gestiondeserreurs;

public class ServiceHibernateException extends RuntimeException 
{
    // --------------------------------
    public ServiceHibernateException() 
    {    super(); }
    // --------------------------------
    public ServiceHibernateException(String message) 
    {    super(message); }
    // --------------------------------
    public ServiceHibernateException(Throwable cause) 
    {    super(cause); }
    // --------------------------------
    public ServiceHibernateException(String message, Throwable cause) 
    {    super(message, cause); }
    // --------------------------------
}
