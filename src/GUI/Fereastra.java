package GUI;

import java.awt.Color;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.marius.Evidenta;
import edu.marius.Persoana;

public class Fereastra implements Observer{

	private JFrame f = new JFrame();
	Evidenta evidenta;
	private Meniu meniu = new Meniu();
	private Butoane butoane;
	private JLabel[] celule_arbore = new JLabel[10];
	JList<Object> lista_nume;
	
	public Fereastra(Evidenta e)
	{
		evidenta = e;
		butoane = new Butoane(evidenta);
		
		setare_fereastra();
		adaugare_liste();
		
		meniu.adaugare_meniu_in_fereastra(f);
		
		butoane.adaugare_text_in_fereastra(f);
		
		butoane.adaugare_butoane_in_fereastra(f);
		
		selectare_element_lista();
		
		adaugare_celule_arbore();
		
		setare_spatiu_arbore();
	}
	
	private void setare_fereastra()
	{
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(1500, 820);
		f.setTitle("Editor Resurse Umane");
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
	}
	
	private void adaugare_liste()
	{
		JScrollPane scrollPane = new JScrollPane();
		lista_nume = new JList<>(evidenta.getPersoaneActive().toArray());

		scrollPane.setViewportView(lista_nume);
		scrollPane.setBounds(10, 40, 400, 710);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		f.add(scrollPane);
		lista_nume.setVisible(true);
	}
	
	public void adaugare_celule_arbore()
	{
		for(int i = 0; i < 10; i++)
		{
			celule_arbore[i] = new JLabel();
			celule_arbore[i].setHorizontalAlignment(SwingConstants.CENTER);
			celule_arbore[i].setVerticalAlignment(SwingConstants.CENTER);
			f.add(celule_arbore[i]);
			celule_arbore[i].setVisible(false);
		}
	}
	
	private void setare_spatiu_arbore()
	{
		JLabel spatiu_arbore = new JLabel();
		
		spatiu_arbore.setBackground(Color.white);
		spatiu_arbore.setOpaque(true);
		spatiu_arbore.setBounds(600, 40, 870, 700);
		spatiu_arbore.setBorder(BorderFactory.createLineBorder(new Color(50, 0 , 100), 3));
		
		f.add(spatiu_arbore);
	}
	
	public void selectare_element_lista()
	{
		lista_nume.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()){
                	evidenta.afisare_detalii_persoana(lista_nume.getSelectedValue(), celule_arbore);
                }
            }
        });
	}
	
	@Override
	public void update(List<Persoana> list, int index_culoare) 
	{
		if(index_culoare == 1)
		{
			lista_nume.setForeground(Color.black);
		}
		else if(index_culoare == 2)
		{
			lista_nume.setForeground(new Color(0, 100, 0));
		}
		else if(index_culoare == 3)
		{
			lista_nume.setForeground(new Color(100, 0, 0));
		}
		lista_nume.setSelectionBackground(Color.cyan);
		lista_nume.setListData(list.toArray());
	}
}
