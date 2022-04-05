package GUI;

import javax.swing.JFrame;
import javax.swing.JList;

import edu.marius.Evidenta;

public class Fereastra implements Observer{

	private JFrame f = new JFrame();
	private Meniu meniu = new Meniu();
	private Butoane butoane = new Butoane();
	Evidenta evidenta;
	JList<Object> lista;
	
	public Fereastra(Evidenta e)
	{
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(500, 500);
		f.setTitle("Editor Resurse Umane");
		
		evidenta = e;
		
		lista = new JList<>(evidenta.getPersoane().toArray());
		lista.setBounds(10, 10, 300, 400);
		f.add(lista);
		
		meniu.adaugare_meniu_in_fereastra(f);
		butoane.adaugare_butoane_in_fereastra(f, evidenta);	
	}
	
	@Override
	public void update() 
	{
		lista.setListData(evidenta.getPersoane().toArray());
	}
	
}
