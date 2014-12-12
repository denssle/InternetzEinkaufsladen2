package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.NavigationsView;

public class NavigationsController implements ActionListener
{
	private EinkaufsController einkaufsC = new EinkaufsController();
	private LoginController loginC = new LoginController();
	private RegistrationsController registrationsC = new RegistrationsController();
	private NavigationsView navigationsV = new NavigationsView();
	
	public void navigationAnzeigen()
	{
		navigationsV.anzeigen();
	}
	
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
					loginC.loginAnzeigen();
				}
				if(Befehl.equals(buttonlabels[1]))
				{
					einkaufsC.einkaufAnzeigen();
				}
				if(Befehl.equals(buttonlabels[4]))
				{
					registrationsC.regiAnzeigen();
				}
			}	
		}
	}

	public void setListener(NavigationsController navigationsC)
	{
		navigationsV.setListener(navigationsC);
	}
}
