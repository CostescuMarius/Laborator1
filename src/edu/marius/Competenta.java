package edu.marius;

public class Competenta {
	private int numar_domenii;
	private Domeniu[] lista_domenii;
	
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
}
