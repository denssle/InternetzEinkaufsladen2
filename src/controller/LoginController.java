package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginView;

public class LoginController implements ActionListener
{
	private static LoginView loginV = new LoginView();
	
	public static void loginAnzeigen()
	{
		if(loginV.isActiv())
			loginV.reset();
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
