package iso3.pt.action;

import java.util.Set;

import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Evaluacion;
import iso3.pt.service.PtDaoService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class MarkingAction extends ActionSupport implements Preparable
{

	private int idAsignatura;
	private int dniAlumno;
	private Asignatura asignatura;
	private Alumno alumno;
	private int hiddenIdAsignatura;
	private int hiddenDniAlumno;
	private String concepto;
	private String nota;
	private Set<Evaluacion> evaluaciones;
	

	
	public Set<Evaluacion> getEvaluaciones() 
	{
		return evaluaciones;
	}

	public void setEvaluaciones(Set<Evaluacion> evaluaciones) 
	{
		this.evaluaciones = evaluaciones;
	}

	public String getConcepto() 
	{
		return concepto;
	}

	public void setConcepto(String concepto) 
	{
		this.concepto = concepto;
	}

	public String getNota() 
	{
		return nota;
	}

	public void setNota(String nota) 
	{
		this.nota = nota;
	}

	public int getHiddenIdAsignatura() 
	{
		return hiddenIdAsignatura;
	}

	public void setHiddenIdAsignatura(int hiddenIdAsignatura) 
	{
		this.hiddenIdAsignatura = hiddenIdAsignatura;
	}

	public int getHiddenDniAlumno() 
	{
		return hiddenDniAlumno;
	}

	public void setHiddenDniAlumno(int hiddenDniAlumno) 
	{
		this.hiddenDniAlumno = hiddenDniAlumno;
	}

	public Asignatura getAsignatura() 
	{
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) 
	{
		this.asignatura = asignatura;
	}

	public Alumno getAlumno() 
	{
		return alumno;
	}

	public void setAlumno(Alumno alumno) 
	{
		this.alumno = alumno;
	}

	public int getIdAsignatura() 
	{
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) 
	{
		this.idAsignatura = idAsignatura;
	}

	public int getDniAlumno() 
	{
		return dniAlumno;
	}

	public void setDniAlumno(int dniAlumno) 
	{
		this.dniAlumno = dniAlumno;
	}



	public String prepCalificar()
	{		
		PtDaoService dao =  new PtDaoService();
		dao.addEvaluacion(concepto, Float.valueOf(nota).floatValue(), idAsignatura, dniAlumno);
		evaluaciones = dao.getEvaluaciones(idAsignatura, dniAlumno);
		return "calificado";
	}

	@Override
	public void prepare() throws Exception 
	{
		PtDaoService dao =  new PtDaoService();
		this.dniAlumno=this.hiddenDniAlumno;
		this.idAsignatura=this.hiddenIdAsignatura;
		asignatura = dao.getAsignatura(this.idAsignatura);
		alumno = dao.getAlumno(this.dniAlumno);
	}
}
