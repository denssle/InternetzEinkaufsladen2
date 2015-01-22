package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.WarenkorbController;
import model.ArtikelModel;
import model.WarenkorbModel;
import statics.Statics;

public class WarenkorbView extends JFrame implements Observer
{	
	private JPanel artikelLeiste;
	private JPanel summenPanel;
	private double summe;

    private WarenkorbController controller;
	
	public WarenkorbView(WarenkorbController controller)
	{
		artikelLeiste = new JPanel();
		summenPanel = new JPanel();
		summe = 0;
		
        this.controller = controller;
		this.setLayout(new BorderLayout());	
		this.setTitle("Einkaufswagen");
		this.setSize(700,700);
		this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		this.setLocation(Statics.loc_right, Statics.loc_down);
		
		this.add(artikelLeiste, BorderLayout.NORTH);//bei SOUTH kommnen die Artikel von unten :)
		this.add(summenPanel, BorderLayout.SOUTH);
	}

	private void updateSumme()
	{
		summenPanel.removeAll();
		summenPanel.add(new JLabel("Aktuelle Summe: "+summe+" Euro"));
	}

	public void anzeigen()
	{
		this.setVisible(true);
		this.validate();
	}

    @Override
    public void update(Observable o, Object arg) {

        WarenkorbModel warenkorbModel = (WarenkorbModel) o;

		int artikelanzahl = 0;
		summe = 0;
		artikelLeiste.removeAll();
		artikelLeiste.setLayout(new GridLayout(warenkorbModel.getArtikelMap().size()+1,5));
		
		artikelLeiste.add(new JLabel("Artikel Nr.:"));
		artikelLeiste.add(new JLabel("Artikel Name:"));
		artikelLeiste.add(new JLabel("Preis:"));
		artikelLeiste.add(new JLabel("Anzahl:"));
		artikelLeiste.add(new JLabel("Entfernen?:"));
		
		System.out.println("Im Warenkorb befinden sich: ");
		Iterator<Entry<ArtikelModel, Integer>> iterator = warenkorbModel.getArtikelMap().entrySet().iterator();
		
		while(iterator.hasNext())
		{	
			Map.Entry pairs = (Map.Entry)iterator.next();
	        ArtikelModel artikelModel = (ArtikelModel) pairs.getKey();
	        Integer anzahl = (Integer) pairs.getValue();
			System.out.println(artikelModel.getName());
			
			artikelanzahl++;
			artikelLeiste.add(new JLabel(artikelanzahl+". Artikel"));
			artikelLeiste.add(new JLabel(artikelModel.getName()));
			artikelLeiste.add(new JLabel(artikelModel.getPreis() + "Euro"));
			artikelLeiste.add(new JLabel(" "+anzahl));
			setSumme(artikelModel.getPreis()*anzahl);
	        JButton button = new JButton("Entfernen");
	        button.setName(artikelModel.getArtikelId().toString());
	        button.addActionListener(controller);
	        
	        artikelLeiste.add(button);
	        System.out.println("Warenkorbsumme: "+summe);
		}
		System.out.println("Warenkorb Ende. \n");
		updateSumme();
		this.validate();
	}

	private void setSumme(double preis)
	{
		summe += preis;
		summe = Math.round(100.0 *summe)/ 100.0;
	}
}
