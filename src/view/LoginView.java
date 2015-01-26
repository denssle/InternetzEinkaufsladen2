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

public class LoginView extends JFrame
{
	public LoginView(ActionListener loginController)
	{
		JPanel loginleiste = new JPanel();
		loginleiste.setLayout(new FlowLayout());
		JTextField email = new JTextField("Email");
		JTextField passwort = new JTextField("Passwort");
		JButton ok = new JButton("Ok");
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

	public boolean isActiv()
	{
		return this.isDisplayable();
	}
}
