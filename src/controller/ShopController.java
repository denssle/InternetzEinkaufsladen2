package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ShopView;

public class ShopController implements ActionListener
{
	private ShopView einkaufsV = new ShopView(this);
	
	public static void einkaufAnzeigen()
	{
		einkaufsV.anzeigen();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
