package model;

public class ArtikelModel
{
	private static int artikelNr;
	private int artikelId;
	private String name;
	private String preis;
	private String beschreibung;
	private String kategorie;
	
	public ArtikelModel()
	{
		artikelId = artikelNr++;
	}
	public int getArtikelId() {
		return artikelId;
	}
	public String getName() {
		return name;
	}
	public String getPreis() {
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
	public void setPreis(String preis) {
		this.preis = preis;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

}
