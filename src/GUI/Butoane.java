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

	public Butoane()
	{
		btnAdauga = new JButton("Adauga Persoana");
		btnAdauga.setBounds(320, 10, 140, 20);
		
		btnSterge = new JButton("Sterge Persoana");
		btnSterge.setBounds(320, 40, 140, 20);
		
		btnModifica = new JButton("Modifica Stare");
		btnModifica.setBounds(320, 70, 140, 20);
		
		text = new JTextField(10);
		text.setBounds(320, 110, 140, 20);
		
		btnSchimbaListe = new JButton("Schimba Liste");
		btnSchimbaListe.setBounds(320, 380, 140, 20);
	}
	
	public void adaugare_butoane_in_fereastra(JFrame f, Evidenta Resurse)
	{			
		f.add(text);
		
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
		f.add(btnAdauga);
		
		btnSterge.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String nume = text.getText();
				Resurse.ScoatePersoana(nume);
			}
		});
		f.add(btnSterge);
		
		btnModifica.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String nume = text.getText();
				
				Resurse.ModificaStarePersoana(nume);
			}
		});
		f.add(btnModifica);
		

		btnSchimbaListe.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Resurse.SchimbaListe();
			}
		});
		f.add(btnSchimbaListe);
	}
}
