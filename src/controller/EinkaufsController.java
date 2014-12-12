package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.EinkaufsView;

public class EinkaufsController implements ActionListener
{
	private EinkaufsView einkaufsV = new EinkaufsView();
	
	public void einkaufAnzeigen()
	{
		einkaufsV.anzeigen();
	}

	public void setListener(EinkaufsController einkaufsC)
	{
		einkaufsV.setListener(einkaufsC);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
