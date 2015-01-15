package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

import model.ArtikelModel;
import view.WarenkorbView;

public class WarenkorbController implements ActionListener
{
	private WarenkorbView warenkorbV = new WarenkorbView();
	private Map<Integer, ArtikelModel> aktuellerInhalt = new HashMap<Integer, ArtikelModel>();
	private static int id = 0;
	
	public void anzeigen()
	{
		warenkorbV.anzeigen();
		warenkorbV.addArtikel(aktuellerInhalt, this);
	}
	public void addArtikel(ArtikelModel aktuellerArtikel) 
	{
		aktuellerInhalt.put(id++, aktuellerArtikel);
		System.out.println("Warenkorb hat folgenden Inhalt: "+aktuellerInhalt.keySet());
		warenkorbV.addArtikel(aktuellerInhalt, this);
	}
	public void entferneArtikel(String id)
	{
		int idToInt = Integer.parseInt(id);
		System.out.println("Zu entfernender Artikel: "+idToInt);
		aktuellerInhalt.remove(idToInt);
		warenkorbV.addArtikel(aktuellerInhalt, this);
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton pressedButton = (JButton) e.getSource();
		String buttonName = pressedButton.getName();
		String befehl = e.getActionCommand();
		
		System.out.println("Warenkorb; buttonName:"+buttonName+" befehl: "+befehl);
		entferneArtikel(buttonName);
	}

	
}
