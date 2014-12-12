package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
public class NavigationsView
{
	private JFrame navFrame = new JFrame("InternetzLaden2");
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
		ButtonListener.setButtonsLabels(buttonlabels);
		
		JPanel leiste = new JPanel();
		for(int i = 0; i<buttonlabels.length; i++)
		{
			JButton neuerButton = new JButton(buttonlabels[i]);
			neuerButton.addActionListener(new ButtonListener());
			leiste.add(neuerButton);
		}
		navFrame.add(leiste);
		frameBauen();
	}
	
	private void frameBauen()
	{
		navFrame.setLayout(new FlowLayout());
		navFrame.setSize(700,150);
		navFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		navFrame.setAlwaysOnTop(true);
		navFrame.setVisible(true);
	}
}

class ButtonListener implements ActionListener
{
	private static String[] buttonlabels;
	
	public void actionPerformed(ActionEvent e)
	{
		  String zuWechseln = "leerer String :)";
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
	
	public static void setButtonsLabels(String[] newLabel)
	{
		buttonlabels = newLabel;
	}
}
