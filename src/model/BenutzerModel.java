package model;

public class BenutzerModel
{
	private int id;
	private String name;
	private String email;
	private String strasse;
	private String stadt;
	private String passwort;
	/* Getter */
	
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getEmail()
	{
		return email;
	}
	public String getStrasse()
	{
		return strasse;
	}
	public String getStadt()
	{
		return stadt;
	}
	public String getPasswort()
	{
		return passwort;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setStrasse(String strasse)
	{
		this.strasse = strasse;
	}
	public void setStadt(String stadt)
	{
		this.stadt = stadt;
	}
	public void setPasswort(String passwort)
	{
		this.passwort = passwort;
	}
}
