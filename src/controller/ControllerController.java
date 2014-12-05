package controller;

public class ControllerController
{
	private EinkaufsController einkaufsC = new EinkaufsController();
	private LoginController loginC = new LoginController();
	private NavigationsController navigationsC = new NavigationsController();
	private RegistrationsController registrationsC = new RegistrationsController();
	
	public void startShop()
	{
		navigationsC.navigationAnzeigen();
	}
}
