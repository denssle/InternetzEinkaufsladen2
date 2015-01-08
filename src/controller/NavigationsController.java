package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import statics.Statics;
import view.NavigationsView;

public class NavigationsController implements ActionListener
{
	private NavigationsView navigationsV = new NavigationsView(this);
	
	private LoginController loginC = new LoginController();
	private ShopController shopC = new ShopController();
	private RegistrationsController regisC = new RegistrationsController();
	private WarenkorbController warenkorbC = new WarenkorbController();
	
	public void navigationAnzeigen()
	{
		//System.out.println("Navigation wird angezeigt");
		navigationsV.anzeigen();
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
					loginC.loginAnzeigen();
				}
				if(Befehl.equals(Statics.buttonlabels_nav[1]))
				{
					shopC.einkaufAnzeigen();
				}
				if(Befehl.equals(Statics.buttonlabels_nav[2]))
				{
					warenkorbC.warenkorbAnzeigen();
				}
				if(Befehl.equals(Statics.buttonlabels_nav[3]))
				{
				}
				if(Befehl.equals(Statics.buttonlabels_nav[4]))
				{
					regisC.regiAnzeigen();
				}
			}	
		}
	}
}
