package edu.marius;

public class Factory {

	public ResursaUmana crearePersoana(String specializare)
	{
		if(specializare.equals("Necalificat"))
		{
			return new Persoana();
		}
		
		if(specializare.equals("Inginer"))
		{
			return new Inginer();
		}
		
		if(specializare.equals("Doctor"))
		{
			return new Doctor();
		}
		
		return null;
	}
}
