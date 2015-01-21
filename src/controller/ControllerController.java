package controller;

public class ControllerController
{
	private NavigationsController navigationsC;
	
	public ControllerController()
	{
		navigationsC = new NavigationsController();
	}
	
	public void startShop()
	{
		navigationsC.navigationAnzeigen();
	}
}
