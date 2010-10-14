package iso3.pt.model;

public class Evaluacion 
{

	//Esta clase va a tener dos atributos externos
	
	private Integer id;
	private String concepto;
	private float nota;
	private Alumno alumno; //alumno al qeu pertenece dicha evaluacion
	private Asignatura asignatura; //la asignatura a la que pertenece dicha evaluacion
	
	
	//CONSTRUCTOR VACIO Y CON ARGUMENTOS
	protected Evaluacion()
	{}


	public Evaluacion(String concepto, float nota) 
	{
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

	public Alumno getAlumno() 
	{
		return alumno;
	}

	public void setAlumno(Alumno alumno) 
	{
		this.alumno = alumno;
	}

	public Asignatura getAsignatura() 
	{
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) 
	{
		this.asignatura = asignatura;
	}

	
	
	//OTROS METODOS IMPORTANTES
	public String toString()
	{
		return "( " + this.id + " | " + this.concepto + " | " + this.nota + " )";
	}
	
	
}
