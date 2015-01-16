package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.WarenkorbController;
import model.ArtikelModel;
import statics.Statics;

public class WarenkorbView extends JFrame
{	
	private JPanel artikelLeiste = new JPanel();
	private double summe = 0;
	
	public WarenkorbView()
	{
		this.setLayout(new BorderLayout());	
		this.setTitle("Einkaufswagen");
		this.setSize(700,700);
		this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		this.setLocation(Statics.loc_right, Statics.loc_down);
		
		this.add(artikelLeiste, BorderLayout.NORTH);//bei SOUTH kommnen die Artikel von unten :)
		this.add(summeAnhengen(), BorderLayout.SOUTH);
	}

	private JPanel summeAnhengen() {
		JPanel summenPanel = new JPanel();
		summenPanel.add(new JLabel("Summe:"+summe));
		return summenPanel;
	}

	public void anzeigen()
	{
		this.setVisible(true);
		this.validate();
	}

	public void addArtikel(Map<Integer, ArtikelModel> aktuellerInhalt, ActionListener warenkorbController)
	{
		int artikelanzahl = 0;
		summe = 0;
		artikelLeiste.removeAll();
		artikelLeiste.setLayout(new GridLayout(aktuellerInhalt.size()+1,4));
		
		artikelLeiste.add(new JLabel("Artikel Nr.:"));
		artikelLeiste.add(new JLabel("Artikel Name:"));
		artikelLeiste.add(new JLabel("Preis:"));
		artikelLeiste.add(new JLabel("Entfernen?:"));
		
		System.out.println("Im Warenkorb befinden sich: ");
		Iterator<Entry<Integer, ArtikelModel>> iterator = aktuellerInhalt.entrySet().iterator();
		while(iterator.hasNext())
		{	
			Map.Entry pairs = (Map.Entry)iterator.next();
	        String id_key = pairs.getKey().toString();
	        ArtikelModel value = (ArtikelModel) pairs.getValue();
	        
			System.out.println(value.getName());
			
			artikelanzahl++;
			artikelLeiste.add(new JLabel(artikelanzahl+". Artikel"));
			artikelLeiste.add(new JLabel(value.getName()));
			artikelLeiste.add(new JLabel(value.getPreis() + "Euro"));
			summe += value.getPreis();
	        JButton button = new JButton("Entfernen");
	        button.setName(id_key);
	        button.addActionListener(warenkorbController);
	        
	        artikelLeiste.add(button);
	        System.out.println("Warenkorbsumme: "+summe);
		}
		System.out.println("Warenkorb Ende. \n");
		this.validate();
	}
}
