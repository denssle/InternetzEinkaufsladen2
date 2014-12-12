package controller;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class ControllerController
{
	private NavigationsController navigationsC = new NavigationsController();
	private EinkaufsController einkaufsC = new EinkaufsController();
	private LoginController loginC = new LoginController();
	private RegistrationsController registrationsC = new RegistrationsController();
	
	public void startShop()
	{
		navigationsC.navigationAnzeigen();
	}
}
