package view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ArtikelModel;
import statics.Statics;

public class WarenkorbView extends JFrame
{	
	JPanel artikelLeiste = new JPanel();
	
	public WarenkorbView(ActionListener warenkorbController)
	{
		this.setLayout(new FlowLayout());	
		this.setTitle("Einkaufswagen");
		this.setSize(700,700);
		this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		this.setLocation(Statics.loc_right, Statics.loc_down);
		
		this.add(reiterLeisteErstellen());
		this.add(artikelLeiste);
	}
	
	private JPanel reiterLeisteErstellen()
	{
		JPanel reiterLeiste = new JPanel();
		reiterLeiste.setLayout(new GridLayout(1,3));
		reiterLeiste.add(new JLabel("Artikel Nr.:"));
		reiterLeiste.add(new JLabel("Artikel Name:"));
		reiterLeiste.add(new JLabel("   "));
		
		return reiterLeiste;
	}

	public void anzeigen()
	{
		this.setVisible(true);
		this.validate();
	}

	public void addArtikel(Map<Integer, ArtikelModel> aktuellerInhalt)
	{
		artikelLeiste.removeAll();
		artikelLeiste.setLayout(new FlowLayout());
		
		Iterator iterator = aktuellerInhalt.entrySet().iterator();
		while(iterator.hasNext())
		{
			JPanel zeile = new JPanel();
			zeile.setLayout(new GridLayout(1,3));
			Map.Entry pairs = (Map.Entry)iterator.next();
	        String id_key = pairs.getKey().toString();
	        ArtikelModel value = (ArtikelModel) pairs.getValue();
	        
			System.out.println("Aktueller Warenkorb"+value.getName());

	        zeile.add(new JLabel("id key"));
	        zeile.add(new JLabel(value.getName()));
	        
	        JButton button = new JButton("Entfernen");
	        button.setName(id_key);
	        zeile.add(button);
	        
	        artikelLeiste.add(zeile);
		}
		artikelLeiste.validate();
	}
}
