package edu.marius;

public class Competenta {
	private int numar_domenii;
	private Domeniu[] lista_domenii = new Domeniu[5];
	
	public Competenta()
	{
	}
	
	public Competenta(int numar)
	{
		this.numar_domenii = numar;
		for(int i = 0; i < this.numar_domenii; i++)
		{
			this.lista_domenii[i] = new Domeniu();
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
		for(int i = 0; i < this.numar_domenii; i++)
		{
			System.out.println("Domeniul " + i + ":");
			System.out.println("\tDenumire: " + this.lista_domenii[i].getDenumire());
			System.out.println("\tScor: " + this.lista_domenii[i].getScor());
			if(this.lista_domenii[i].getEFrunza() == true)
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
