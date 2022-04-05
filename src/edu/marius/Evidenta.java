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
		persoane.forEach((persoana) -> {
			persoana.afisare_date();
		});
	}
	
	
	public List<Persoana> getPersoane()
	{
		return persoane;
	}
	
	public void AdaugaPersoana(Persoana p)
	{
		persoane.add(p);
		
		observatori.get(0).update();
		
	}
	
	public void ScoatePersoana(String nume)
	{	
		for(int i = 0; i < persoane.size(); i++)
		{
			if(persoane.get(i).getNume().equals(nume))
			{
				persoane.remove(i);
			}
			observatori.get(0).update();
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
}
