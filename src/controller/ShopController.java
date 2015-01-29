package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

import model.ArtikelModel;
import persistence.ArtikelDAO;
import view.ArtikelDetailView;
import view.ShopView;

public class ShopController implements ActionListener
{
	private ArtikelDAO dao;
	private ShopView shopView;
	private WarenkorbController warenkorbController;
	private ArtikelDetailView artikelDetailView;
	
	public ShopController()
	{
		this.dao = new ArtikelDAO();
		this.shopView = new ShopView(this, dao.getAlleArtikel());
		this.warenkorbController = new WarenkorbController();
		this.artikelDetailView = new ArtikelDetailView(this);
		
		//testartikelAnlegen();
	}

	@SuppressWarnings("unused")
	private void testartikelAnlegen()
	{
		Random zufall = new Random();
		for(int i = 1; i < 25; i ++)
		{
			ArtikelModel neuerArtikel = new ArtikelModel();
			neuerArtikel.setName("Testartikel Nr.: "+(i-1));
			neuerArtikel.setBeschreibung("Testbeschreibung: "+zufall.toString());
			neuerArtikel.setKategorie("Testkategorie: " + zufall.nextBoolean());
			double preis = Math.round(100.0 *zufall.nextDouble()+i)/ 100.0;
			neuerArtikel.setPreis(preis);
			dao.speichern(neuerArtikel);
		}
	}
	
	public void shopViewAnzeigen()
	{
		shopView.updateArtikelMap(dao.getAlleArtikel());
		shopView.anzeigen();
	}
	
	public void warenkorbAnzeigen()
	{
		warenkorbController.anzeigen();
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton pressedButton = (JButton) e.getSource();
		String uuidString = pressedButton.getName();
		String befehl = e.getActionCommand();
		System.out.println("uuidString:"+uuidString+" befehl:"+ befehl);
		ArtikelModel aktuellerArtikel = null;
		
		if(uuidString != null)
		{
			if(dao.artikelExists(uuidString))
			{
				aktuellerArtikel = dao.getArtikel(uuidString);
				System.out.println("Detailierter Artikel: "+aktuellerArtikel.getName() + " gefunden. ");
				artikelDetailView.anzeigen(aktuellerArtikel);
			}
			else
			{
				System.out.println("Kein passender Artikel gefunden. ");
			}
		}
		
		if(befehl.equals("Schliessen"))
		{
			artikelDetailView.verstecken();
			aktuellerArtikel = null;
		}
		
		if(befehl.equals("Kaufen"))
		{
			System.out.println("Folgendes soll gekauft werden: "+ aktuellerArtikel.getName());
			warenkorbController.addArtikel(aktuellerArtikel);
			artikelDetailView.verstecken();
			aktuellerArtikel = null;
		}
		
		if(befehl.equals("<"))
		{
			shopView.vorherigeSeite();
		}
		
		if(befehl.equals(">"))
		{
			shopView.naechsteSeite();
		}
	}
}
