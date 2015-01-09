package view;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import statics.Statics;
import model.ArtikelModel;

public class ArtikelDetailView extends JFrame
{
	public ArtikelDetailView()
	{
		this.setLayout(new FlowLayout());		
		this.setSize(700,700);
		this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		this.setLocation(Statics.loc_left, Statics.loc_down);
	}
	
	public void anzeigen(ArtikelModel anzuzeigenderArtikel)
	{
		this.setVisible(true);
		this.setTitle(anzuzeigenderArtikel.getName());
	}
}
