package model;

import java.io.Serializable;
import java.util.UUID;

@SuppressWarnings("serial")
public class ArtikelModel implements Serializable
{
	private UUID artikelId;
	private String name;
	private double preis;
	private String beschreibung;
	private String kategorie;
	
	public ArtikelModel()
	{
		this.artikelId = UUID.randomUUID();
	}
	public UUID getArtikelId() {
		return artikelId;
	}
	public String getName() {
		return name;
	}
	public double getPreis() {
		return preis;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public String getKategorie() {
		return kategorie;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

}
