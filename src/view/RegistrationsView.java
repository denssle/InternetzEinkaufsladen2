package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import statics.Statics;

@SuppressWarnings("serial")
public class RegistrationsView extends JFrame
{
	private JTextField[] inhaltEingabefelder;
	private JDialog fehlerDialog;
	private JButton ok;
	private JPanel registrationsJPanel;
	
	public RegistrationsView(ActionListener registrationsController)
	{
		this.inhaltEingabefelder = new JTextField[Statics.benutzerlabels.length];
		this.fehlerDialog = new JDialog();
		this.registrationsJPanel = new JPanel();
		
		this.setTitle("Registration");
		this.setLayout(new FlowLayout());		
		this.setSize(700,700);
		this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		this.setLocation(Statics.loc_right, Statics.loc_down);
		ok = new JButton(Statics.ok);
		ok.addActionListener(registrationsController);
		this.add(registrationsJPanel);
		
	}
	public void fehlerWerfen(ActionListener registrationsController, String fehlergrund)
	{
		
        fehlerDialog.setTitle("Fehler");
        fehlerDialog.setSize(500,200);
        fehlerDialog.setVisible(true);
        fehlerDialog.setLocation(Statics.loc_right+100, Statics.loc_down+225);
        fehlerDialog.setLayout(new BorderLayout());
        
        fehlerDialog.add(new JLabel(fehlergrund), BorderLayout.CENTER);
        
        JButton ok2 = new JButton(Statics.ok2);
        ok2.addActionListener(registrationsController);
        
        fehlerDialog.add(ok2, BorderLayout.SOUTH);
	}
	public void fehlerSchliessen()
	{
		fehlerDialog.dispose();
	}
	public boolean isActiv()
	{
		return this.isDisplayable();
	}
	public void registrationsSchabloneAnzeigen()
	{
		registrationsJPanel.removeAll();
		registrationsJPanel.setLayout(new FlowLayout());
		
		registrationsJPanel.setLayout(new GridLayout(Statics.benutzerlabels.length+1,2));
		for(int i = 0; i<Statics.benutzerlabels.length; i++)
		{
			registrationsJPanel.add(new JLabel(Statics.benutzerlabels[i]));
			JTextField input = new JTextField("Hier bitte "+Statics.benutzerlabels[i]+" eingeben.");
			input.setName(Statics.benutzerlabels[i]);
			inhaltEingabefelder[i]=input;
			registrationsJPanel.add(input);
		}
		
		registrationsJPanel.add(ok);
		this.setVisible(true);
	}
	public void schlissen()
	{
		this.dispose();
	}
	public JTextField[] getEingaben()
	{
		return inhaltEingabefelder;
	}
	public void bereitsAngemeldet()
	{
		registrationsJPanel.removeAll();
		registrationsJPanel.add(new JLabel("Sie sind bereits registriert und angemeldet"));
		this.setVisible(true);
	}
}
