package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import statics.Statics;
import view.NavigationsView;

public class NavigationsController implements ActionListener
{
	private NavigationsView navigationsV = new NavigationsView(this);
	
	public void navigationAnzeigen()
	{
		navigationsV.showFrame();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String Befehl = e.getActionCommand();
		for(int i = 0; i<Statics.buttonlabels_nav.length; i++)
		{
			if (Befehl.equals(Statics.buttonlabels_nav[i]))
			{
				if(Befehl.equals(Statics.buttonlabels_nav[0]))
				{
					LoginController.loginAnzeigen();
				}
				if(Befehl.equals(Statics.buttonlabels_nav[1]))
				{
					ShopController.einkaufAnzeigen();
				}
				if(Befehl.equals(Statics.buttonlabels_nav[2]))
				{
				}
				if(Befehl.equals(Statics.buttonlabels_nav[3]))
				{
				}
				if(Befehl.equals(Statics.buttonlabels_nav[4]))
				{
					RegistrationsController.regiAnzeigen();
				}
			}	
		}
	}
}
