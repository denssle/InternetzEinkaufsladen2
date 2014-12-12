package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class LoginView
{
	private JFrame loginFrame = new JFrame("Login");
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
		loginFrame.setLayout(new FlowLayout());		
		loginFrame.setSize(700,700);
		loginFrame.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		loginFrame.setLocation(700, 0);
		loginFrame.setVisible(true);
	}
}
