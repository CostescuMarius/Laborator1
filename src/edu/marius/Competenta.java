package edu.marius;


import java.util.ArrayList;
import java.util.List;

public class Competenta {
	private int numar_domenii;
	private List<Domeniu> lista_domenii = new ArrayList<>();
	
	public Competenta()
	{
	}
	
	public Competenta(int numar, String denumire[], int scorul[])
	{
		this.numar_domenii = numar;
		
		for(int i = 0; i < this.numar_domenii; i++)
		{
			this.lista_domenii.add(new Domeniu(denumire[i], scorul[i]));
		}
	}
	
	public void setNumarDomenii(int numar)
	{
		this.numar_domenii = numar;
	}
	
	public int getNumarDomenii()
	{
		return this.numar_domenii;
	}
	
	public void afisareDateDomeniu()
	{
		int[] iterator = {1};
		this.lista_domenii.forEach((domeniu) ->
		{
			System.out.println("Domeniul " + iterator[0] + ":");
			iterator[0]++;
			System.out.println("\tDenumire: " + domeniu.getDenumire());
			System.out.println("\tScor: " + domeniu.getScor());
			if(domeniu.getEFrunza() == true)
			{
				System.out.println("\tE frunza");
			}
			else
			{
				System.out.println("\tNu e frunza");
			}
		});
	}
	
	
	@Override
	public String toString()
	{
		String str = "";
		for(int i = 0; i < lista_domenii.size(); i++)
		{
			str = str + lista_domenii.get(i).getDenumire() + " ";
		}
		
		return this.getNumarDomenii() + " " + str;
	}
}

