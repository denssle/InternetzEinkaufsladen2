package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BenutzerModel;
import persistence.BenutzerDAO;
import statics.Statics;
import view.LoginView;

public class LoginController implements ActionListener
{
	private LoginView loginView;
	private BenutzerDAO benutzerDAO;
	private static BenutzerModel aktuellerBenutzer;
	
	public LoginController(BenutzerDAO benutzerDAO)
	{
		loginView = new LoginView(this);
		this.benutzerDAO = benutzerDAO;
		aktuellerBenutzer  = null;
	}
	public void loginAnzeigen()
	{
		if(aktuellerBenutzer == null)
		{
			loginView.anmeldeSchablone();
		}
		else
		{
			loginView.bereitsAngemeldetSchablone();
		}
	}
	
	public BenutzerModel getAktuellenBenutzer()
	{
		return aktuellerBenutzer;
	}
	
	@SuppressWarnings("static-access")
	public void setAktuellenBenutzer(BenutzerModel benutzerModel)
	{
		this.aktuellerBenutzer = benutzerModel;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Login: Event");
		String Befehl = e.getActionCommand();
		if(Befehl.equals(Statics.ok))
		{
			aktuellerBenutzer = benutzerDAO.benutzerVorhanden(loginView.getEmail(), loginView.getEmail());
			if(aktuellerBenutzer != null)
			{
				loginView.schliessen();
			}
		}
	}
}
