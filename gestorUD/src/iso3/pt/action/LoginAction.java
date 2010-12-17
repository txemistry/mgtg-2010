package iso3.pt.action;

/////////////////////
//SOMOS EL GRUPO 18//
/////////////////////
import iso3.pt.model.Alumno;
import iso3.pt.model.Asignatura;
import iso3.pt.model.Profesor;
import iso3.pt.service.PtDaoService;

import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class LoginAction extends ActionSupport 
{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String userType;

	
	

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	
	public String getUserType() 
	{
		return userType;
	}

	public void setUserType(String userType) 
	{
		this.userType = userType;
	}
	

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String login()
	{
		PtDaoService dao = new PtDaoService();
		if(this.getUserType().equals("Estudiante"))
		{
			try 
			{
				Alumno alumno = dao.loginAlumno(new Integer(this.getUsername()), this.getPassword());
				
				Map session = ActionContext.getContext().getSession();
				session.put("dni", alumno.getDni());
				session.put("nombre", alumno.getNombre());
				
				
				return "listStudentSubjects";
			} 
			catch (Exception e) 
			{
				if(e.getMessage().contains("IncorrectPasswordException"))
				{
					addActionError(getText("incorrect.password.exception"));
					return INPUT;
				}
				else
				{
					addActionError(getText("user.not.found.exception"));
					return INPUT;
				}
			}
		}
		else //El userType es profesor
		{
			try 
			{
				Profesor profesor = dao.loginProfesor(new Integer(this.getUsername()), this.getPassword());
				Map session = ActionContext.getContext().getSession();
				session.put("id", profesor.getId());
				session.put("nombre", profesor.getNombre());
				session.put("dni", profesor.getDni());
				
				return "listLecturerSubjects";
			} 
			catch (Exception e) 
			{
				if(e.getMessage().contains("IncorrectPasswordException"))
				{
					addActionError(getText("incorrect.password.exception"));
					return INPUT;
				}
				else
				{
					addActionError(getText("user.not.found.exception"));
					return INPUT;
				}
			}
		}
	}

}
