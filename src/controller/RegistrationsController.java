package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.RegistrationsView;

public class RegistrationsController implements ActionListener
{
	private RegistrationsView regiV = new RegistrationsView();
	
	public void regiAnzeigen()
	{
		regiV.anzeigen();
	}

	public void setListener(RegistrationsController registrationsC)
	{
		regiV.setListener(registrationsC);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
