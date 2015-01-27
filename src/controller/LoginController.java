package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import persistence.BenutzerDAO;
import statics.Statics;
import view.LoginView;

public class LoginController implements ActionListener
{
	private LoginView loginV;
	private BenutzerDAO benutzerDAO;
	
	public LoginController(BenutzerDAO benutzerDAO)
	{
		loginV = new LoginView(this);
		this.benutzerDAO = benutzerDAO;
	}
	public void loginAnzeigen()
	{
		loginV.anzeigen();
	}

	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Login: Event");
		String Befehl = e.getActionCommand();
		if(Befehl.equals(Statics.ok))
		{
			benutzerDAO.benutzerVorhanden(loginV.getEmail(), loginV.getEmail());
		}
	}
}
