package edu.marius;


public class Competenta {
	private int numar_domenii;
	private Domeniu[] lista_domenii = new Domeniu[3];
	
	public Competenta()
	{
	}
	
	public Competenta(int numar, String denumire[], int scorul[])
	{
		this.numar_domenii = numar;
		for(int i = 0; i < this.numar_domenii; i++)
		{
			this.lista_domenii[i] = new Domeniu(denumire[i], scorul[i]);
		}
	}
	
	public void setNumarDomenii(int numar)
	{
		this.numar_domenii = numar;
		for(int i = 0; i < this.numar_domenii; i++)
		{
			this.lista_domenii[i] = new Domeniu();
		}
	}
	
	public int getNumarDomenii()
	{
		return this.numar_domenii;
	}
	
	public void afisareDateDomeniu()
	{
		int i = 1;
		for(Domeniu domeniu : this.lista_domenii)
		{
			System.out.println("Domeniul " + i + ":");
			i++;
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
		}
	}
}
