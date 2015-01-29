package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import statics.Statics;
import model.BenutzerModel;

@SuppressWarnings("serial")
public class ProfilView extends JFrame
{
	private JButton ok;
	private JPanel profilJPanel;

	public ProfilView(ActionListener profilController)
	{
		this.setTitle("Profil");
		this.setLayout(new BorderLayout());		
		this.setSize(700,700);
		this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
		this.setLocation(Statics.loc_left, Statics.loc_down);
		
		profilJPanel = new JPanel();
		
		ok = new JButton(Statics.ok);
		ok.addActionListener(profilController);
		this.add(profilJPanel, BorderLayout.NORTH);
	}

	public void zeigeKeinBenutzer() 
	{
		profilJPanel.removeAll();
		profilJPanel.setLayout(new FlowLayout());
		
		profilJPanel.add(new JLabel("Kein Benutzer angemeldet. "));
		profilJPanel.add(ok);
		this.setVisible(true);
	}

	public void zeigeBenutzer(BenutzerModel aktuellerBenutzer) 
	{
		profilJPanel.removeAll();
		profilJPanel.setLayout(new GridLayout());
		
		
		profilJPanel.add(new JLabel(aktuellerBenutzer.getName()));
		profilJPanel.add(ok);
		this.setVisible(true);
	}

	public void schliessen()
	{
		this.dispose();
	}
}
