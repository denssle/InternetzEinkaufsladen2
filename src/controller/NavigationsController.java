package controller;

import javax.swing.JFrame;
import view.NavigationsView;

public class NavigationsController
{
	private EinkaufsController einkaufsC = new EinkaufsController();
	private LoginController loginC = new LoginController();
	private RegistrationsController registrationsC = new RegistrationsController();
	
	private NavigationsView navigationsV = new NavigationsView();
	
	public void navigationAnzeigen()
	{
		navigationsV.anzeigen();
	}
}
