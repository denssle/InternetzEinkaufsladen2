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

	public RegistrationsView(ActionListener registrationsController)
	{
		this.setTitle("Registration");
		this.setLayout(new FlowLayout());		
		this.setSize(700,700);
		this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		this.setLocation(Statics.loc_right, Statics.loc_down);
		
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
		ok.addActionListener(registrationsController);
		zeile.add(ok);
		this.add(zeile);
	}

	public boolean isActiv()
	{
		return this.isDisplayable();
	}
	public void show()
	{
		this.setVisible(true);
	}
	public void hide()
	{
		this.setVisible(false);
	}
}
