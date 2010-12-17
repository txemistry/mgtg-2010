package iso3.pt.action;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.service.PtDaoService;

import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport 
{
	private Set<Asignatura> asignaturas;
	private Set<Asignatura> asignaturasTotales;
	private int idAsignaturaSeleccionada;
	
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
		return null;
	}
	
	public String desmatricular()
	{
		return null;
	}
	
	public String verNotas()
	{
		return null;
	}
}
