package controller;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class ControllerController
{
	private EinkaufsController einkaufsC = new EinkaufsController();
	private LoginController loginC = new LoginController();
	private NavigationsController navigationsC = new NavigationsController();
	private RegistrationsController registrationsC = new RegistrationsController();
	private JFrame frame = new JFrame("InternetzLaden2");
	public void startShop()
	{
		frame.setLayout(new FlowLayout());

		navigationsC.navigationAnzeigen(frame);
		
		frame.setSize(700,700);
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
