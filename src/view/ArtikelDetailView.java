package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ArtikelModel;
import statics.Statics;

@SuppressWarnings("serial")
public class ArtikelDetailView extends JFrame
{
	private JPanel struktur;
	
	public ArtikelDetailView(ActionListener artikelDetailController)
	{
		this.struktur = new JPanel();
		
		this.setLayout(new FlowLayout());		
		this.setSize(700,700);
		this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		this.setLocation(Statics.loc_left, Statics.loc_down);
		
		this.add(struktur);
		this.add(buttonMaker(artikelDetailController));
	}
	private JPanel buttonMaker(ActionListener artikelDetailController)
	{
		JPanel buttonPanel = new JPanel();
		
		JButton buybutton = new JButton("Kaufen");
		buybutton.addActionListener(artikelDetailController);
		
		JButton exitbutton = new JButton("Schliessen");
		exitbutton.addActionListener(artikelDetailController);
		
		buttonPanel.add(buybutton);
		buttonPanel.add(exitbutton);
		return buttonPanel;
	}
	private void strukturAnlegen(ArtikelModel anzuzeigenderArtikel)
	{
		struktur.removeAll();
		struktur.setLayout(new GridLayout(5,2));
		
		struktur.add(new JLabel("Name"));
		struktur.add(new JLabel(anzuzeigenderArtikel.getName()));
		
		struktur.add(new JLabel("Beschreibung"));
		struktur.add(new JLabel(anzuzeigenderArtikel.getBeschreibung()));
		
		struktur.add(new JLabel("Kategorie"));
		struktur.add(new JLabel(anzuzeigenderArtikel.getKategorie()));
		
		struktur.add(new JLabel("Preis"));
		struktur.add(new JLabel(anzuzeigenderArtikel.getPreis()+" Euro"));
	}
	public void anzeigen(ArtikelModel anzuzeigenderArtikel)
	{
		this.setVisible(true);
		this.setTitle(anzuzeigenderArtikel.getName());
		strukturAnlegen(anzuzeigenderArtikel);
		this.validate();
	}
	public void verstecken()
	{
		this.setVisible(false);
	}
}
