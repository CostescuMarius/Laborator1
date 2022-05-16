package GUI;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;

import edu.marius.Evidenta;
import edu.marius.Persoana;

public class Fereastra implements Observer{

	private JFrame f = new JFrame();
	private Meniu meniu = new Meniu();
	private Butoane butoane;
	Evidenta evidenta;
	JList<Object> lista;
	
	public Fereastra(Evidenta e)
	{
		evidenta = e;
		
		setare_fereastra();
		adaugare_lista();
		
		meniu.adaugare_meniu_in_fereastra(f);
		
		butoane = new Butoane(evidenta);
		
		butoane.adaugare_text_in_fereastra(f);
		butoane.adaugare_butoane_in_fereastra(f);
	}
	
	private void setare_fereastra()
	{
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(500, 500);
		f.setTitle("Editor Resurse Umane");
		f.setResizable(false);
	}
	
	private void adaugare_lista()
	{
		lista = new JList<>(evidenta.getPersoaneActive().toArray());
		lista.setBounds(10, 10, 300, 400);
		f.add(lista);
	}
	
	@Override
	public void update(List<Persoana> list) 
	{
		lista.setListData(list.toArray());
	}
	
}
