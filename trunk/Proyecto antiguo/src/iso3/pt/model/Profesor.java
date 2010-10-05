package iso3.pt.model;

public class Profesor {
	
	//Esta clase no tiene ningun atributo externo
	
	private Integer id;
	private Integer dni;
	private String password;
	private String nombre;
	private String telefono;
	private String email;
	private String despacho;
	
	//CONSTRUCTOR VACIO Y CON ARGUMENTOS
	protected Profesor()
	{}
	
	public Profesor(Integer id, Integer dni, String password, String nombre, String telefono, String email, String despacho)
	{
		this.id = id;
		this.dni = dni;
		this.password = password;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.despacho = despacho;
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
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getDespacho() 
	{
		return despacho;
	}
	
	public void setDespacho(String despacho) 
	{
		this.despacho = despacho;
	}
	
	//OTROS METODOS IMPORTANTES
	public String toString()
	{
		return "( " + this.id + " | " + this.dni + " | " + this.password + " | " + this.nombre +  " | " +  this.telefono + " | " +  this.email + " | " +  this.despacho + " )";
	}
	
}
