package iso3.pt.model;

import java.util.HashSet;
import java.util.Set;

public class Alumno 
{

	//esta clase va a tener 2 atributos externos

	private Integer dni;
	private String password;
	private String nombre;
	private String telefono;
	private Set<Asignatura> asignaturas; //Lista que le viene de la clase asignatura
	private Set<Evaluacion> evaluaciones; //Lista que le viene de la clase Evaluacion

	//CONSTRUCTOR VACIO Y CON ARGUMENTOS
	protected Alumno()
	{}

	public Alumno(Integer dni, String password, String nombre, String telefono)
	{
		super();
		this.dni = dni;
		this.password = password;
		this.nombre = nombre;
		this.telefono = telefono;
		this.asignaturas = new HashSet<Asignatura>();
		this.evaluaciones = new HashSet<Evaluacion>();
	}


	//GETTERS Y SETTERS
	public Integer getDni() 
	{
		return dni;
	}

	public void setDni(Integer dni) 
	{
		this.dni = dni;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getTelefono() 
	{
		return telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}

	public Set<Asignatura> getAsignaturas() 
	{
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) 
	{
		this.asignaturas = asignaturas;
	}

	public Set<Evaluacion> getEvaluaciones() 
	{
		return evaluaciones;
	}

	public void setEvaluaciones(Set<Evaluacion> evaluaciones) 
	{
		this.evaluaciones = evaluaciones;
	}


	//OTROS METODOS IMPORTANTES
	public void addAsignatura(Asignatura asignatura)
	{
		this.asignaturas.add(asignatura);
	}

	public void removeAsignatura(Asignatura asignatura)
	{
		this.asignaturas.remove(asignatura);
	}

	public void addEvaluacion(Evaluacion evaluacion)
	{
		this.evaluaciones.add(evaluacion);
	}

	public void removeEvaluacion(Evaluacion evaluacion)
	{
		this.evaluaciones.remove(evaluacion);
	}

	public String toString()
	{
		return "( " + this.dni + " | " + this.password + " | " + this.nombre + " | " + this.telefono +  " )";
	}

}
