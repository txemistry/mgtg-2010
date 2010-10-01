package iso3.pt.model;

public class Evaluacion 
{

	//Esta clase va a tener fos atributos externos
	
	private Integer id;
	private String concepto;
	private float nota;
	private Integer alumno; //Identificador del alumno al qeu pertenece dicha evaluacion
	private Integer asignatura; //Identificador de la asignatura a la que pertenece dicha evaluacion
	
	
	//CONSTRUCTOR VACIO Y CON ARGUMENTOS
	protected Evaluacion()
	{}


	public Evaluacion(Integer id, String concepto, float nota) 
	{
		this.id = id;
		this.concepto = concepto;
		this.nota = nota;
	}


	
	//GETTERS Y SETTERS
	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getConcepto() 
	{
		return concepto;
	}

	public void setConcepto(String concepto)
	{
		this.concepto = concepto;
	}

	public float getNota() 
	{
		return nota;
	}

	public void setNota(float nota) 
	{
		this.nota = nota;
	}

	public Integer getAlumno() 
	{
		return alumno;
	}

	public void setAlumno(Integer alumno) 
	{
		this.alumno = alumno;
	}

	public Integer getAsignatura() 
	{
		return asignatura;
	}

	public void setAsignatura(Integer asignatura) 
	{
		this.asignatura = asignatura;
	}

	
	
	//OTROS METODOS IMPORTANTES
	public String toString()
	{
		return "( " + this.id + " | " + this.concepto + " | " + this.nota + " | " + this.alumno +  " | " +  this.asignatura + " )";
	}
	
	
}
