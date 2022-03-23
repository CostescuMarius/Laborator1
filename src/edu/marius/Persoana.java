package edu.marius;

public class Persoana {
	private String nume = new String();
	private Competenta competenta = new Competenta();
	
	public Persoana()
	{
		
	}
	
	public Persoana(String numele, int numar, String denumire[], int scorul[])
	{
		this.nume = numele;
		this.competenta = new Competenta(numar, denumire, scorul);
	}
	
	public void setNume(String numele)
	{
		this.nume = numele;
	}
	
	public String getNume()
	{
		return this.nume;
	}
	
	public void afisare_date()
	{
		System.out.println("Nume persoana: " + this.nume);
		System.out.println("Numar domenii: " + this.competenta.getNumarDomenii());
		this.competenta.afisareDateDomeniu();
	}
}
