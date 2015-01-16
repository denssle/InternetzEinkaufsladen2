package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import statics.Statics;
import view.NavigationsView;

public class NavigationsController implements ActionListener
{
	private NavigationsView navigationsV;
	private LoginController loginC;
	private ShopController shopC;
	private RegistrationsController regisC;

    public NavigationsController() {
        this.navigationsV = new NavigationsView(this);
        loginC = new LoginController();
        shopC = new ShopController();
        regisC = new RegistrationsController();
    }

    public void navigationAnzeigen()
	{
		//System.out.println("Navigation wird angezeigt");
		navigationsV.anzeigen();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String actionCommand = e.getActionCommand();
		for(int i = 0; i<Statics.buttonlabels_nav.length; i++)
		{
			if (actionCommand.equals(Statics.buttonlabels_nav[i]))
			{
				if(actionCommand.equals(Statics.ANMELDEN))
				{
					loginC.loginAnzeigen();
				}
				if(actionCommand.equals(Statics.buttonlabels_nav[1]))
				{
					shopC.einkaufAnzeigen();
				}
				if(actionCommand.equals(Statics.buttonlabels_nav[2]))
				{
					shopC.warenkorbAnzeigen();
				}
				if(actionCommand.equals(Statics.buttonlabels_nav[3]))
				{
				}
				if(actionCommand.equals(Statics.buttonlabels_nav[4]))
				{
					regisC.regiAnzeigen();
				}
			}	
		}
	}
}
