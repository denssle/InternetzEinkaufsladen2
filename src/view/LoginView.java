package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import statics.Statics;

@SuppressWarnings("serial")
public class LoginView extends JFrame
{
	private JTextField email;
	private JTextField passwort;
	
	public LoginView(ActionListener loginController)
	{
		JPanel loginleiste = new JPanel();
		loginleiste.setLayout(new FlowLayout());
		email = new JTextField("Email");
		passwort = new JTextField("Passwort");
		JButton ok = new JButton(Statics.ok);
		ok.addActionListener(loginController);
		
		loginleiste.add(new JLabel("Anmeldung"));
		loginleiste.add(email);
		loginleiste.add(passwort);
		loginleiste.add(ok);
		
		this.add(loginleiste);
		this.setLayout(new GridLayout());		
		this.setSize(700,150);
		this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		this.setLocation(Statics.loc_right, Statics.loc_up);
	}
	public void anzeigen()
	{
		this.setVisible(true);
	}
	
	public String getEmail()
	{
		return email.getText();
	}
	public String getPassword()
	{
		return passwort.getText();
	}
	public boolean isActiv()
	{
		return this.isDisplayable();
	}
}
