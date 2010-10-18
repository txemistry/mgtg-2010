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
	private Session session = null;

	//********************************************************************************//
	//********************************************************************************//
	//********************************************************************************//

	private ptDAO()
	{
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
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
	
	@Override
	public Set<Evaluacion> getEvaluacionesOrderedByAsignatura(int idAlumno) 
	{
	
        Transaction tx = session.beginTransaction();
        List <Evaluacion> listEvaluaciones = session.createQuery("from Evaluacion where alum_dni = :idAlumno order by asig_id desc").setParameter("idAlumno", idAlumno).list();

        tx.commit();
        
        return new HashSet<Evaluacion>(listEvaluaciones);

	}

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
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
		/*DEBERIA SER ASI
		
		return asignaturas.get(id);
		
		 */
		return null;
	}

	@Override
	public Alumno loginAlumno(int dni, String pass) throws UserNotFoundException, IncorrectPasswordException 
	{
		/*DEBERIA SER ASI
		
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
		
		Alumno alumno = (Alumno) session.get(Alumno.class,id);
		
		if(alumno == null)
		{
			throws new UserNotFoundException("UserNotFoundException: el usuario no se encontró");
		}
		else
		{
			if(alumno.getPassword.equals(pass))
			{
				return alumno
			}
			else
			{
				throws new IncorrectPasswordException("IncorrectPasswordException: contraseña incorrecta");
			}
		}
			
		tx.commit();
        session.close();
		
		 */

		return null;
	}

	@Override
	public Set<Asignatura> getAsignaturas(int idAlumno) 
	{
		/*DEBERIA SER ASI
		
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
		
		Alumno alumno = (Alumno) session.get(Alumno.class,idAlumno);
		
		Set<Asignatura> asigs = new HashSet<Asignatura>();
		asigs = alumno.getAsignaturas();
			
		tx.commit();
        session.close();
		return asigs;
		 */
		
		return null;
	}

	@Override
	public void matricular(int idAlumno, int idAsignatura) 
	{
		/*DEBERIA SER ASI
		
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
		Asignatura asignatura = asignaturas.get(idAsignatura);		
		Alumno alumno = (Alumno) session.get(Alumno.class, idAlumno);
		
		asignatura.addAlumno(alumno);
		alumno.addAsignatura(asignatura);
		
		session.flush();
		tx.commit();
        session.close();
		
		 */
		
	}

	@Override
	public void desmatricular(int idAlumno, int idAsignatura) 
	{
		/*DEBERIA SER ASI
		
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
		Asignatura asignatura = asignaturas.get(idAsignatura);		
		Alumno alumno = (Alumno) session.get(Alumno.class, idAlumno);
		
		asignatura.removeAlumno(alumno);
		alumno.removeAsignatura(asignatura);
		
		session.flush();
		tx.commit();
        session.close();
		
		 */
	}

	@Override
	public Profesor loginProfesor(int dni, String pass) throws UserNotFoundException, IncorrectPasswordException 
	{
		/*DEBERIA SER ASI
		
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
		
		Profesor profesor = (Profesor) session.createQuery("from Profesor where prof_dni = :dni).setString("dni",dni).uniqueResult();
		
		
		if(profesor == null)
		{
			throws new UserNotFoundException("UserNotFoundException: el profesor no se encontró");
		}
		else
		{
			if(profesor.getPassword.equals(pass))
			{
				return profesor;
			}
			else
			{
				throws new IncorrectPasswordException("IncorrectPasswordException: contraseña incorrecta");
			}
		}
			
		tx.commit();
        session.close();
		
		 */
		return null;
	}

	@Override
	public Set<Asignatura> getAsignaturasProfesor(int idProfesor) 
	{
		/*DEBERIA SER ASI
		
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
		
		 */
		return null;
	}

	@Override
	public Profesor getProfesorByDni(int dni) throws UserNotFoundException 
	{
		/*DEBERIA SER ASI
		
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
		
		Profesor profesor = (Profesor) session.createQuery("from Profesor where prof_dni = :dni).setString("dni",dni).uniqueResult();
		
		
		if(profesor == null)
		{
			throws new UserNotFoundException("UserNotFoundException: el profesor no se encontró");
		}
		
			
		tx.commit();
        session.close();
		return profesor;
		 */
		
		return null;
	}

	@Override
	public List<Evaluacion> getEvaluacionesAsignatura(int idAsignatura) 
	{
		/*DEBERIA SER ASI
		 
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        List<Evaluacion> evaluaciones = session.createQuery("from evaluacion where asig_id = :idAsignatura).setString("idAsignatura",idAsignatura).list();
		
		tx.commit();
        session.close();
		return evaluaciones;
		 
		 */
		return null;
	}
	
}

