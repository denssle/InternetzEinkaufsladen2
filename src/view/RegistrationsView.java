package view;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class RegistrationsView
{
private JFrame regiFrame = new JFrame("Registration");
	
	public void anzeigen()
	{
		regiFrame.setLayout(new FlowLayout());		
		regiFrame.setSize(700,700);
		regiFrame.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		regiFrame.setVisible(true);
	}
}
