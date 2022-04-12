package edu.marius;

//import edu.marius.Evidenta.Builder;

public class Persoana implements ResursaUmana {
	private String nume = new String();
	private boolean activ;
	private Competenta competenta = new Competenta();

	
	public Persoana()
	{
		
	}
	
	public Persoana(String numele, int numar, String denumire[], int scorul[], boolean activ)
	{
		this.nume = numele;
		this.activ = activ;
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
	
	public void setActiv(boolean activ)
	{
		this.activ = activ;
	}
	
	public boolean getActiv()
	{
		return this.activ;
	}
	
	public void afisare_date()
	{
		System.out.println("Nume persoana: " + this.nume);
		System.out.println("Numar domenii: " + this.competenta.getNumarDomenii());
		this.competenta.afisareDateDomeniu();
		System.out.println("\n");
	}
	
	@Override
	public String toString()
	{
		return this.getNume() + " " + this.competenta.toString();
	}
	
	public void getSpecializare()
	{
		System.out.println("Necalificat");
	}
	
	public static class Builder
	{
		String nume;
		boolean activ;
		Competenta competenta;
		
		public Builder seteazaNume(String nume)
		{
			this.nume = nume;
			return this;
		}
		
		public Builder seteazaActiv(boolean activ)
		{
			this.activ = activ;
			return this;
		}
		
		public Builder seteazaCompetenta(int numar, String denumire[], int scorul[])
		{
			this.competenta = new Competenta(numar, denumire, scorul);
			return this;
		}
		
		public Persoana build()
		{
			return new Persoana(this);
		}
	}
	
	private Persoana(Builder b)
	{
		this.nume =  b.nume;
		this.activ = b.activ;
		this.competenta = b.competenta;
	}
}
