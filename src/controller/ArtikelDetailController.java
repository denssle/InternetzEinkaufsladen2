package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ArtikelDetailView;
import model.ArtikelModel;

public class ArtikelDetailController implements ActionListener
{
	private ArtikelDetailView view = new ArtikelDetailView(this);
	
	public void artikelDetailsZeigen(ArtikelModel artikel)
	{
		view.anzeigen(artikel);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String befehl = e.getActionCommand();
		System.out.println(befehl);
	}

}
