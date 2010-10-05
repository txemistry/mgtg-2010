package iso3.pt.model;

import java.util.HashSet;
import java.util.Set;

public class Asignatura {

	//Esta clase va a tener tres atributos externos, de unidad y de alumno

	private Integer id;
	private Integer codigo;
	private String nombre;
	private float creditos;
	private Profesor profesor; //le viene de la clase profesor
	private Set<Unidad> unidades; //Lista que le viene de Unidad
	private Set<Alumno> alumnos; //Lista que le viene de Alumno


	//CONSTRUCTOR VACIO Y CON ARGUMENTOS
	protected Asignatura()
	{}

	public Asignatura(Integer codigo, String nombre, float creditos) 
	{
		this.codigo = codigo;
		this.nombre = nombre;
		this.creditos = creditos;
		this.unidades = new HashSet<Unidad>();
		this.alumnos = new HashSet<Alumno>();
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

	public Integer getCodigo() 
	{
		return codigo;
	}

	public void setCodigo(Integer codigo) 
	{
		this.codigo = codigo;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public float getCreditos() 
	{
		return creditos;
	}

	public void setCreditos(float creditos) 
	{
		this.creditos = creditos;
	}

	public Profesor getProfesor() 
	{
		return profesor;
	}

	public void setProfesor(Profesor profesor) 
	{
		this.profesor = profesor;
	}

	public Set<Unidad> getUnidades() 
	{
		return unidades;
	}

	public void setUnidades(Set<Unidad> unidades) 
	{
		this.unidades = unidades;
	}

	public Set<Alumno> getAlumnos() 
	{
		return alumnos;
	}

	public void setAlumnos(Set<Alumno> alumnos) 
	{
		this.alumnos = alumnos;
	}

	//OTROS METODOS IMPORTANTES
	public void addUnidad(Unidad unidad)
	{
		this.unidades.add(unidad);
	}

	public void removeUnidad(Unidad unidad)
	{
		this.unidades.remove(unidad);
	}

	public void addAlumno(Alumno alumno)
	{
		this.alumnos.add(alumno);
	}

	public void removeAlumno(Alumno alumno)
	{
		this.alumnos.remove(alumno);
	}

	public String toString()
	{
		return "( " + this.id + " | " + this.codigo + " | " + this.nombre + " | " + this.creditos + " | " + this.profesor + " )";
	}

}
