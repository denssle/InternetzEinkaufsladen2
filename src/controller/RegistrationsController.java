package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import persistence.BenutzerDAO;
import model.BenutzerModel;
import statics.Statics;
import view.RegistrationsView;

public class RegistrationsController implements ActionListener
{
	private RegistrationsView registrationsView;
	private BenutzerDAO benutzerDAO;
	private LoginController loginController;
	public RegistrationsController()
	{
		registrationsView = new RegistrationsView(this);
		benutzerDAO = new BenutzerDAO();
		loginController = new LoginController(benutzerDAO);
	}
	public void regiAnzeigen()
	{
		if(loginController.getAktuellenBenutzer() == null)
		{
			registrationsView.registrationsSchabloneAnzeigen();
		}
		else
		{
			registrationsView.bereitsAngemeldet();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{	
		String befehl = e.getActionCommand();
		if(befehl.equals(Statics.ok))
		{
			JTextField[] jTextFields = registrationsView.getEingaben();
			String[] inhaltTextFields = new String[jTextFields.length];
			for(int i = 0; i < jTextFields.length; i++)
			{
				inhaltTextFields[i] = jTextFields[i].getText();
				System.out.println(inhaltTextFields[i]);
			}
			
			if (eingabenValidierung(inhaltTextFields))
			{
				neuenBenutzerAnlegen(inhaltTextFields);
				registrationsView.schlissen();
			}
			else
			{
				registrationsView.fehlerWerfen(this, "X");
			}
		}
		
		if(befehl.equals(Statics.ok2))
		{
			registrationsView.fehlerSchliessen();
		}
	}
	
	private boolean eingabenValidierung(String[] inhaltTextFields)
	{
		return true;
	}
	
	private void neuenBenutzerAnlegen(String[] inhaltTextFields)
	{
		BenutzerModel neuerBenutzer = new BenutzerModel();
		neuerBenutzer.setName(inhaltTextFields[0]);
		neuerBenutzer.setEmail(inhaltTextFields[1]);
		neuerBenutzer.setStrasse(inhaltTextFields[2]);
		neuerBenutzer.setStadt(inhaltTextFields[3]);
		neuerBenutzer.setPasswort(inhaltTextFields[4]);
		
		benutzerDAO.benutzerSpeichern(neuerBenutzer);
		loginController.setAktuellenBenutzer(neuerBenutzer);
	}
	public void loginAnzeigen()
	{
		loginController.loginAnzeigen();
	}
}
