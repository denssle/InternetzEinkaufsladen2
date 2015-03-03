package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

@SuppressWarnings("serial")
public class WarenkorbView extends JFrame implements Observer
{	
	private JPanel artikelPanel;
	private JPanel summenPanel;
	private JPanel reiterPanel;
	private JPanel subArtikelPanel;
    private WarenkorbController controller;
	
	public WarenkorbView(WarenkorbController controller)
	{
		this.artikelPanel = new JPanel();
		this.summenPanel = new JPanel();
		this.reiterPanel = new JPanel();
		this.subArtikelPanel = new JPanel();
		
        this.controller = controller;
		this.setLayout(new BorderLayout());	
		this.setTitle("Einkaufswagen");
		this.setSize(700,700);
		this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		this.setLocation(Statics.loc_right, Statics.loc_down);
		
		this.add(reiterPanel, BorderLayout.PAGE_START);
		this.add(artikelPanel, BorderLayout.CENTER);//bei SOUTH kommnen die Artikel von unten :)
		this.add(summenPanel, BorderLayout.PAGE_END);
	}

	private void addAndUpdateSumme(double summe)
	{
		summenPanel.removeAll();
		summenPanel.setLayout(new FlowLayout());
		summenPanel.add(new JLabel("Aktuelle Summe: "+summe+" Euro"));
	}
	
	private void addReiter()
	{
		reiterPanel.removeAll();
		reiterPanel.setLayout(new GridLayout(1,5));
		reiterPanel.add(new JLabel("Artikel Nr.:"));
		reiterPanel.add(new JLabel("Artikel Name:"));
		reiterPanel.add(new JLabel("Preis:"));
		reiterPanel.add(new JLabel("Anzahl:"));
		reiterPanel.add(new JLabel("Entfernen?:"));
	}
	
	public void anzeigen()
	{
		this.addReiter();
		this.addAndUpdateSumme(0);
		this.setVisible(true);
		this.validate();
	}

    @Override
    public void update(Observable o, Object arg)
    {
        WarenkorbModel warenkorbModel = (WarenkorbModel) o;

		int artikelanzahl = 0;
		double summe = 0;
		artikelPanel.removeAll();
		artikelPanel.setLayout(new BorderLayout());
		artikelPanel.add(subArtikelPanel, BorderLayout.PAGE_START);
		subArtikelPanel.removeAll();
		subArtikelPanel.setLayout(new GridLayout(warenkorbModel.getArtikelMap().size(),5));

		System.out.println("Im Warenkorb befinden sich: ");
		Iterator<Entry<ArtikelModel, Integer>> iterator = warenkorbModel.getArtikelMap().entrySet().iterator();
		
		while(iterator.hasNext())
		{	
			Map.Entry<ArtikelModel, Integer> pairs = iterator.next();
	        ArtikelModel artikelModel = (ArtikelModel) pairs.getKey();
	        Integer anzahl = (Integer) pairs.getValue();
			System.out.println(artikelModel.getName());
			
			artikelanzahl++;
			subArtikelPanel.add(new JLabel(artikelanzahl+". Artikel"));
			subArtikelPanel.add(new JLabel(artikelModel.getName()));
			subArtikelPanel.add(new JLabel(artikelModel.getPreis() + "Euro"));
			subArtikelPanel.add(new JLabel(" "+anzahl));
			summe = berechneSumme(summe, artikelModel.getPreis()*anzahl);
	        JButton button = new JButton("Entfernen");
	        button.setName(artikelModel.getArtikelId().toString());
	        button.addActionListener(controller);
	        
	        subArtikelPanel.add(button);
	        System.out.println("Warenkorbsumme: "+summe);
		}
		System.out.println("Warenkorb Ende. \n");
		addAndUpdateSumme(summe);
		this.validate();
	}

	private double berechneSumme(double summe, double preis)
	{
		summe += preis;
		summe = Math.round(100.0 *summe)/ 100.0;
		return summe;
	}
}
