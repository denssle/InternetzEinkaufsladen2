package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import model.ArtikelModel;
import view.WarenkorbView;

public class WarenkorbController implements ActionListener
{
	private WarenkorbView warenkorbV = new WarenkorbView(this);
	private Map<Integer, ArtikelModel> aktuellerInhalt = new HashMap<Integer, ArtikelModel>();
	private static int id = 0;
	
	public void anzeigen()
	{
		warenkorbV.anzeigen();
		warenkorbV.addArtikel(aktuellerInhalt);
	}
	public void addArtikel(ArtikelModel aktuellerArtikel) 
	{
		aktuellerInhalt.put(id++, aktuellerArtikel);
		System.out.println("Warenkorb hat folgenden Inhalt: "+aktuellerInhalt.keySet());
		warenkorbV.addArtikel(aktuellerInhalt);
	}
	public void actionPerformed(ActionEvent e)
	{
		String befehl = e.getActionCommand();
		if(befehl.equals("Entfernen"))
		{
			System.out.println("Warenkorb: "+befehl);
		}
	}

	
}
