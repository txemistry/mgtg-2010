package iso3.pt.model;

public class Unidad {

	//esta clase no recibe ningun atributo externo
	
	private Integer id;
	private String acronimo;
	private String titulo;
	private String contenido;
	
	//CONSTRUCTOR VACIO Y CON ARGUMENTOS
	protected Unidad()
	{}

	public Unidad(Integer id, String acronimo, String titulo, String contenido) 
	{
		super();
		this.id = id;
		this.acronimo = acronimo;
		this.titulo = titulo;
		this.contenido = contenido;
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

	public String getAcronimo() 
	{
		return acronimo;
	}

	public void setAcronimo(String acronimo) 
	{
		this.acronimo = acronimo;
	}

	public String getTitulo() 
	{
		return titulo;
	}

	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}

	public String getContenido() 
	{
		return contenido;
	}

	public void setContenido(String contenido) 
	{
		this.contenido = contenido;
	}
	
	
	//OTROS METODOS IMPORTANTES
	public String toString()
	{
		return "( " + this.id + " | " + this.acronimo + " | " + this.titulo + " | " + this.contenido +  " )";

	}
	
	
}
