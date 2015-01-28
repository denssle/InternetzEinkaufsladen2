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
import java.util.UUID;

import statics.Statics;
import model.BenutzerModel;

public class BenutzerDAO
{
	private String zielpfad;
	private File benutzerSpeicherOrt;
	private Map<UUID, BenutzerModel> alleBenutzerMap;
	
	public BenutzerDAO()
	{
		zielpfad = Statics.userPath;
		benutzerSpeicherOrt = new File(zielpfad);
		alleBenutzerMap = bestehendeBenutzerdateiAuslesen();
	}

	private Map<UUID, BenutzerModel> bestehendeBenutzerdateiAuslesen()
	{
		validiereSpeicherDatei();
		
		Map<UUID, BenutzerModel> ausgeleseneBenutzerMap= new HashMap<UUID, BenutzerModel>();
		
		try
		{
			System.out.println("Beginne Lesevorgang. ");
			FileInputStream fs = new FileInputStream(zielpfad);
			ObjectInputStream is = new ObjectInputStream(fs);
			System.out.println("FileInput und ObjectInput melden Bereitschaft. ");
			ausgeleseneBenutzerMap = (Map<UUID, BenutzerModel>) is.readObject();
			System.out.println("Lesevorgang abgeschlossen. \nBenutzerdaten wurden geladen. \nFileInput und ObjectInput werden geschlossen. \nLesevorgang beendet.\n");
			is.close();
			fs.close();
		}
		catch(EOFException e2)
		{
			//Diese Exception wird geworfen wenn die Speicherdatei leer ist. 
			//Sie muss nicht weiter behandelt werden, da sie gefixt wird sobald ein Benutzer gespeichert wird
			e2.printStackTrace();
			ausgeleseneBenutzerMap = new HashMap<UUID, BenutzerModel>();
		}
		catch (IOException | ClassNotFoundException e)
		{
			System.out.println("Fehler! \nDatei konnte nicht gelesen werden.");
			e.printStackTrace();
			ausgeleseneBenutzerMap = new HashMap<UUID, BenutzerModel>();
		}
		
		return ausgeleseneBenutzerMap;
	}
	
	public void benutzerSpeichern(BenutzerModel neuerBenutzer)
	{
		validiereSpeicherDatei();
		alleBenutzerMap.put(neuerBenutzer.getId(), neuerBenutzer);

		try
		{
			System.out.println("Beginne Speichervorgang. \nEverything not saved will be lost.");
			FileOutputStream fs = new FileOutputStream(zielpfad);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			System.out.println("Datei wird beschrieben.");
			os.writeObject(alleBenutzerMap);
			System.out.println("os wird geschlossen!");
			os.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println(neuerBenutzer.getName() + " wurde gespeichert. \nAktuell sind "+alleBenutzerMap.size()+" Benutzer gespeichert.");
	}
	
	private void validiereSpeicherDatei()
	{
		System.out.println("\nBenutzerspeichervalidierung gestartet!");
		
		if(!benutzerSpeicherOrt.exists())
        {
			System.out.println("Datei nicht vorhanden.");
			neueDateiAnlegen();
        }
		else
		{
			System.out.println("Datei gefunden.");
		}
		statusDateirechte();
		System.out.println("Benutzerspeichervalidierung abgeschlossen!\n");
	}
	private void statusDateirechte()
	{
		if(benutzerSpeicherOrt.canRead())
		{
			System.out.println("Leserechte vorhanden. ");
		}
		else
		{
			System.out.println("Leserechte nicht vorhanden. .");
		}
		
		if(benutzerSpeicherOrt.canWrite())
		{
			System.out.println("Schreibrechte gegeben. ");
		}
		else
		{
			System.out.println("Schreibrechte nicht gegeben. ");
		}
		
		if(benutzerSpeicherOrt.canExecute())
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
            if(benutzerSpeicherOrt.createNewFile())
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
	
	public Map<UUID, BenutzerModel> getAlleBenutzer()
	{
		return alleBenutzerMap;
	}
	public BenutzerModel benutzerVorhanden(String email, String password)
	{
		System.out.println("Beginne Suche nach Benutzer nach Email: "+email);
		for(BenutzerModel benutzerModel : alleBenutzerMap.values())
		{
			System.out.println("Email im Check: "+ benutzerModel.getEmail());
			if(benutzerModel.getEmail().equals(email))
			{
				System.out.println("Benutzer "+ benutzerModel.getName() + " passt zur Email.");
				if(benutzerModel.getPasswort().equals(password))
				{
					System.out.println("Passwort korrekt.");
					return benutzerModel;
				}
			}
		}
		
		return null;
	}
}
