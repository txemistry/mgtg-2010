package iso3.pt.dao.excepciones;

public class UserFoundException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public UserFoundException(String message)
	{
		super(message);
	}
}
