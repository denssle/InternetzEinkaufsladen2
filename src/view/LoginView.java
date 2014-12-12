package view;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class LoginView
{
private JFrame loginFrame = new JFrame("Login");
	
	public void anzeigen()
	{
		loginFrame.setLayout(new FlowLayout());		
		loginFrame.setSize(700,700);
		loginFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		loginFrame.setVisible(true);
	}
}
