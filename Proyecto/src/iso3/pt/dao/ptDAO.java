package iso3.pt.dao;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Evaluacion;
import iso3.pt.model.Profesor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ptDAO implements IptDAO 
{
	private Map<Integer, Asignatura> asignaturas = null;
	private static ptDAO instancia = null;
	private SessionFactory sessionFactory = null;

	//********************************************************************************//
	//********************************************************************************//
	//********************************************************************************//

	private ptDAO()
	{
		sessionFactory = new Configuration().configure().buildSessionFactory();
		cargarCache();
	}
    
    public static ptDAO getInstancia()
    {
            if(instancia == null)
            {
                    instancia = ptDAOInstancia();
            }
            return instancia;
    }
    
    private static ptDAO ptDAOInstancia() 
    {
    		return new ptDAO();
    }
	
	
	private void  cargarCache()
	{
		List<Asignatura> asig = obtenerAsignaturas(); 
		
		asignaturas = new HashMap<Integer, Asignatura>();
		for(Asignatura a:asig)
		{
			asignaturas.put(a.getId(), a);
		}
	}
	
	@SuppressWarnings("unchecked")
	private List<Asignatura> obtenerAsignaturas()
	{
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
		List<Asignatura> listAsig = session.createQuery("from Asignatura").list();
   
        tx.commit();
        session.close();
        return listAsig;
	}

	public void close()
	{
        sessionFactory.close();
	}
	
	public Map<Integer, Asignatura> getCache()
	{
		return this.asignaturas;
	}

	
	
	//********************************************************************************//
	//********************************************************************************//
	//********************************************************************************//
	
	@Override
	public Profesor getProfesor(int idAsignatura) 
	{
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        Integer idProfesor = asignaturas.get(idAsignatura).getProfesor().getId();
        
        Profesor profesor = (Profesor) session.get(Profesor.class, idProfesor);
        
        tx.commit();
        session.close();
		return profesor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Evaluacion> getEvaluaciones(int idAsignatura, int idAlumno) 
	{
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Set<Evaluacion> evaluaciones = new HashSet<Evaluacion>();
        
        Alumno alumno = (Alumno) session.createQuery("from Alumno where alum_dni = " + idAlumno).uniqueResult();
        Set<Evaluacion> evs = alumno.getEvaluaciones();
        
        for(Evaluacion ev:evs)
        {
        	if(ev.getAsignatura().getId().equals(idAsignatura))
        		evaluaciones.add(ev);
        }
        
        tx.commit();
        session.close();
		return evaluaciones;
	}
	
}

