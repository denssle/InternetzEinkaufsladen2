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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
