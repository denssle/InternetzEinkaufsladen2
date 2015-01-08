package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ArtikelModel;
import statics.Statics;

public class ShopView extends JFrame
{	
	private Map<Integer, ArtikelModel> artikelMap;
	private ActionListener shopController;
	public ShopView(ActionListener shopController, Map<Integer, ArtikelModel> map)
	{
		this.shopController = shopController;
		artikelMap = map;
		
		this.setTitle("Einkaufen");
		this.setLayout(new FlowLayout());		
		this.setSize(700,700);
		this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		this.setLocation(Statics.loc_left, Statics.loc_down);

		JPanel reiter_zeile = new JPanel();
		reiter_zeile.setLayout(new GridLayout(1, 3));
		reiter_zeile.add(new JLabel("Artikelnummer: "));
		reiter_zeile.add(new JLabel("Artikel: "));
		reiter_zeile.add(new JLabel("Details: "));
		
		
		this.add(reiter_zeile);
		this.add(artikel_liste());
	}
	private JPanel artikel_liste()
	{
		JPanel artikel_liste_leiste = new JPanel();
		artikel_liste_leiste.setLayout(new GridLayout(artikelMap.size(), 3));
		
		Iterator iterator = artikelMap.entrySet().iterator();
		while(iterator.hasNext())
		{
			Map.Entry pairs = (Map.Entry)iterator.next();
	        String key = pairs.getKey().toString();
	        ArtikelModel value = (ArtikelModel) pairs.getValue();
	        artikel_liste_leiste.add(new JLabel(key));
	        artikel_liste_leiste.add(new JLabel(value.getName()));
	        JButton details = new JButton("Details");
	        details.setName(key);
	        details.addActionListener(shopController);
	        
	        artikel_liste_leiste.add(details);
		}
		return artikel_liste_leiste;
	}
	public void setArtikelMap(Map<Integer, ArtikelModel> dieArtikel)
	{
		artikelMap = dieArtikel;
	}
	
	public void anzeigen()
	{
		this.setVisible(true);
	}

	public boolean isActiv()
	{
		return this.isDisplayable();
	}
}