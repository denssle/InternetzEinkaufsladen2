package controller;
import view.LoginView;

public class LoginController
{
	private LoginView loginV = new LoginView();
	
	public void loginAnzeigen()
	{
		loginV.anzeigen();
	}
}
