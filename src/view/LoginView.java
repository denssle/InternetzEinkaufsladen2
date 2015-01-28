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
	private ActionListener actionListener;
	private JPanel loginleiste;
	
	public LoginView(ActionListener loginController)
	{
		this.loginleiste = new JPanel();
		this.actionListener = loginController;
		loginleiste.setLayout(new FlowLayout());

		this.setLayout(new GridLayout());		
		this.setSize(700,150);
		this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		this.setLocation(Statics.loc_right, Statics.loc_up);
	}
	
	public void anmeldeSchablone()
	{
		loginleiste.removeAll();
		email = new JTextField("Email");
		passwort = new JTextField("Passwort");
		JButton ok = new JButton(Statics.ok);
		ok.addActionListener(actionListener);
		
		loginleiste.add(new JLabel("Anmeldung"));
		loginleiste.add(email);
		loginleiste.add(passwort);
		loginleiste.add(ok);
		
		this.add(loginleiste);
		this.setVisible(true);
	}
	
	public void bereitsAngemeldetSchablone()
	{
		loginleiste.removeAll();
		loginleiste.add(new JLabel("Sie sind bereits angemeldet. "));
		this.setVisible(true);
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
	public void schliessen()
	{
		this.dispose();
	}
}
