package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ShopView;

public class ShopController implements ActionListener
{
	private static ShopView einkaufsV = new ShopView();
	
	public static void einkaufAnzeigen()
	{
		if(einkaufsV.isActiv())
			einkaufsV.reset();
		einkaufsV.anzeigen();
	}

	public void setListener(ShopController einkaufsC)
	{
		einkaufsV.setListener(einkaufsC);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
