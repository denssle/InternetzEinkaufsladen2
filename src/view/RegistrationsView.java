package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class RegistrationsView
{
	private JFrame regiFrame = new JFrame("Registration");
	private ActionListener controller;

	public void anzeigen()
	{
		bauFrame();
	}
	
	public void setListener(ActionListener controller)
	{
		this.controller = controller;
	}
	private void bauFrame()
	{
		regiFrame.setLayout(new FlowLayout());		
		regiFrame.setSize(700,700);
		regiFrame.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		regiFrame.setLocation(710, 200);
		regiFrame.setVisible(true);
	}
}
