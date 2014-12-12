package view;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EinkaufsView
{
	private JFrame einkaufFrame = new JFrame("Einkaufen");
	
	public void anzeigen()
	{
		einkaufFrame.setLayout(new FlowLayout());		
		einkaufFrame.setSize(700,700);
		einkaufFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		einkaufFrame.setVisible(true);
	}
}
