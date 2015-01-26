package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ArtikelModel;
import statics.Statics;

@SuppressWarnings("serial")
public class ShopView extends JFrame
{	
	private ActionListener shopController;
	private JPanel artikel_liste_leiste = new JPanel();
	private Map<UUID, ArtikelModel> artikelMap;
	private ArrayList<ArtikelModel[]> listeAllerSeiten;
	private ArtikelModel[] aktuelleSeiteArray;
	private Iterator<ArtikelModel[]> iterator;
	private int aktuelleSeitenzahl;
	
	public ShopView(ActionListener shopController, Map<UUID, ArtikelModel> map)
	{
		this.shopController = shopController;
		artikelMap = map;
		listeAllerSeiten = new ArrayList<ArtikelModel[]>();
		aktuelleSeitenzahl = 1;
		
		this.setTitle("Einkaufen");
		this.setLayout(new BorderLayout());		
		this.setSize(700,700);
		this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		this.setLocation(Statics.loc_left, Statics.loc_down);

		this.add(artikel_liste_leiste, BorderLayout.NORTH);
		
		artikelMapInSeitenMapUmwandeln();
	}
	
	private void updateAngezeigteArikel()
	{
		artikel_liste_leiste.removeAll();
		
		artikel_liste_leiste.setLayout(new GridLayout(aktuelleSeiteArray.length+1, 3));
		artikel_liste_leiste.add(new JLabel("Artikelnummer: "));
		artikel_liste_leiste.add(new JLabel("Artikel: "));
		artikel_liste_leiste.add(new JLabel("Details: "));
		
		
		for(Integer i = 0; i < aktuelleSeiteArray.length; i++)
		{	
			Integer z = i +1;
			System.out.println("Anzuzeigender Artikel Nr.: "+z+" von "+aktuelleSeiteArray.length+" ist "+aktuelleSeiteArray[i].getName());
	        artikel_liste_leiste.add(new JLabel(z.toString()));
	        artikel_liste_leiste.add(new JLabel(aktuelleSeiteArray[i].getName()));
	        
	        JButton details = new JButton("Details");
	        details.setName(aktuelleSeiteArray[i].getArtikelId().toString());
	        details.addActionListener(shopController);
	        
	        artikel_liste_leiste.add(details);
		}
		
		this.add(buttonLeiste(), BorderLayout.SOUTH);
		this.validate();
	}

	private JPanel buttonLeiste()
	{
		JPanel buttonLeiste = new JPanel();
		buttonLeiste.setLayout(new GridLayout(1,3));
		
		JButton zurueckButton = new JButton("<");
		zurueckButton.addActionListener(shopController);
		
		JButton nachsteSeiteButton = new JButton(">");
		nachsteSeiteButton.addActionListener(shopController);
		
		buttonLeiste.add(zurueckButton);
		int maxSeiten = listeAllerSeiten.size()+1;
		buttonLeiste.add(new JLabel(aktuelleSeitenzahl +" / "+maxSeiten));
		buttonLeiste.add(nachsteSeiteButton);
		
		return buttonLeiste;
	}
	public void setArtikelMap(Map<UUID, ArtikelModel> dieArtikel)
	{
		artikelMap = dieArtikel;
		artikelMapInSeitenMapUmwandeln();
	}
	
	//Ca. 20 Artikel pro Seite; dazu Reiter und Buttons für Seitenwechsel. 
	//Dazu soll die große Map mit x Artikeln in kleinere Maps mit je 20 Artikel umgewandelt werden.
	private void artikelMapInSeitenMapUmwandeln()
	{
		int notwendigeSeitenzahl = (artikelMap.size() / Statics.anzahlArtikelProSeite);
		System.out.println("Nötige Seitenzahl: " + notwendigeSeitenzahl);
		System.out.println("Größe Artikelmap: "+artikelMap.size());
			
		for(int i = 0; i <= notwendigeSeitenzahl; i++)
		{
			//Für den Fall das weniger als 20 Artikel angezeigt werden sollen, müssen spezielle Vorkehrungen getroffen werden. 
			//Um NullPointerExceptions zu vermeiden muss die Arraylänge angepasst werden sowie die Grenze für die forSchleife. 
			int grenze = Statics.anzahlArtikelProSeite;
			ArtikelModel[] seitenInhalt = new ArtikelModel[grenze];
			//Sollten weniger Artikel da sein, als anzahlArtikelProSeite vorsieht, wird es hier korrigiert. 
			if(artikelMap.size()< grenze)
			{
				grenze = artikelMap.size();
				seitenInhalt = new ArtikelModel[grenze];
			}
			for(int j = 0; j < grenze; j++)
			{
				ArtikelModel artikelModel = artikelMap.remove(artikelMap.keySet().toArray()[0]);
				seitenInhalt[j]= artikelModel;
				System.out.println("I: "+i+" J: "+j+" Aktuell in Umwandlung"+artikelModel.getName());
			}
			listeAllerSeiten.add(seitenInhalt);
		}
		aktuelleSeiteArray = listeAllerSeiten.get(0);
		iterator = listeAllerSeiten.iterator();
		for(int i = 0; i <= notwendigeSeitenzahl; i++)
		{
			System.out.println("Seite: "+i+" Länge: "+listeAllerSeiten.get(i).length+" Erster Artikel: "+listeAllerSeiten.get(i)[0]);
		}
	}
	public void anzeigen()
	{
		this.setVisible(true);
		updateAngezeigteArikel();
	}
	
	public void naechsteSeite()
	{
		if(iterator.hasNext())
		{
			aktuelleSeitenzahl++;
			aktuelleSeiteArray = (ArtikelModel[]) iterator.next();
			System.out.println(aktuelleSeiteArray);
			updateAngezeigteArikel();
		}
	}
	
	public void vorherigeSeite()
	{
		aktuelleSeitenzahl--;
		updateAngezeigteArikel();
	}
}