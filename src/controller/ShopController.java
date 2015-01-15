package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JButton;

import model.ArtikelModel;
import persistence.ArtikelDAO;
import view.ArtikelDetailView;
import view.ShopView;

public class ShopController implements ActionListener
{
	private ArtikelDAO dao = new ArtikelDAO();
	private ShopView shopView = new ShopView(this, dao.getAlleArtikel());
	private WarenkorbController warenkorbC = new WarenkorbController();
	private ArtikelDetailView artikelView = new ArtikelDetailView(this);
	
	public ShopController()
	{
		testartikelAnlegen();
	}
	private void testartikelAnlegen()
	{
		Random diceRoller = new Random();
		for(int i = 1; i < 22; i ++)
		{
			ArtikelModel neuerArtikel = new ArtikelModel();
			neuerArtikel.setName("Testartikel Nr.: "+(i-1));
			neuerArtikel.setBeschreibung("Testbeschreibung: "+diceRoller.toString());
			neuerArtikel.setKategorie("Testkategorie: " + diceRoller.nextBoolean());
			neuerArtikel.setPreis(diceRoller.nextInt() + " Euro");
			dao.speichern(neuerArtikel);
		}
	}
	public void einkaufAnzeigen()
	{
		shopView.anzeigen();
	}
	
	public void warenkorbAnzeigen()
	{
		warenkorbC.anzeigen();
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton pressedButton = (JButton) e.getSource();
		String buttonName = pressedButton.getName();
		String befehl = e.getActionCommand();
		ArtikelModel aktuellerArtikel = null;
		System.out.println("buttonName:"+buttonName+" befehl:"+ befehl);
		if(buttonName != null)
		{
			if(dao.artikelExists(buttonName))
			{
				aktuellerArtikel = dao.getArtikel(buttonName);
				System.out.println("Detailierter Artikel: "+aktuellerArtikel.getName());
				artikelView.anzeigen(aktuellerArtikel);
			}
		}
		
		if(befehl.equals("Schliessen"))
		{
			artikelView.verstecken();
			aktuellerArtikel = null;
		}
		if(befehl.equals("Kaufen"))
		{
			System.out.println("Folgendes soll gekauft werden: "+ aktuellerArtikel.getName());
		}
	}
}
