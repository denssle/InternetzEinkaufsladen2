package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
public class NavigationsView implements ActionListener
{
	private String[] buttonlabels = {
			"Anmelden", 
			"Einkaufen", 
			"Einkaufswagen", 
			"Profil", 
			"Verwaltung"};
	
	public void anzeigen(JFrame frame)
	{
		
		
		JPanel leiste = new JPanel();
		
		for(int i = 0; i<buttonlabels.length; i++)
		{
			JButton neuerButton = new JButton(buttonlabels[i]);
			neuerButton.addActionListener(this);
			leiste.add(neuerButton);
		}
		
		frame.add(leiste);
		
	}

	public void actionPerformed(ActionEvent e)
	{
		String Befehl = e.getActionCommand();
		for(int i = 0; i<buttonlabels.length; i++)
		{
			if (Befehl.equals(buttonlabels[i]))
			{
				System.out.println(buttonlabels[i]);
			}	
		}
	}
}
