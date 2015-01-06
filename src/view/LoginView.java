package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginView
{
	private JFrame loginFrame = new JFrame("Login");
	private ActionListener controller;

	public void anzeigen()
	{
		JPanel loginleiste = new JPanel();
		loginleiste.setLayout(new FlowLayout());
		
		JTextField email = new JTextField("Email");
		
		JTextField passwort = new JTextField("Passwort");
		
		JButton ok = new JButton("Ok");
		ok.addActionListener(controller);
		
		loginleiste.add(new JLabel("Anmeldung"));
		loginleiste.add(email);
		loginleiste.add(passwort);
		loginleiste.add(ok);
		bauFrame(loginleiste);
	}
	public void setListener(ActionListener controller)
	{
		this.controller = controller;
	}
	private void bauFrame(JPanel loginleiste)
	{
		loginFrame.add(loginleiste);
		loginFrame.setLayout(new GridLayout());		
		loginFrame.setSize(700,150);
		loginFrame.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		loginFrame.setLocation(710, 0);
		loginFrame.setVisible(true);
	}
	public boolean isActiv()
	{
		return loginFrame.isDisplayable();
	}
	
	public void reset()
	{
		loginFrame.removeAll();
	}
}
