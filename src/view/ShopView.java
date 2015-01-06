package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShopView
{
	private JFrame einkaufFrame = new JFrame("Einkaufen");
	private ActionListener controller;
	
	public void anzeigen()
	{
		JPanel panel = bauPanel();
		bauFrame(panel);
	}
	private void bauFrame(JPanel panel)
	{
		einkaufFrame.add(panel);
		einkaufFrame.setLayout(new FlowLayout());		
		einkaufFrame.setSize(700,700);
		einkaufFrame.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		einkaufFrame.setVisible(true);
		einkaufFrame.setLocation(0, 180);
	}
	public void setListener(ActionListener controller)
	{
		this.controller = controller;
	}
	private JPanel bauPanel()
	{
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
		
		return zeile;
	}
	public boolean isActiv()
	{
		return einkaufFrame.isDisplayable();
	}
	public void reset()
	{
		einkaufFrame.removeAll();
	}
}