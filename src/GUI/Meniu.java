package GUI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Meniu{
	private JMenuBar bara_meniu = new JMenuBar();
	private JMenu meniu1 = new JMenu("File");
	private JMenu meniu2 = new JMenu("Edit");
	private JMenu meniu3 = new JMenu("Help");
	private JMenuItem item1 = new JMenuItem("New");
	private JMenuItem item2 = new JMenuItem("Save"); 
	private JMenuItem item3 = new JMenuItem("Quit"); 
	
	public Meniu()
	{
		meniu1.add(item1);
		meniu1.add(item2);
		meniu1.add(item3);
		bara_meniu.add(meniu1);
		bara_meniu.add(meniu2);
		bara_meniu.add(meniu3);
	}

	public void adaugare_meniu_in_fereastra(JFrame f)
	{
		f.setJMenuBar(this.bara_meniu);
	}

}
