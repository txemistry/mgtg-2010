package iso3.pt.dao;

import iso3.pt.dao.excepciones.IncorrectPasswordException;
import iso3.pt.dao.excepciones.UserNotFoundException;
import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Evaluacion;
import iso3.pt.model.Profesor;
import iso3.pt.model.Unidad;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PtDAO implements IptDAO 
{
	private Map<Integer, Asignatura> asignaturas = null;
	private static PtDAO instancia = null;
	private SessionFactory sessionFactory = null;
	private Session session = null;

	//********************************************************************************//
	//********************************************************************************//
	//********************************************************************************//

	private PtDAO()
	{
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		cargarCache();
	}
    
    public static PtDAO getInstance()
    {
            if(instancia == null)
            {
                    instancia = ptDAOInstancia();
            }
            return instancia;
    }
    
    private static PtDAO ptDAOInstancia() 
    {
    		return new PtDAO();
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
        Transaction tx = session.beginTransaction();
        
		List<Asignatura> listAsig = session.createQuery("from Asignatura").list();
   
        tx.commit();
        return listAsig;
	}

	public void close()
	{
		session.close();
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
		Profesor profesor = asignaturas.get(idAsignatura).getProfesor();
		return profesor;
	}
	
	@Override
	public Set<Alumno> getAlumnos(int idAsignatura) 
	{
		return asignaturas.get(idAsignatura).getAlumnos(); 
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Evaluacion> getEvaluacionesOrderedByAsignatura(int idAlumno) 
	{
	
        Transaction tx = session.beginTransaction();
        List <Evaluacion> listEvaluaciones = session.createQuery("from Evaluacion where alum_dni = :idAlumno order by asig_id asc").setParameter("idAlumno", idAlumno).list();

        tx.commit();
        
        return listEvaluaciones;

	}

	@Override
	public Set<Evaluacion> getEvaluaciones(int idAsignatura, int idAlumno) 
	{
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
		return evaluaciones;
	}




	@Override
	public void addEvaluacion(String concepto, float nota, int idAsignatura, int idAlumno) 
	{

        Transaction tx = session.beginTransaction();
        
		Evaluacion evaluacion = new Evaluacion(concepto, nota);
		Asignatura asignatura = asignaturas.get(idAsignatura);
		evaluacion.setAsignatura(asignatura);
		
		Alumno alumno =(Alumno) session.createQuery("from Alumno where alum_dni = :idAlumno").setParameter("idAlumno", idAlumno).uniqueResult();
		evaluacion.setAlumno(alumno);
		
		alumno.addEvaluacion(evaluacion);
		
		session.flush();
		tx.commit();
	}

	@Override
	public Set<Unidad> getUnidades(int idAsignatura) 
	{
		return asignaturas.get(idAsignatura).getUnidades();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Set<Asignatura> getAsignaturas() 
	{
		Set<Asignatura> asigs = new HashSet<Asignatura>();
		Iterator it = asignaturas.entrySet().iterator();
		while(it.hasNext()) 
		{
			Map.Entry ent = (Map.Entry)it.next();
			Asignatura asig = (Asignatura)ent.getValue();
			asigs.add(asig);
		}
		return asigs;
	}

	@Override
	public Alumno getAlumno(int id) 
	{
        Transaction tx = session.beginTransaction();
        
		
		Alumno alumno = (Alumno) session.get(Alumno.class,id);
			
		tx.commit();
        
		return alumno;
	}

	@Override
	public Asignatura getAsignatura(int id) 
	{
		return asignaturas.get(id);
	}

	@Override
	public Alumno loginAlumno(int dni, String pass) throws UserNotFoundException, IncorrectPasswordException 
	{
        Transaction tx = session.beginTransaction();
        
		Alumno alumno = (Alumno) session.get(Alumno.class,dni);
		tx.commit();
		
		
		if(alumno == null)
		{
			throw new UserNotFoundException("UserNotFoundException");
		}
		else
		{
			if(alumno.getPassword().equals(pass))
			{
				return alumno;
			}
			else
			{
				throw new IncorrectPasswordException("IncorrectPasswordException");
			}
		}
			
		
	}

	@Override
	public Set<Asignatura> getAsignaturas(int idAlumno) 
	{
        Transaction tx = session.beginTransaction();
        
		
		Alumno alumno = (Alumno) session.get(Alumno.class,idAlumno);
		
		Set<Asignatura> asigs = new HashSet<Asignatura>();
		asigs = alumno.getAsignaturas();
			
		tx.commit();
		return asigs;

	}

	@Override
	public void matricular(int idAlumno, int idAsignatura) 
	{
        Transaction tx = session.beginTransaction();
        
		Asignatura asignatura = asignaturas.get(idAsignatura);		
		Alumno alumno = (Alumno) session.get(Alumno.class, idAlumno);
		
		asignatura.addAlumno(alumno);
		alumno.addAsignatura(asignatura);
		
		session.flush();
		tx.commit();
	
	}

	@Override
	public void desmatricular(int idAlumno, int idAsignatura) 
	{
        Transaction tx = session.beginTransaction();
        
		Asignatura asignatura = asignaturas.get(idAsignatura);		
		Alumno alumno = (Alumno) session.get(Alumno.class, idAlumno);
		
		asignatura.removeAlumno(alumno);
		alumno.removeAsignatura(asignatura);
		
		session.flush();
		tx.commit();
	}

	@Override
	public Profesor loginProfesor(int dni, String pass) throws UserNotFoundException, IncorrectPasswordException 
	{

        Transaction tx = session.beginTransaction();
        
		Profesor profesor = (Profesor) session.createQuery("from Profesor where prof_dni = :dni").setParameter("dni",dni).uniqueResult();
		tx.commit();
		
		if(profesor == null)
		{
			throw new UserNotFoundException("UserNotFoundException: el profesor no se encontr�");
		}
		else
		{
			if(profesor.getPassword().equals(pass))
			{
				return profesor;
			}
			else
			{
				throw new IncorrectPasswordException("IncorrectPasswordException: contrase�a incorrecta");
			}
		}
			
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Set<Asignatura> getAsignaturasProfesor(int idProfesor) 
	{
		Set<Asignatura> asigs = new HashSet<Asignatura>();
		
		Iterator it = asignaturas.entrySet().iterator();
		while(it.hasNext()) 
		{
			Map.Entry ent = (Map.Entry)it.next();
			Asignatura asig = (Asignatura)ent.getValue();
			
			if(asig.getProfesor().getId().equals(idProfesor))
				asigs.add(asig);
		}
		
		return asigs;
	}

	@Override
	public Profesor getProfesorByDni(int dni) throws UserNotFoundException 
	{
        Transaction tx = session.beginTransaction();
        
		Profesor profesor = (Profesor) session.createQuery("from Profesor where prof_dni = :dni").setParameter("dni",dni).uniqueResult();
		
		
		if(profesor == null)
		{
			throw new UserNotFoundException("UserNotFoundException: el profesor no se encontr�");
		}
		
			
		tx.commit();
		
		return profesor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evaluacion> getEvaluacionesAsignatura(int idAsignatura) 
	{ 
		        
        Transaction tx = session.beginTransaction();
        
        List <Evaluacion> listEvaluaciones = session.createQuery("from Evaluacion where asig_id = :idAsignatura").setParameter("idAsignatura",idAsignatura).list();
        tx.commit();
        
        return listEvaluaciones;

	}
	
}

