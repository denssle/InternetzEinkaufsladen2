package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginView;

public class LoginController implements ActionListener
{
	private LoginView loginV = new LoginView();
	
	public void loginAnzeigen()
	{
		loginV.anzeigen();
	}

	public void setListener(LoginController loginC)
	{
		loginV.setListener(loginC);
	}

	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Login: Event");
		String Befehl = e.getActionCommand();
		if(Befehl.equals("Ok"))
		{
			System.out.println("Login: OK");
		}
	}
}
