package edu.marius;

import java.util.ArrayList;
import java.util.List;

public class Evidenta {
	private static Evidenta evidenta = null;
	private List<Persoana> persoane = new ArrayList<>();
	
	private Evidenta()
	{
		
	}
	
	public static Evidenta getInstance()
	{
		if(evidenta == null)
		{
			evidenta = new Evidenta();
		}
		
		return evidenta;
	}
	
	public void adaugaPersoana(String numele, int numar, String denumire[], int scorul[])
	{
		persoane.add(new Persoana(numele, numar, denumire, scorul));
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
	
}
