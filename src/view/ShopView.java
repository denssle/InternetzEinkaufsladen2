package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import statics.Statics;

public class ShopView extends JFrame
{	
	public ShopView(ActionListener shopController)
	{
		this.setTitle("Einkaufen");
		this.setLayout(new FlowLayout());		
		this.setSize(700,700);
		this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		this.setLocation(Statics.loc_left, Statics.loc_down);
		
		JPanel zeile = new JPanel();
		int limit = 21;
		zeile.setLayout(new GridLayout(limit+1, 3));
		zeile.add(new JLabel("Artikelnummer: "));
		zeile.add(new JLabel("Artikel: "));
		zeile.add(new JLabel("Details: "));
		
		for(int i = 0; i < limit; i++)
		{
			zeile.add(new JLabel("ID"+i));
	        zeile.add(new JLabel("Artikel Nr. "+i));
	        JButton details = new JButton("Details");
	        zeile.add(details);
		}
		this.add(zeile);
	}
	public void show()
	{
		this.setVisible(true);
	}

	public boolean isActiv()
	{
		return this.isDisplayable();
	}
	public void hide()
	{
		this.setVisible(false);
	}
}