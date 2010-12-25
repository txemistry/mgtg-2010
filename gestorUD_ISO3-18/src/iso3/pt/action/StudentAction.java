package iso3.pt.action;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Evaluacion;
import iso3.pt.service.PtDaoService;

import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Set<Asignatura> asignaturas;
	private Set<Asignatura> asignaturasTotales;
	private int idAsignaturaSeleccionada;
	private List<Evaluacion> evaluaciones;
	private Set<Evaluacion> evaluacionesSET;
	private Alumno alumno;
	private int idAsignatura;
	private Asignatura asignatura;
	
	public Set<Evaluacion> getEvaluacionesSET() 
	{
		return evaluacionesSET;
	}

	public void setEvaluacionesSET(Set<Evaluacion> evaluacionesSET) 
	{
		this.evaluacionesSET = evaluacionesSET;
	}

	public Asignatura getAsignatura() 
	{
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) 
	{
		this.asignatura = asignatura;
	}

	public int getIdAsignatura() 
	{
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) 
	{
		this.idAsignatura = idAsignatura;
	}

	public Alumno getAlumno() 
	{
		return alumno;
	}

	public void setAlumno(Alumno alumno) 
	{
		this.alumno = alumno;
	}

	public List<Evaluacion> getEvaluaciones() 
	{
		return evaluaciones;
	}

	public void setEvaluaciones(List<Evaluacion> evaluaciones) 
	{
		this.evaluaciones = evaluaciones;
	}

	public int getIdAsignaturaSeleccionada() 
	{
		return idAsignaturaSeleccionada;
	}

	public void setIdAsignaturaSeleccionada(int idAsignaturaSeleccionada) 
	{
		this.idAsignaturaSeleccionada = idAsignaturaSeleccionada;
	}

	public Set<Asignatura> getAsignaturasTotales() 
	{
		return asignaturasTotales;
	}

	public void setAsignaturasTotales(Set<Asignatura> asignaturasTotales) 
	{
		this.asignaturasTotales = asignaturasTotales;
	}
	

	public Set<Asignatura> getAsignaturas() 
	{
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) 
	{
		this.asignaturas = asignaturas;
	}
	
	public String obtenerListaAsignaturas()
	{
		PtDaoService dao = new PtDaoService();
		int dni = (Integer) ActionContext.getContext().getSession().get("dni");
		this.asignaturas = dao.getAsignaturas(dni);
		return "listadoAsignaturas";
	}
	
	public Set<Asignatura> obtenerAsignaturasTotales()
	{
		PtDaoService dao = new PtDaoService();
		return dao.getAsignaturas();
	}

	public String prepMatricular()
	{
		this.asignaturasTotales = obtenerAsignaturasTotales();
		return "listadoAsignaturasMatricular";
		
	}
	
	public String matricular()
	{
		int dniAlumno = (Integer) ActionContext.getContext().getSession().get("dni");
		PtDaoService dao = new PtDaoService();
		Asignatura asignaturaAMatricularse = dao.getAsignatura(idAsignaturaSeleccionada);
		Alumno alumnoAMatricularse = dao.getAlumno(dniAlumno);
		
		if(asignaturaAMatricularse.estaMatriculado(alumnoAMatricularse))
		{
			//El alumno ya esta matriculado
            addActionError(getText("errors.just.enrolled"));
    		this.asignaturasTotales = obtenerAsignaturasTotales();
            return INPUT;

		}
		else
		{
			//el alumno no esta matriculado y se procederá a 
			//su matriculacion
			dao.matricular(dniAlumno, idAsignaturaSeleccionada);
			return "matriculado";
		}
	}
	
	public String mostrarNotas()
	{
		PtDaoService dao =  new PtDaoService();
		int dniAlumno = (Integer) ActionContext.getContext().getSession().get("dni");
		evaluaciones = dao.getEvaluacionesOrderedByAsignatura(dniAlumno);
		alumno = dao.getAlumno(dniAlumno);
		return "listaNotasAlumno";
	}
	
	public String desmatricular()
	{
		PtDaoService dao = new PtDaoService();
		int dniAlumno = (Integer) ActionContext.getContext().getSession().get("dni");
		dao.desmatricular(dniAlumno, idAsignatura);
		return "desmatriculado";
	}
	
	public String verNotas()
	{
		PtDaoService dao =  new PtDaoService();
		int dniAlumno = (Integer) ActionContext.getContext().getSession().get("dni");
		alumno = dao.getAlumno(dniAlumno);
		asignatura = dao.getAsignatura(idAsignatura);
		evaluacionesSET = dao.getEvaluaciones(idAsignatura, dniAlumno);

		return "mostrarNotas";
	}
}
