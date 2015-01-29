package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BenutzerModel;
import statics.Statics;
import view.ProfilView;

public class ProfilController implements ActionListener
{
	private ProfilView profilView;
	
	public ProfilController()
	{
		this.profilView = new ProfilView(this);
	}
	public void anzeigen(BenutzerModel aktuellerBenutzer) 
	{
		if(aktuellerBenutzer == null)
		{
			profilView.zeigeKeinBenutzer();
		}
		else
		{
			profilView.zeigeBenutzer(aktuellerBenutzer);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		String befehl = e.getActionCommand();
		if(befehl.equals(Statics.ok))
		{
			profilView.schliessen();
		}
	}
}
