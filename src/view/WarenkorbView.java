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
	JPanel artikelLeiste = new JPanel();
	
	public WarenkorbView()
	{
		this.setLayout(new BorderLayout());	
		this.setTitle("Einkaufswagen");
		this.setSize(700,700);
		this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		this.setLocation(Statics.loc_right, Statics.loc_down);
		
		this.add(reiterLeisteErstellen(), BorderLayout.NORTH);
		this.add(artikelLeiste, BorderLayout.SOUTH);//bei SOUTH kommnen die Artikel von unten
	}
	
	private JPanel reiterLeisteErstellen()
	{
		JPanel reiterLeiste = new JPanel();
		reiterLeiste.setLayout(new GridLayout(1,3));
		reiterLeiste.add(new JLabel("Artikel Nr.:"));
		reiterLeiste.add(new JLabel("Artikel Name:"));
		reiterLeiste.add(new JLabel("Artikel entfernen?:"));
		return reiterLeiste;
	}

	public void anzeigen()
	{
		this.setVisible(true);
		this.validate();
	}

	public void addArtikel(Map<Integer, ArtikelModel> aktuellerInhalt, ActionListener warenkorbController)
	{
		artikelLeiste.removeAll();
		artikelLeiste.setLayout(new GridLayout(aktuellerInhalt.size(),3));
		System.out.println("Im Warenkorb befinden sich: ");
		Iterator<Entry<Integer, ArtikelModel>> iterator = aktuellerInhalt.entrySet().iterator();
		while(iterator.hasNext())
		{	
			Map.Entry pairs = (Map.Entry)iterator.next();
	        String id_key = pairs.getKey().toString();
	        ArtikelModel value = (ArtikelModel) pairs.getValue();
	        
			System.out.println(value.getName());
			
			artikelLeiste.add(new JLabel(id_key));
			artikelLeiste.add(new JLabel(value.getName()));
	        
	        JButton button = new JButton("Entfernen");
	        button.setName(id_key);
	        button.addActionListener(warenkorbController);
	        
	        artikelLeiste.add(button);
		}
		System.out.println("Warenkorb Ende. \n");
		this.validate();
	}
}
