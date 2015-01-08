package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.WarenkorbView;

public class WarenkorbController implements ActionListener
{
	private WarenkorbView warenkorbV = new WarenkorbView(this);
	
	public void warenkorbAnzeigen()
	{
		warenkorbV.anzeigen();
	}

	public void actionPerformed(ActionEvent e)
	{
		
	}
}
