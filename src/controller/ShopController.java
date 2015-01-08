package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ShopView;

public class ShopController implements ActionListener
{
	private ShopView shopView = new ShopView(this);
	
	public void einkaufAnzeigen()
	{
		shopView.show();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
