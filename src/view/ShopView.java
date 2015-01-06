package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShopView extends JFrame
{	
	public ShopView(ActionListener shopController)
	{
		this.setTitle("Einkaufen");
		this.setLayout(new FlowLayout());		
		this.setSize(700,700);
		this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		this.setLocation(0, 180);
		
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
	}
	public void anzeigen()
	{
		this.setVisible(true);
	}

	public boolean isActiv()
	{
		return this.isDisplayable();
	}
	public void reset()
	{
		this.removeAll();
	}
}