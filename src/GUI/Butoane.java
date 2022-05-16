package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import edu.marius.Builder;
import edu.marius.Evidenta;
import edu.marius.Persoana;

public class Butoane {
	private JButton btnAdauga = new JButton();
	private JButton btnSterge = new JButton();
	private JButton btnModifica = new JButton();
	private JButton btnSchimbaListe = new JButton();
	private JTextField text = new JTextField();

	public Butoane(Evidenta Resurse)
	{
		creare_butoane(Resurse);
		creare_text_field();
	}
	
	private void creare_butoane(Evidenta Resurse)
	{
		btnAdauga = new JButton("Adauga Persoana");
		btnAdauga.setBounds(320, 10, 140, 20);
		functie_buton_adauga(Resurse);
		btnAdauga.setVisible(true);
		
		btnSterge = new JButton("Sterge Persoana");
		btnSterge.setBounds(320, 40, 140, 20);
		functie_buton_sterge(Resurse);
		btnSterge.setVisible(true);
		
		btnModifica = new JButton("Modifica Stare");
		btnModifica.setBounds(320, 70, 140, 20);
		functie_buton_modifica(Resurse);
		btnModifica.setVisible(true);
		
		btnSchimbaListe = new JButton("Schimba Liste");
		btnSchimbaListe.setBounds(320, 380, 140, 20);
		functie_buton_schimba(Resurse);
		btnSchimbaListe.setVisible(true);
	}
	
	private void functie_buton_adauga(Evidenta Resurse)
	{
		btnAdauga.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String nume = text.getText();
				String denumire[] = {"aaa", "bbb", "ccc"};
				int scor[] = {1, 0, 1};
				Persoana p_temp = new Builder().seteazaNume(nume).seteazaActiv(true).seteazaCompetenta(3, 
						denumire, scor).build();
				Resurse.AdaugaPersoana(p_temp);
			}
		});
	}
	
	private void functie_buton_sterge(Evidenta Resurse)
	{
		btnSterge.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String nume = text.getText();
				Resurse.ScoatePersoana(nume);
			}
		});
	}
	
	private void functie_buton_modifica(Evidenta Resurse)
	{
		btnModifica.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String nume = text.getText();
				
				Resurse.ModificaStarePersoana(nume);
			}
		});
	}
	
	private void functie_buton_schimba(Evidenta Resurse)
	{

		btnSchimbaListe.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Resurse.SchimbaListe();
			}
		});
	}
	
	public void adaugare_butoane_in_fereastra(JFrame f)
	{				
		f.add(btnAdauga);
		

		f.add(btnSterge);
		
		
		f.add(btnModifica);
		

		f.add(btnSchimbaListe);
	}
	
	private void creare_text_field()
	{
		text = new JTextField(10);
		text.setBounds(320, 110, 140, 20);
		text.setVisible(true);
	}
	
	public void adaugare_text_in_fereastra(JFrame f)
	{
		f.add(text);
	}
	
}
