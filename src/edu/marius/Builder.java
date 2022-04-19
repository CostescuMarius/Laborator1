package edu.marius;

public class Builder {
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
