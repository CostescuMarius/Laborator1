package edu.marius;

public class Domeniu {
	private String denumire = new String();
	private int scor;
	private boolean e_frunza;
	
	public Domeniu()
	{
		
	}
	
	public Domeniu(String denumirea, int scorul)
	{
		this.denumire = denumirea;
		this.scor = scorul;
		if(this.scor == 0)
		{
			this.e_frunza = false;
		}
		else
		{
			this.e_frunza = true;
		}
	}
	
	public void setDenumire(String denumirea)
	{
		this.denumire = denumirea;
	}
	
	public String getDenumire()
	{
		return this.denumire;
	}
	
	public void setEFrunza(boolean frunza)
	{
		this.e_frunza = frunza;
	}
	
	public boolean getEFrunza()
	{
		return this.e_frunza;
	}
	
	public void setScor(int scorul)
	{
		this.scor = scorul;
	}
	
	public int getScor()
	{
		return this.scor;
	}
}
