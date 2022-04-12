package edu.marius;

import java.util.ArrayList;
import java.util.List;

import GUI.Observer;

public class Evidenta {
	private List<Persoana> persoane = new ArrayList<>();
	private ArrayList<Observer> observatori;
	
	private static Evidenta evidenta = null;
	
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
		/*persoane.forEach((persoana) -> {
			persoana.afisare_date();
		});*/
		
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
	
	public List<Persoana> getPersoaneActive()
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
				persoane.get(i).setActiv(false);
			}
			observatori.get(0).update(getPersoaneActive());
		}
	}
	
	private boolean prima_lista = true;
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
