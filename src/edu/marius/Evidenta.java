package edu.marius;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

import GUI.Fereastra;
import GUI.Observer;

public class Evidenta {
	private List<Persoana> persoane = new ArrayList<>();
	private ArrayList<Observer> observatori;
	
	private static Evidenta evidenta = null;
	
	public int evidenta_lista = 1;
	
	private Evidenta()
	{
		observatori = new ArrayList<Observer>();
	}
	
	public static Evidenta getInstance()
	{
		if(evidenta == null)
		{
			evidenta = new Evidenta();
		}
		
		return evidenta;
	}
	
	public void addPersoana(Persoana p)
	{
		persoane.add(p);
	}
	
	public void serializare_date(DateJson date)
	{
		date.scriere_date_persoana(persoane);
	}
	
	public void deserialziare_date(DateJson date)
	{
		persoane = date.citire_date_persoana();
	}
	
	public void afisare_date()
	{
		for(Iterator iter = getIterator(); iter.hasNext();)
		{
			Persoana pers = (Persoana)iter.next();
			if(pers != null)
			{
				pers.afisare_date();
			}
		}
	}
	
	
	public List<Persoana> getPersoane()
	{
		return persoane;
	}
	
	/*public List<Persoana> getPersoaneActive()
	{
		List<Persoana> lista_temp = new ArrayList<>();
		
		for(Iterator iter = getIterator(); iter.hasNext();)
		{
			Persoana pers = (Persoana)iter.next();
			if(pers != null)
			{
				lista_temp.add(pers);
			}
		}
		
		return lista_temp;
	}*/
	
	public List<Persoana> getPersoaneActive()
	{
		List<Persoana> lista_temp = new ArrayList<>();
		
		for(int i = 0; i < persoane.size(); i++)
		{
			if(persoane.get(i).getActiv() == true)
			{
				lista_temp.add(persoane.get(i));
			}
		}
		return lista_temp;
	}
	
	public List<Persoana> getPersoaneInactive()
	{
		List<Persoana> lista_temp = new ArrayList<>();
		
		for(int i = 0; i < persoane.size(); i++)
		{
			if(persoane.get(i).getActiv() == false)
			{
				lista_temp.add(persoane.get(i));
			}
		}
		return lista_temp;
	}
	
	public void AdaugaPersoana(Persoana p)
	{
		persoane.add(p);
		
		observatori.get(0).update(getPersoane());
	}
	
	public void ScoatePersoana(String nume)
	{	
		for(int i = 0; i < persoane.size(); i++)
		{
			if(persoane.get(i).getNume().equals(nume))
			{
				persoane.remove(i);
			}
			observatori.get(0).update(getPersoane());
		}
	}
	
	public void ModificaStarePersoana(String nume)
	{	
		for(int i = 0; i < persoane.size(); i++)
		{
			if(persoane.get(i).getNume().equals(nume))
			{
				if(persoane.get(i).getActiv() == true)
				{
					persoane.get(i).setActiv(false);
				}
				else
				{
					persoane.get(i).setActiv(true);
				}
			}

			if(evidenta_lista == 1)
			{
				observatori.get(0).update(getPersoane());
			}
			else if(evidenta_lista == 2)
			{
				observatori.get(0).update_activi(getPersoaneActive());
			}
			else if(evidenta_lista == 3)
			{
				observatori.get(0).update_inactivi(getPersoaneInactive());
			}
		}
	}
	
	public void AfisarePersonalTotal()
	{
		observatori.get(0).update(getPersoane());
	}
	
	public void AfisarePersonalActiv()
	{
		observatori.get(0).update_activi(getPersoaneActive());
	}
	
	public void AfisarePersonalInactiv()
	{
		observatori.get(0).update_inactivi(getPersoaneInactive());
	}
	
	/*private boolean prima_lista = true;
	public void SchimbaListe()
	{
		if(prima_lista)
		{
			observatori.get(0).update(getPersoaneInactive());
			this.prima_lista = false;
		}
		
		else
		{
			observatori.get(0).update(getPersoaneActive());
			this.prima_lista = true;
		}
	}*/
	
	/*public void afisare_detalii_persoana(Object pers)
	{
		List<Competenta> comp_temp = new ArrayList<>();
		for(int i = 0; i < persoane.size(); i++)
		{
			if(persoane.get(i).equals(pers))
			{
				comp_temp.add(persoane.get(i).getCompetenta());
			}
		}
		
		observatori.get(0).update_lista_detalii(comp_temp);
	}*/
	
	public void afisare_detalii_persoana(Object pers, JLabel[] celule)
	{
		for(int k = 0; k < 10; k++)
		{
			celule[k].setVisible(false);
		}
		
		Integer[] x = new Integer[10];
		Integer[] y = new Integer[10];
		Integer[] z = new Integer[10];
		Integer[] t = new Integer[10];
		
		x[0] = 1000;
		y[0] = 70;
		z[0] = 140;
		t[0] = 20;
		
		for(int i = 0; i < persoane.size(); i++)
		{
			if(persoane.get(i).equals(pers))
			{
				celule[0].setBounds(x[0], y[0], z[0], t[0]);
				celule[0].setText(persoane.get(i).getNume());
				celule[0].setVisible(true);
				
				x[1] = x[0] - 100;
				y[1] = y[0] + 30;
				z[1] = z[0];
				t[1] = t[0];
				
				for(int j = 0; j < persoane.get(i).getNrCompetente(); j++)
				{
					if(persoane.get(i).getScorCompetenta(j) == 0)
					{
						celule[j + 1].setBounds(x[j + 1], y[j + 1], z[j + 1], t[j + 1]);
						celule[j + 1].setText(persoane.get(i).getNumeCompetenta(j));
						celule[j + 1].setVisible(true);
						
						x[j + 2] = x[j + 1] + 100;
						y[j + 2] = y[j + 1];
						z[j + 2] = z[j + 1];
						t[j + 2] = t[j + 1];
					}
					
					else
					{
						celule[j + 1].setBounds(x[j + 1], y[j + 1], z[j + 1], t[j + 1]);
						celule[j + 1].setText(persoane.get(i).getNumeCompetenta(j));
						celule[j + 1].setVisible(true);
						
						x[j + 2] = x[j + 1] - 100;
						y[j + 2] = y[j + 1] + 30;
						z[j + 2] = z[j + 1];
						t[j + 2] = t[j + 1];
					}
				}
			}
		}
	}
	
	public void adaugaObserver(Observer o)
	{
		observatori.add(o);
	}
	
	public void adaugareResurseUmana(Factory f)
	{
		ResursaUmana p;
		p = f.crearePersoana("Inginer");
		persoane.add((Persoana)p);
	}
	
	public Iterator getIterator()
	{
		return new PersoaneIterator();
	}
	
	
	private class PersoaneIterator implements Iterator
	{
		int index;
		
		@Override
		public boolean hasNext()
		{
			if(index < persoane.size())
			{
				return true;
			}
			return false;
		}
		
		@Override
		public Persoana next()
		{
			if(this.hasNext())
			{
					while(persoane.get(index).getActiv() == false && this.hasNext())
					{
						index++;
						if(!this.hasNext())
						{
							return null;
						}
					}
					if(this.hasNext())
					{
						return persoane.get(index++);
					}
					
					return null;
			}

			return null;
		}
	}
	
}
