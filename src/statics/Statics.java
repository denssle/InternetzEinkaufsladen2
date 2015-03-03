package statics;

import java.io.File;

public class Statics
{
	private static String separator = File.separator;
	
	
    public static final String ANMELDEN = "Anmelden";

	public static final String[] buttonlabels_nav = 
		{
		"Anmelden", 
		"Einkaufen", 
		"Einkaufswagen", 
		"Profil", 
		"Registration"
	};
	public static final String[] benutzerlabels = {"Name", "Email", "Strasse", "Stadt", "Passwort"};
	public static final String ok = "Ok";
	public static final String ok2 = "Okay";
	public static final int loc_down = 180;
	public static final int loc_up = 0;
	public static final int loc_left = 0;
	public static final int loc_right = 710;
	
	public static final String itemPath = "/Users/admin/Dropbox/FH/aktikelSpeicherOrt2.txt";
	public static final String userPath = "/Users/admin/Dropbox/FH/benutzerSpeicherOrt2.txt";
	public static final int anzahlArtikelProSeite = 20;
}
