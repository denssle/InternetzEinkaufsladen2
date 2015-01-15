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
	private JPanel artikel_liste_leiste = new JPanel();
	
	public ShopView(ActionListener shopController, Map<Integer, ArtikelModel> map)
	{
		this.shopController = shopController;
		artikelMap = map;
		
		this.setTitle("Einkaufen");
		this.setLayout(new FlowLayout());		
		this.setSize(700,700);
		this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		this.setLocation(Statics.loc_left, Statics.loc_down);

		this.add(artikel_liste_leiste);
	}
	
	private void artikel_liste_update()
	{
		artikel_liste_leiste.removeAll();
		
		artikel_liste_leiste.setLayout(new GridLayout(artikelMap.size()+1, 3));
		
		artikel_liste_leiste.add(new JLabel("Artikelnummer: "));
		artikel_liste_leiste.add(new JLabel("Artikel: "));
		artikel_liste_leiste.add(new JLabel("Details: "));
		
		Iterator iterator = artikelMap.entrySet().iterator();
		while(iterator.hasNext())
		{
			Map.Entry pairs = (Map.Entry)iterator.next();
	        String id_key = pairs.getKey().toString();
	        ArtikelModel value = (ArtikelModel) pairs.getValue();
	        artikel_liste_leiste.add(new JLabel(id_key));
	        artikel_liste_leiste.add(new JLabel(value.getName()));
	        JButton details = new JButton("Details");
	        details.setName(id_key);
	        details.addActionListener(shopController);
	        
	        artikel_liste_leiste.add(details);
		}
		artikel_liste_leiste.validate();
	}
	public void setArtikelMap(Map<Integer, ArtikelModel> dieArtikel)
	{
		artikelMap = dieArtikel;
	}
	
	public void anzeigen()
	{
		this.setVisible(true);
		artikel_liste_update();
	}
}