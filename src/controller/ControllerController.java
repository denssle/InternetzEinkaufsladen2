package controller;

public class ControllerController
{
	private NavigationsController navigationsC = new NavigationsController();
	private EinkaufsController einkaufsC = new EinkaufsController();
	private LoginController loginC = new LoginController();
	private RegistrationsController registrationsC = new RegistrationsController();
	
	public void startShop()
	{
		starteListener();
		navigationsC.navigationAnzeigen();
	}
	
	private void starteListener()
	{
		navigationsC.setListener(navigationsC);
		einkaufsC.setListener(einkaufsC);
		loginC.setListener(loginC);
		registrationsC.setListener(registrationsC);
	}
}
