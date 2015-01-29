package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ProfilView;

public class ProfilController implements ActionListener
{
	private ProfilView profilView;
	
	public ProfilController()
	{
		this.profilView = new ProfilView(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
