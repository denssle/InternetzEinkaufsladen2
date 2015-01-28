package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import statics.Statics;

@SuppressWarnings("serial")
public class NavigationsView extends JFrame
{	
	private JPanel leiste;
	
	public NavigationsView(ActionListener navigationsController)
	{
		this.setTitle("Internetzladen 2");
		this.leiste = new JPanel();

		for(int i = 0; i< Statics.buttonlabels_nav.length; i++)
		{
			JButton neuerButton = new JButton(Statics.buttonlabels_nav[i]);
			neuerButton.addActionListener(navigationsController);
			leiste.add(neuerButton);
		}
		this.add(leiste);
		
		this.setLayout(new FlowLayout());
		this.setSize(700,150);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
	}

	public void anzeigen()
	{		
		this.setVisible(true);
	}
}


