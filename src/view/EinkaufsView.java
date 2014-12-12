package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EinkaufsView
{
	private JFrame einkaufFrame = new JFrame("Einkaufen");
	private ActionListener controller;
	
	public void anzeigen()
	{
		bauFrame();
	}
	private void bauFrame()
	{
		einkaufFrame.setLayout(new FlowLayout());		
		einkaufFrame.setSize(700,700);
		einkaufFrame.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		einkaufFrame.setVisible(true);
		einkaufFrame.setLocation(700, 0);
	}
	public void setListener(ActionListener controller)
	{
		this.controller = controller;
	}
}