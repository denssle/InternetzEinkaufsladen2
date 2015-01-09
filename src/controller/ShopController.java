package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;

import model.ArtikelModel;
import persistence.ArtikelDAO;
import view.ShopView;

public class ShopController implements ActionListener
{
	private ArtikelDAO dao = new ArtikelDAO();
	private ShopView shopView = new ShopView(this, dao.getAlleArtikel());
	
	public ShopController()
	{
		ArtikelModel neuerArtikel = new ArtikelModel();
		neuerArtikel.setName("Testartikel");
		dao.speichern(neuerArtikel);
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
			System.out.println("Ist das ihr Arikel: "+dao.getArtikel(buttonName)+"?");
		}
	}
}
