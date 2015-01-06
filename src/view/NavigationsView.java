package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class NavigationsView
{
	private ActionListener controller;
	private JFrame navFrame = new JFrame("InternetzLaden2");
	private final String[] buttonlabels = 
		{
			"Anmelden", 
			"Einkaufen", 
			"Einkaufswagen", 
			"Profil", 
			"Registration"
		};
	
	public void anzeigen()
	{		
		JPanel leiste = new JPanel();
		for(int i = 0; i<buttonlabels.length; i++)
		{
			JButton neuerButton = new JButton(buttonlabels[i]);
			neuerButton.addActionListener(controller);
			leiste.add(neuerButton);
		}
		navFrame.add(leiste);
		frameBauen();
	}
	public String[] getLabel()
	{
		return buttonlabels;
	}
	private void frameBauen()
	{
		navFrame.setLayout(new FlowLayout());
		navFrame.setSize(700,150);
		navFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		navFrame.setAlwaysOnTop(true);
		navFrame.setVisible(true);
	}

	public void setListener(ActionListener controller)
	{
		this.controller = controller;
	}
}


