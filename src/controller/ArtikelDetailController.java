package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ArtikelDetailView;
import model.ArtikelModel;

public class ArtikelDetailController implements ActionListener
{
	private ArtikelDetailView view = new ArtikelDetailView(this);
	private WarenkorbController warenkorbC = new WarenkorbController();
	private ArtikelModel aktuellerArtikel;
	
	public void artikelDetailsZeigen(ArtikelModel artikel)
	{
		aktuellerArtikel = artikel;
		view.anzeigen(aktuellerArtikel);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String befehl = e.getActionCommand();
		if(befehl.equals("Schliessen"))
		{
			aktuellerArtikel = null;
			view.verstecken();
		}
		if(befehl.equals("Kaufen"))
		{
			System.out.println("Folgendes soll gekauft werden: "+aktuellerArtikel.getName());
			warenkorbC.addArtikel(aktuellerArtikel);
		}
	}

}
