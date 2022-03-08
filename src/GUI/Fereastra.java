package GUI;

import javax.swing.JFrame;

public class Fereastra {
	private JFrame f = new JFrame();
	private Meniu meniu = new Meniu();
	
	public Fereastra()
	{
		f.setVisible(true);
		f.setSize(400, 400);
		f.setTitle("Editor Resurse Umane");
		
		meniu.adaugare_meniu_in_fereastra(f);
	}
	
}
