package iso3.pt.action;

import iso3.pt.service.PtDaoService;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport
{
	private String user;
	private String pass;
	private String nom;
	private String tel;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String registrar()
	{
		PtDaoService dao = new PtDaoService();
		try
		{
			dao.addAlumno(new Integer(this.user), this.pass, this.nom, this.tel);
		}
		catch(Exception e)
		{
			addActionError(getText("user.found.exception"));
			return INPUT;

		}
		return "alumnoRegistrado";
	}

}
