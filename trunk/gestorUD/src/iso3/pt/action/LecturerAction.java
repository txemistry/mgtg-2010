package iso3.pt.action;

import java.util.Set;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.service.PtDaoService;
import iso3.pt.service.PtService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LecturerAction extends ActionSupport 
{
	private Integer asignatura;
	private Set<Alumno> alumnos;
	private Set<Asignatura> asignaturas;
	
	

	public int getAsignatura() 
	{
		return asignatura;
	}

	public void setAsignatura(int asignatura) 
	{
		this.asignatura = asignatura;
	}

	public Set<Alumno> getAlumnos() 
	{
		return alumnos;
	}

	public void setAlumnos(Set<Alumno> alumnos) 
	{
		this.alumnos = alumnos;
	}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) 
	{
		this.asignaturas = asignaturas;
	}

	public String verEstudiantes()
	{
		PtDaoService dao = new PtDaoService();
		alumnos = dao.getAlumnos(asignatura);
		return "estudiantesCargados";
	}
	
	public String anyadirNota()
	{
		return null;
		
	}
	
	public String obtenerListaAsignaturas()
	{
		PtDaoService dao = new PtDaoService();
		int id = (Integer)ActionContext.getContext().getSession().get("id");
		this.asignaturas = (Set<Asignatura>) dao.getAsignaturasProfesor(id);
		return "volverAAsignaturasProfesor";
	}

}
