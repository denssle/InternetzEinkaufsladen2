package controller;
import view.EinkaufsView;

public class EinkaufsController
{
	private EinkaufsView einkaufsV = new EinkaufsView();
	
	public void einkaufAnzeigen()
	{
		einkaufsV.anzeigen();
	}
}
