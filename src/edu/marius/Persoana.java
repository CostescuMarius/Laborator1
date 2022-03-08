package edu.marius;

public class Persoana {
	private String nume = new String();
	
	public Persoana()
	{
		
	}
	
	public Persoana(String numele)
	{
		this.nume = numele;
	}
	
	public void setNume(String numele)
	{
		this.nume = numele;
	}
	
	public String getNume()
	{
		return this.nume;
	}
}
