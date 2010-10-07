package iso3.pt.dao;

import iso3.pt.model.Asignatura;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ptDAO implements IptDAO 
{
	private Map<Integer, Asignatura> asignaturas = null;
	private static ptDAO instancia = null;
	private SessionFactory sessionFactory = null;

	
	private ptDAO()
	{
		sessionFactory = new Configuration().configure().buildSessionFactory();
		cargarCache();
	}
    
    //METHOD THAT RETURN AN INSTANCE OF THE FACTORY
    public static ptDAO getInstancia()
    {
            if(instancia == null)
            {
                    instancia = ptDAOInstancia();
            }
            return instancia;
    }
    
    //PRIVATE CONSTRUCTOR THAT IS GOING TO BE USED BY THE GETINSTANCE
    //USERS ARE NEVER GOING TO HAVE ACCESS TO THIS METHOD
    private static ptDAO ptDAOInstancia() 
    {
    		return new ptDAO();
    }
	
	
	
        
	 
	private void  cargarCache()
	{
		List<Asignatura> asig = obtenerAsignaturas(); 
		System.out.println("estoy en la carga y la lista tiene " + asig.size());
		
		asignaturas = new HashMap<Integer, Asignatura>();
		for(Asignatura a:asig)
		{
			asignaturas.put(a.getId(), a);
		}
	}
	
	 
	@SuppressWarnings({"unchecked", "rawtypes"})
	private List<Asignatura> obtenerAsignaturas()
	{
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Asignatura> listAsig = session.createQuery("from Asignatura").list();
   
        
        tx.commit();
        session.close();
        return listAsig;
	}
	
	
	public Map<Integer, Asignatura> getCache()
	{
		return this.asignaturas;
	}
}

