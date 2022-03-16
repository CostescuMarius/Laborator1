package edu.marius;

public class ResursaUmana {
	private Persoana persoana = new Persoana();
	private Competenta competenta = new Competenta();
	
	public void afisare_date()
	{
		System.out.println("Nume persoana: " + this.persoana.getNume());
		System.out.println("Numar domenii: " + this.competenta.getNumarDomenii());
		this.competenta.afisareDateDomeniu();
	}
	
}
