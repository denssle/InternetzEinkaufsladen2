package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import view.WarenkorbView;

public class WarenkorbModel extends Observable
{
    private Map<ArtikelModel, Integer> artikelMap;

    public WarenkorbModel(WarenkorbView view)
    {
        this.addObserver(view);
        artikelMap = new HashMap<ArtikelModel, Integer>();
    }

    public Map<ArtikelModel, Integer> getArtikelMap()
    {
        return artikelMap;
    }

    public void addArtikel(ArtikelModel artikelModel, Integer number)
    {
        this.artikelMap.put(artikelModel, number);
        this.setChanged();
        this.notifyObservers();
    }

    public void removeArtikel(ArtikelModel artikel)
    {
        this.artikelMap.remove(artikel);
        this.setChanged();
        this.notifyObservers();
    }
    
    public boolean existiertInWarenkorb(ArtikelModel artikelModel)
    {
    	if(artikelMap.containsKey(artikelModel))
    	{
    		return true;
    	}
    	return false;
    }
    
    public ArtikelModel getArtikel(String uuid)
    {
        for (Map.Entry<ArtikelModel, Integer> entry : this.artikelMap.entrySet())
        {
            if (entry.getKey().getArtikelId().toString().equals(uuid))
                return entry.getKey();
        }
        return null;
    }

	public void erhoeheAnzahl(ArtikelModel aktuellerArtikel) 
	{
		int key = artikelMap.get(aktuellerArtikel);
		key ++;
		addArtikel(aktuellerArtikel, key);
	}
}
