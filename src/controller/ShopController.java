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
import view.ShopView;

public class ShopController implements ActionListener
{
	private ArtikelDAO dao = new ArtikelDAO();
	private ShopView shopView = new ShopView(this, dao.getAlleArtikel());
	private ArtikelDetailController adc = new ArtikelDetailController();
	
	public ShopController()
	{
		testartikelAnlegen();
	}
	private void testartikelAnlegen()
	{
		Random diceRoller = new Random();
		for(int i = 1; i < 20; i ++)
		{
			ArtikelModel neuerArtikel = new ArtikelModel();
			neuerArtikel.setName("Testartikel Nr.: "+(i-1));
			neuerArtikel.setBeschreibung("Testbeschreibung: "+diceRoller.toString());
			neuerArtikel.setKategorie("Testkategorie: " + diceRoller.nextBoolean());
			neuerArtikel.setPreis(diceRoller.nextInt()*i + " Euro");
			dao.speichern(neuerArtikel);
		}
	}
	public void einkaufAnzeigen()
	{
		shopView.anzeigen();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton pressedButton = (JButton) e.getSource();
		String buttonName = pressedButton.getName();
		
		if(dao.artikelExists(buttonName))
		{
			System.out.println("Ist das ihr Arikel: "+dao.getArtikel(buttonName).getName()+"?");
			adc.artikelDetailsZeigen(dao.getArtikel(buttonName));
		}
	}
}
