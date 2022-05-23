package GUI;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.marius.Competenta;
import edu.marius.Evidenta;
import edu.marius.Persoana;

public class Fereastra implements Observer{

	private JFrame f = new JFrame();
	private Meniu meniu = new Meniu();
	private Butoane butoane;
	private JLabel lbl_fundal = new JLabel();
	Evidenta evidenta;
	JList<Object> lista_nume;
	JList<Object> date_persoana;
	
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
		
		adaugare_fundal_arbore();
	}
	
	private void setare_fereastra()
	{
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(1500, 820);
		f.setTitle("Editor Resurse Umane");
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(Color.gray);
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

		//date_persoana = new JList<>(evidenta.getPersoaneActive().toArray());
		//date_persoana.setBounds(590, 40, 880, 710);
		//date_persoana.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		//f.add(date_persoana);
	}
	
	private void adaugare_fundal_arbore()
	{
		lbl_fundal.setBounds(590, 40, 880, 710);
		lbl_fundal.setBackground(Color.white);
		lbl_fundal.setOpaque(true);
        f.add(lbl_fundal);
	}
	
	public void selectare_element_lista()
	{
		lista_nume.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()){
            		//evidenta.afisare_detalii_persoana(lista_nume.getSelectedValue());
                	evidenta.afisare_detalii_persoana(lista_nume.getSelectedValue(), lbl_fundal);
                }
            }
        });
	}
	
	@Override
	public void update(List<Persoana> list) 
	{	
		lista_nume.setForeground(Color.black);
		lista_nume.setSelectionBackground(Color.cyan);
		lista_nume.setListData(list.toArray());
	}
	
	public void update_activi(List<Persoana> list) 
	{	
		lista_nume.setForeground(new Color(0, 100, 0));
		lista_nume.setListData(list.toArray());
	}
	
	public void update_inactivi(List<Persoana> list) 
	{
		lista_nume.setForeground(new Color(100, 0, 0));
		lista_nume.setListData(list.toArray());
	}
	
	public void update_lista_detalii(List<Competenta> list)
	{
		date_persoana.setListData(list.toArray());
	}
}
