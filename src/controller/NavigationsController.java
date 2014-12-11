package controller;

import javax.swing.JFrame;

import view.NavigationsView;

public class NavigationsController
{
	private NavigationsView navigationsV = new NavigationsView();
	
	public void navigationAnzeigen(JFrame frame)
	{
		navigationsV.anzeigen(frame);
	}
}
