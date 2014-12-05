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
	public void anzeigen()
	{
		JFrame frame = new JFrame("InternetzLaden2");
		frame.setLayout(new FlowLayout());
		
		String[] buttonlabels = {
				"Anmelden", 
				"Einkaufen", 
				"Einkaufswagen", 
				"Profil", 
				"Verwaltung"};
		
		JPanel leiste = new JPanel();
		
		for(int i = 0; i<buttonlabels.length; i++)
		{
			JButton neuerButton = new JButton(buttonlabels[i]);
			neuerButton.addActionListener(this);
			leiste.add(neuerButton);
		}
		
		frame.add(leiste);
		frame.setSize(700,700);
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e)
	{
		String Befehl = e.getActionCommand();
		if (Befehl.equals("Anmelden"))
		{
			System.out.println("X");
		}
	}
}
