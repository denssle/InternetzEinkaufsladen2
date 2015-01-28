package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import statics.Statics;
import view.NavigationsView;

public class NavigationsController implements ActionListener
{
	private NavigationsView navigationsView;
	private ShopController shopController;
	private RegistrationsController registrationsControllerC;

    public NavigationsController() {
        this.navigationsView = new NavigationsView(this);
        this.shopController = new ShopController();
        this.registrationsControllerC = new RegistrationsController();
    }

    public void navigationAnzeigen()
	{
		//System.out.println("Navigation wird angezeigt");
		navigationsView.anzeigen();
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
					registrationsControllerC.loginAnzeigen();
				}
				if(actionCommand.equals(Statics.buttonlabels_nav[1]))
				{
					shopController.shopViewAnzeigen();
				}
				if(actionCommand.equals(Statics.buttonlabels_nav[2]))
				{
					shopController.warenkorbAnzeigen();
				}
				if(actionCommand.equals(Statics.buttonlabels_nav[3]))
				{
				}
				if(actionCommand.equals(Statics.buttonlabels_nav[4]))
				{
					registrationsControllerC.regiAnzeigen();
				}
			}	
		}
	}
}
