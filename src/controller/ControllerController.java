package controller;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class ControllerController
{
	private NavigationsController navigationsC = new NavigationsController();

	public void startShop()
	{
		navigationsC.navigationAnzeigen();
	}
}
