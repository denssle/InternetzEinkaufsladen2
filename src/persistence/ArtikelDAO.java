package persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import model.ArtikelModel;


public class ArtikelDAO
{
	//private String pfad = "/Users/admin/Dropbox/FH/aktikelSpeicherOrt2.txt";
	//private File artikelSpeicherOrt = new File(pfad);
	private Map<UUID, ArtikelModel> alleArtikel = alteArtikelAuslesen();
	
	private Map<UUID, ArtikelModel> alteArtikelAuslesen()
	{
		validiereSpeicher();
		
		Map<UUID, ArtikelModel> ausgeleseneArtikel = new HashMap<UUID, ArtikelModel>();
		/*
		try
		{
			FileInputStream fs = new FileInputStream(pfad);
			ObjectInputStream is = new ObjectInputStream(fs);
			ausgeleseneArtikel = (Map<Integer, ArtikelModel>) is.readObject();
			is.close();
		}
		catch (IOException | ClassNotFoundException e)
		{
			System.out.println("Datei konnte nicht gelesen werden.");
			ausgeleseneArtikel = new HashMap<Integer, ArtikelModel>();
		}
		System.out.println(ausgeleseneArtikel.size());
		*/
		return ausgeleseneArtikel; 
	}

	public void speichern(ArtikelModel zuSpeichernderArtikel)
	{
		validiereSpeicher();
		
		alleArtikel.put(zuSpeichernderArtikel.getArtikelId(), zuSpeichernderArtikel);
		/*
		FileOutputStream fs = new FileOutputStream(pfad);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		System.out.println("Datei wird beschrieben.");
		os.writeObject(alleArtikel);
		System.out.println("os wird geschlossen!");
		os.close();
		*/
		System.out.println(zuSpeichernderArtikel.getName() + " wurde gespeichert.\n");
	}
	
	private void validiereSpeicher()
	{
		System.out.println("Artikelspeichervalidierung gestartet!");
		/*
		if(!artikelSpeicherOrt.exists())
        {
			System.out.println("Datei nicht vorhanden.");
            try
            {
                boolean wurdeErstellt = artikelSpeicherOrt.createNewFile();
                if(wurdeErstellt)
                {
                    System.out.println("Neue Datei erstellt.\nValidierung erfolgreich abgeschlossen!");
                }
                else
                {
                    System.out.println("Datei konnte nicht erstellt werden!");
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
		else
		{
			System.out.println("Datei gefunden!\nValidierung erfolgreich abgeschlossen!");
		}
		*/
	}
	
	public Map<UUID, ArtikelModel> getAlleArtikel()
	{
		return alleArtikel;
	}
	
	public int artikelAnzahl()
	{
		return alleArtikel.size();
	}
	
	public ArtikelModel getArtikel(String artikelNr)
	{
		System.out.println(artikelNr);
		UUID artikelNrUUID = UUID.fromString(artikelNr);
		return alleArtikel.get(artikelNrUUID);
		
	}
	public boolean artikelExists(String artikelNr)
	{
		UUID artikelNrUUID = UUID.fromString(artikelNr);
		return alleArtikel.containsKey(artikelNrUUID);
	}
}
