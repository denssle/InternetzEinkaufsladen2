package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.RegistrationsView;

public class RegistrationsController implements ActionListener
{
	private RegistrationsView registrationsView;
	
	public RegistrationsController()
	{
		registrationsView = new RegistrationsView(this);
	}
	public void regiAnzeigen()
	{
		registrationsView.anzeigen();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String befehl = e.getActionCommand();
		System.out.println(befehl);
	}
}
