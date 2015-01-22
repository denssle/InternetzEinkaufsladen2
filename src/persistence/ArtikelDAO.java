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

import statics.Statics;
import model.ArtikelModel;


public class ArtikelDAO
{
	private String pfad;
	private File artikelSpeicherOrt;
	private Map<UUID, ArtikelModel> alleArtikel;
	
	public ArtikelDAO()
	{
		pfad = Statics.path;
		artikelSpeicherOrt = new File(pfad);
		alleArtikel = alteArtikelAuslesen();
	}
	
	@SuppressWarnings("unchecked")
	private Map<UUID, ArtikelModel> alteArtikelAuslesen()
	{
		validiereSpeicher();
		
		Map<UUID, ArtikelModel> ausgeleseneArtikel = new HashMap<UUID, ArtikelModel>();
		
		try
		{
			System.out.println("Beginne Lesevorgang. ");
			FileInputStream fs = new FileInputStream(pfad);
			ObjectInputStream is = new ObjectInputStream(fs);
			System.out.println("FileInput und ObjectInput melden Bereitschaft. ");
			ausgeleseneArtikel = (Map<UUID, ArtikelModel>) is.readObject();
			System.out.println("Lesevorgang abgeschlossen. \nArtikeldaten wurden geladen. \nFileInput und ObjectInput werden geschlossen. \nLesevorgang beendet.\n");
			is.close();
			fs.close();
		}
		catch(java.io.EOFException e2)
		{
			//Diese Exception wird geworfen wenn die Speicherdatei leer ist. 
			//Sie muss nicht weiter behandelt werden, da sie gefixt wird sobald ein Artikel gespeichert wird
			System.out.println("EOFException");
		}
		catch (IOException | ClassNotFoundException e)
		{
			System.out.println("Fehler! \nDatei konnte nicht gelesen werden.");
			e.printStackTrace();
			ausgeleseneArtikel = new HashMap<UUID, ArtikelModel>();
		}
		
		return ausgeleseneArtikel; 
	}

	public void speichern(ArtikelModel zuSpeichernderArtikel)
	{
		validiereSpeicher();
		
		try
		{
			System.out.println("Beginne Speichervorgang. \nEverything not saved will be lost.");
			FileOutputStream fs = new FileOutputStream(pfad);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			System.out.println("Datei wird beschrieben.");
			os.writeObject(alleArtikel);
			System.out.println("os wird geschlossen!");
			os.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		alleArtikel.put(zuSpeichernderArtikel.getArtikelId(), zuSpeichernderArtikel);
		System.out.println(zuSpeichernderArtikel.getName() + " wurde gespeichert. \nAktuell befinden sich "+alleArtikel.size()+" Arikel im Speicher.");
	}
	
	private void validiereSpeicher()
	{
		System.out.println("\nArtikelspeichervalidierung gestartet!");
		
		if(!artikelSpeicherOrt.exists())
        {
			System.out.println("Datei nicht vorhanden.");
			neueDateiAnlegen();
        }
		else
		{
			System.out.println("Datei gefunden.");
		}
		rechteTesten();
		System.out.println("Artikelspeichervalidierung abgeschlossen!\n");
	}
	private void rechteTesten()
	{
		if(artikelSpeicherOrt.canRead())
		{
			System.out.println("Leserechte vorhanden. ");
		}
		else
		{
			System.out.println("Leserechte nicht vorhanden. .");
		}
		
		if(artikelSpeicherOrt.canWrite())
		{
			System.out.println("Schreibrechte gegeben. ");
		}
		else
		{
			System.out.println("Schreibrechte nicht gegeben. ");
		}
		
		if(artikelSpeicherOrt.canExecute())
		{
			System.out.println("Datei exekutierbar.");
		}
		else
		{
			System.out.println("Datei nicht exekutierbar.");
		}
	}

	private void neueDateiAnlegen()
	{
		try
        {
            boolean wurdeErstellt = artikelSpeicherOrt.createNewFile();
            if(wurdeErstellt)
            {
                System.out.println("Neue Datei erstellt.");
            }
            else
            {
                System.out.println("Datei konnte nicht erstellt werden!");
            }
        }
        catch (IOException ex)
        {
        	System.out.println("Fehler beim erstellen von neuer Datei. ");
            ex.printStackTrace();
        }
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
