package iso3.pt.action;

import iso3.pt.model.Asignatura;
import iso3.pt.service.PtDaoService;

import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport 
{
	private Set<Asignatura> asignaturas = null;
	
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

	public String matricular()
	{
		return null;
		
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
