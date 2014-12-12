package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
public class NavigationsView implements ActionListener
{
	private JFrame navFrame = new JFrame("InternetzLaden2");
	private String zuWechseln;
	private String[] buttonlabels = 
		{
			"Anmelden", 
			"Einkaufen", 
			"Einkaufswagen", 
			"Profil", 
			"Verwaltung"
		};
	
	public void anzeigen()
	{
		navFrame.setLayout(new FlowLayout());
		JPanel leiste = new JPanel();
		
		for(int i = 0; i<buttonlabels.length; i++)
		{
			JButton neuerButton = new JButton(buttonlabels[i]);
			neuerButton.addActionListener(this);
			leiste.add(neuerButton);
		}
		
		navFrame.add(leiste);
		
		navFrame.setSize(700,150);
		navFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		navFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		String Befehl = e.getActionCommand();
		for(int i = 0; i<buttonlabels.length; i++)
		{
			if (Befehl.equals(buttonlabels[i]))
			{
				zuWechseln = buttonlabels[i];
			}	
		}
		System.out.println(zuWechseln);
	}
}
