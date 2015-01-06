package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.RegistrationsView;

public class RegistrationsController implements ActionListener
{
	private static RegistrationsView regiV = new RegistrationsView();
	
	public static void regiAnzeigen()
	{
		//System.out.println("Is activ: " + regiV.isActiv());
		if(regiV.isActiv())
		{
			regiV.reset();
		}
		regiV.anzeigen();
	}

	public void setListener(RegistrationsController registrationsC)
	{
		regiV.setListener(registrationsC);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String Befehl = e.getActionCommand();
		System.out.println(Befehl);
	}
}
