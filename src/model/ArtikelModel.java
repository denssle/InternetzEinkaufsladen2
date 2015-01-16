package model;

import java.util.Random;
import java.util.UUID;

public class ArtikelModel
{
	private UUID artikelId;
	private String name;
	private double preis;
	private String beschreibung;
	private String kategorie;
	
	public ArtikelModel()
	{
		artikelId = UUID.randomUUID();
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
