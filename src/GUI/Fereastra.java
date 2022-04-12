package GUI;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;

import edu.marius.Evidenta;
import edu.marius.Persoana;

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
		f.setResizable(false);
		evidenta = e;
		
		lista = new JList<>(evidenta.getPersoaneActive().toArray());
		lista.setBounds(10, 10, 300, 400);
		f.add(lista);
		
		meniu.adaugare_meniu_in_fereastra(f);
		butoane.adaugare_butoane_in_fereastra(f, evidenta);	
	}
	
	@Override
	public void update(List<Persoana> list) 
	{
		lista.setListData(list.toArray());
	}
	
}
