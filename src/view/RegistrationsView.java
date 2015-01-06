package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistrationsView
{
	private String[] daten = {"Name", "Email", "Geburtstag", "Strasse", "Hausnummer", "Stadt", "Postleitzahl", "Passwort"};
	private JTextField[] textFelder = new JTextField[daten.length];

	private JFrame regiFrame = new JFrame("Registration");
	private ActionListener controller;

	public void anzeigen()
	{
		JPanel zeile = new JPanel();
		zeile.setLayout(new FlowLayout());
		
		zeile.setLayout(new GridLayout(daten.length+1,2));
		for(int i = 0; i<daten.length; i++)
		{
			zeile.add(new JLabel(daten[i]));
			JTextField input = new JTextField("Hier bitte "+daten[i]+" eingeben.");
			input.setName(daten[i]);
			textFelder[i]=input;
			zeile.add(input);
		}
		
		JButton ok = new JButton("Ok");
		ok.addActionListener(controller);
		zeile.add(ok);
		
		regiFrame.add(zeile);
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
		regiFrame.setLocation(710, 180);
		regiFrame.setVisible(true);
	}
	public boolean isActiv()
	{
		return regiFrame.isDisplayable();
	}
	public void reset()
	{
		regiFrame.removeAll();
	}
}
