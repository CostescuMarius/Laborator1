package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import edu.marius.DateJson;
import edu.marius.Evidenta;
import edu.marius.Persoana;

public class Meniu{
	private JMenuBar bara_meniu = new JMenuBar();
	private JMenu meniu1 = new JMenu("File");
	//private JMenu meniu2 = new JMenu("Edit");
	//private JMenu meniu3 = new JMenu("Help");
	private JMenuItem nnew = new JMenuItem("New");
	private JMenuItem save = new JMenuItem("Save");
	private JMenuItem load = new JMenuItem("Load");
	private JMenuItem exit = new JMenuItem("Quit"); 
	
	public Meniu()
	{
		meniu1.add(nnew);
		functie_submeniu_new();
		
		meniu1.add(save);
		functie_submeniu_save();
		
		meniu1.add(load);
		functie_submeniu_load();
		
		meniu1.add(exit);
		functie_submeniu_quit();
		
		bara_meniu.add(meniu1);
		//bara_meniu.add(meniu2);
		//bara_meniu.add(meniu3);
	}
	
	public void adaugare_meniu_in_fereastra(JFrame f)
	{
		f.setJMenuBar(this.bara_meniu);
	}
	
	private void functie_submeniu_quit()
	{
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
		        System.exit(0);
			}
		});
	}

	private void functie_submeniu_save()
	{
		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Evidenta ResurseUmane_temp = Evidenta.getInstance();
				
				DateJson date = new DateJson();
				date.scriere_date_persoana(ResurseUmane_temp.getPersoane());
			}
		});
	}
	
	private void functie_submeniu_load()
	{
		load.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Evidenta ResurseUmane_temp = Evidenta.getInstance();
				
				DateJson date = new DateJson();
				ResurseUmane_temp.deserialziare_date(date);
				
				ResurseUmane_temp.ActualizareLista();
			}
		});
	}
	
	
	private void functie_submeniu_new()
	{
		nnew.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Evidenta ResurseUmane_temp = Evidenta.getInstance();
				ResurseUmane_temp.SetareListaLaNull();

			}
		});
	}
}
