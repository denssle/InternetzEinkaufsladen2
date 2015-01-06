package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.NavigationsView;

public class NavigationsController implements ActionListener
{
	private NavigationsView navigationsV = new NavigationsView();
	
	public void navigationAnzeigen()
	{
		navigationsV.anzeigen();
	}
	
	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent e)
	{
		String[] buttonlabels = navigationsV.getLabel();
		
		String Befehl = e.getActionCommand();
		for(int i = 0; i<buttonlabels.length; i++)
		{
			if (Befehl.equals(buttonlabels[i]))
			{
				if(Befehl.equals(buttonlabels[0]))
				{
					LoginController.loginAnzeigen();
				}
				if(Befehl.equals(buttonlabels[1]))
				{
					EinkaufsController.einkaufAnzeigen();
				}
				if(Befehl.equals(buttonlabels[2]))
				{
				}
				if(Befehl.equals(buttonlabels[3]))
				{
				}
				if(Befehl.equals(buttonlabels[4]))
				{
					RegistrationsController.regiAnzeigen();
				}
			}	
		}
	}

	public void setListener(NavigationsController navigationsC)
	{
		navigationsV.setListener(navigationsC);
	}
}
