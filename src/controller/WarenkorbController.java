package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.ArtikelModel;
import model.WarenkorbModel;
import view.WarenkorbView;

public class WarenkorbController implements ActionListener
{
	private WarenkorbView warenkorbV;
    private WarenkorbModel warenkorbModel;
	private static int id = 0;


    public WarenkorbController() {
        this.warenkorbV = new WarenkorbView(this);
        this.warenkorbModel =  new WarenkorbModel(warenkorbV);
    }

    public void anzeigen()
	{
		warenkorbV.anzeigen();
	}

	public void addArtikel(ArtikelModel aktuellerArtikel)
	{
        warenkorbModel.addArtikel(aktuellerArtikel, 1);
		System.out.println("Warenkorb hat folgenden Inhalt: " + warenkorbModel.getArtikelMap().keySet());
	}

	public void removeArtikel(ArtikelModel artikel)
	{
		System.out.println("Zu entfernender Artikel: " + artikel.getName());
		warenkorbModel.removeArtikel(artikel);
	}

	public void actionPerformed(ActionEvent e)
	{
		JButton pressedButton = (JButton) e.getSource();
		String uuid = pressedButton.getName();
		String befehl = e.getActionCommand();
		
		System.out.println("Warenkorb; uuid:"+uuid+" befehl: "+befehl);

		removeArtikel(warenkorbModel.getArtikel(uuid));
	}

	
}
