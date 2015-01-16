package model;

import view.WarenkorbView;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class WarenkorbModel extends Observable
{
    private Map<ArtikelModel, Integer> artikelMap = new HashMap<ArtikelModel, Integer>();

    public WarenkorbModel(WarenkorbView view) {
        this.addObserver(view);
    }

    public Map<ArtikelModel, Integer> getArtikelMap() {
        return artikelMap;
    }

    public void addArtikel(ArtikelModel artikelModel, Integer number) {
        this.artikelMap.put(artikelModel, number);
        this.setChanged();
        this.notifyObservers();
    }

    public void removeArtikel(ArtikelModel artikel) {
        this.artikelMap.remove(artikel);
        this.setChanged();
        this.notifyObservers();
    }

    public ArtikelModel getArtikel(String uuid) {
        for (Map.Entry<ArtikelModel, Integer> entry : this.artikelMap.entrySet()) {
            if (entry.getKey().getArtikelId().equals(uuid))
                return entry.getKey();
        }
        return null;
    }
}
