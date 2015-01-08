package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.RegistrationsView;

public class RegistrationsController implements ActionListener
{
	private RegistrationsView regiV = new RegistrationsView(this);
	
	public void regiAnzeigen()
	{
		regiV.show();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String Befehl = e.getActionCommand();
		System.out.println(Befehl);
	}
}
