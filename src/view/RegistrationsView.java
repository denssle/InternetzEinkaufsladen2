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

public class RegistrationsView extends JFrame
{
	private JTextField[] textFelder = new JTextField[Statics.benutzerlabels.length];

	private JFrame regiFrame = new JFrame("Registration");
	private ActionListener controller;

	public void anzeigen()
	{
		JPanel zeile = new JPanel();
		zeile.setLayout(new FlowLayout());
		
		zeile.setLayout(new GridLayout(Statics.benutzerlabels.length+1,2));
		for(int i = 0; i<Statics.benutzerlabels.length; i++)
		{
			zeile.add(new JLabel(Statics.benutzerlabels[i]));
			JTextField input = new JTextField("Hier bitte "+Statics.benutzerlabels[i]+" eingeben.");
			input.setName(Statics.benutzerlabels[i]);
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
