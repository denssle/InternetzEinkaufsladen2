package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
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
	private ArrayList<ArtikelModel[]> listeAllerSeiten;
	private ArtikelModel[] aktuelleSeiteArray;
	private ListIterator<ArtikelModel[]> listIterator;
	private int aktuelleSeitenzahl;
	
	public ShopView(ActionListener shopController, Map<UUID, ArtikelModel> map)
	{
		this.shopController = shopController;
		this.listeAllerSeiten = new ArrayList<ArtikelModel[]>();
		this.aktuelleSeitenzahl = 1;
		
		this.setTitle("Einkaufen");
		this.setLayout(new BorderLayout());		
		this.setSize(700,700);
		this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		this.setLocation(Statics.loc_left, Statics.loc_down);

		this.add(artikel_liste_leiste, BorderLayout.NORTH);
		
		artikelMapInSeitenMapUmwandeln(map);
	}
	
	private void updateAngezeigteArikel()
	{
		artikel_liste_leiste.removeAll();
		
		// length+1 ist die Zeilenanzahl plus die Reiterzeile, gewünscht sind drei Spalten. 
		artikel_liste_leiste.setLayout(new GridLayout(aktuelleSeiteArray.length+1, 3));
		artikel_liste_leiste.add(new JLabel("Artikelnummer: "));
		artikel_liste_leiste.add(new JLabel("Artikel: "));
		artikel_liste_leiste.add(new JLabel("Details: "));
		
		
		for(Integer i = 0; i < aktuelleSeiteArray.length; i++)
		{	
			Integer z = i +1;
			//System.out.println("Anzuzeigender Artikel Nr.: "+z+" von "+aktuelleSeiteArray.length+" ist "+aktuelleSeiteArray[i].getName());
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
		int maxSeiten = listeAllerSeiten.size();
		buttonLeiste.add(new JLabel(aktuelleSeitenzahl +" / "+maxSeiten));
		buttonLeiste.add(nachsteSeiteButton);
		
		return buttonLeiste;
	}

	public void setArtikelMap(Map<UUID, ArtikelModel> dieArtikel)
	{
		artikelMapInSeitenMapUmwandeln(dieArtikel);
	}
	
	//Ca. 20 Artikel pro Seite; dazu Reiter und Buttons für Seitenwechsel. 
	//Dazu soll die große Map mit x Artikeln in kleinere Maps mit je 20 Artikel umgewandelt werden.
	private void artikelMapInSeitenMapUmwandeln(Map<UUID, ArtikelModel> map)
	{
		Map<UUID, ArtikelModel> artikelMap = new HashMap<UUID ,ArtikelModel>(map);
		System.out.println(artikelMap.hashCode()+ " VS " +map.hashCode());
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
				ArtikelModel artikelModel = artikelMap.remove(artikelMap.keySet().iterator().next());
				seitenInhalt[j]= artikelModel;
				System.out.println("I: "+i+" J: "+j+" Aktuell in Umwandlung"+artikelModel.getName());
			}
			listeAllerSeiten.add(seitenInhalt);
		}
		aktuelleSeiteArray = listeAllerSeiten.get(0);
		listIterator = listeAllerSeiten.listIterator(0);
	}

	public void anzeigen()
	{
		this.setVisible(true);
		updateAngezeigteArikel();
	}
	
	public void naechsteSeite()
	{
		System.out.println("previousIndex: "+listIterator.previousIndex()+" nextIndex, aktuelle SZ: "+listIterator.nextIndex()+" Seitenwechsel: "+listIterator.hasNext());
		if(listIterator.hasNext())
		{
			aktuelleSeitenzahl = listIterator.nextIndex()+1;
			aktuelleSeiteArray = (ArtikelModel[]) listIterator.next();
			updateAngezeigteArikel();
		}
	}
	
	public void vorherigeSeite()
	{
		System.out.println("previousIndex, aktuelle SZ: "+listIterator.previousIndex()+" nextIndex: "+listIterator.nextIndex()+" Seitenwechsel: "+listIterator.hasNext());
		if(listIterator.hasPrevious())
		{
			aktuelleSeitenzahl = listIterator.previousIndex();
			aktuelleSeiteArray = listIterator.previous();
			updateAngezeigteArikel();
		}
	}
}