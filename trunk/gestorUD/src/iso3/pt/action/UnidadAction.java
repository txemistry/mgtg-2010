package iso3.pt.action;

import iso3.pt.model.Asignatura;
import iso3.pt.model.Unidad;
import iso3.pt.service.PtDaoService;
import iso3.pt.service.PtService;

import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UnidadAction extends ActionSupport 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAsignatura;
	private Set<Unidad> unidades;
	private Asignatura asignatura;
	
	
	
	
	
	public Asignatura getAsignatura() 
	{
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) 
	{
		this.asignatura = asignatura;
	}

	public Set<Unidad> getUnidades() 
	{
		return unidades;
	}

	public void setUnidades(Set<Unidad> unidades) 
	{
		this.unidades = unidades;
	}

	public int getIdAsignatura() 
	{
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) 
	{
		this.idAsignatura = idAsignatura;
	}

	public String obtenerListaUnidades()
	{
		PtService dao = new PtDaoService();
		unidades = dao.getUnidades(idAsignatura);
		asignatura =  dao.getAsignatura(idAsignatura);
		String role = (String) ActionContext.getContext().getSession().get("role");
		
		if (role.equals("profesor"))
			return "listadoUnidadesLT";
		else
			return "listadoUnidadesST";

	}
	
	

}
