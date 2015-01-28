package persistence;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import model.ArtikelModel;
import statics.Statics;


public class ArtikelDAO
{
	private String zielpfad;
	private File artikelSpeicherOrt;
	private Map<UUID, ArtikelModel> alleArtikel;
	
	public ArtikelDAO()
	{
		this.zielpfad = Statics.itemPath;
		this.artikelSpeicherOrt = new File(zielpfad);
		this.alleArtikel = bestehendeArtikeldateiAuslesen();
	}
	
	@SuppressWarnings("unchecked")
	private Map<UUID, ArtikelModel> bestehendeArtikeldateiAuslesen()
	{
		validiereSpeicherDatei();
		
		Map<UUID, ArtikelModel> ausgeleseneArtikelMap = new HashMap<UUID, ArtikelModel>();
		
		try
		{
			System.out.println("Beginne Lesevorgang. ");
			FileInputStream fs = new FileInputStream(zielpfad);
			ObjectInputStream is = new ObjectInputStream(fs);
			System.out.println("FileInput und ObjectInput melden Bereitschaft. ");
			ausgeleseneArtikelMap = (Map<UUID, ArtikelModel>) is.readObject();
			System.out.println("Lesevorgang abgeschlossen. \nArtikeldaten wurden geladen. \nFileInput und ObjectInput werden geschlossen. \nLesevorgang beendet.\n");
			is.close();
			fs.close();
		}
		catch(EOFException e2)
		{
			//Diese Exception wird geworfen wenn die Speicherdatei leer ist. 
			//Sie muss nicht weiter behandelt werden, da sie gefixt wird sobald ein Artikel gespeichert wird
			e2.printStackTrace();
			ausgeleseneArtikelMap = new HashMap<UUID, ArtikelModel>();
		}
		catch (IOException | ClassNotFoundException e)
		{
			System.out.println("Fehler! \nDatei konnte nicht gelesen werden.");
			e.printStackTrace();
			ausgeleseneArtikelMap = new HashMap<UUID, ArtikelModel>();
		}
		
		return ausgeleseneArtikelMap; 
	}

	public void speichern(ArtikelModel zuSpeichernderArtikel)
	{
		validiereSpeicherDatei();
		alleArtikel.put(zuSpeichernderArtikel.getArtikelId(), zuSpeichernderArtikel);

		try
		{
			System.out.println("Beginne Speichervorgang. \nEverything not saved will be lost.");
			FileOutputStream fs = new FileOutputStream(zielpfad);
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
		System.out.println(zuSpeichernderArtikel.getName() + " wurde gespeichert. \nAktuell befinden sich "+alleArtikel.size()+" Arikel im Speicher.");
	}
	
	private void validiereSpeicherDatei()
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
		statusDateirechte();
		System.out.println("Artikelspeichervalidierung abgeschlossen!\n");
	}
	private void statusDateirechte()
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
            if(artikelSpeicherOrt.createNewFile())
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
		System.out.println("Suche nach Artikel Nr.: "+artikelNr);
		UUID artikelNrUUID = UUID.fromString(artikelNr);
		return alleArtikel.get(artikelNrUUID);
		
	}
	
	public boolean artikelExists(String artikelNr)
	{
		UUID artikelNrUUID = UUID.fromString(artikelNr);
		System.out.println("Artikel mit der UUDI: "+artikelNr+" wird gesucht."+" length: "+alleArtikel.size());
		
		for(UUID uuid : alleArtikel.keySet())
		{
			System.out.println(uuid+" VS "+artikelNrUUID);
			if(uuid.equals(artikelNrUUID))
			{
				return true;
			}
		}
		return false;
	}
}
