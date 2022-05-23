package edu.marius;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import GUI.Fereastra;

public class Facade {
	private List<Persoana> persoane_temp = new ArrayList<>();
	
	public void executare()
	{
	    Scanner scan= new Scanner(System.in);
		int optiune = 1;
		
		/*do
		{
			citire_persoane_consola();
		
			System.out.println("Continuati? 1/0");
			optiune = scan.nextInt();
		}while(optiune != 0);*/

		
		
		DateJson date = new DateJson();
		date.scriere_date_persoana(persoane_temp);
		
		//deserializam datele intr-o instanta a clasei Evidenta
		Evidenta ResurseUmane1 = Evidenta.getInstance();
		ResurseUmane1.deserialziare_date(date);
		
		//afisam datele dintr-o alta instanta a clasei Evidenta
		//observam ca cele doua instante ocupa aceeasi adresa in memorie
		Evidenta ResurseUmane2 = Evidenta.getInstance();
		ResurseUmane2.afisare_date();
		
		Fereastra editor = new Fereastra(ResurseUmane2);
		ResurseUmane2.adaugaObserver(editor);	
	}
	
	private void citire_persoane_consola()
	{
	    Scanner scan= new Scanner(System.in);
	    
	    System.out.println("Nume: ");
	    String nume = scan.next();
	    
	    System.out.println("Stare: ");
	    Boolean stare = scan.nextBoolean();
	    
	    System.out.println("Numarul de competente: ");
		int numar = scan.nextInt();
	    
		String[] denumire = new String[numar];
		int[] scor = new int[numar];
		
		for(int i = 0; i < numar; i++)
		{
			System.out.println("Competenta " + (i + 1) + ": " );
			denumire[i] = scan.next();

			System.out.println("Scor " + (i + 1) + ": " );
			scor[i] = scan.nextInt();
		}
		
		persoane_temp.add(new Builder().seteazaNume(nume).seteazaActiv(stare).seteazaCompetenta(numar, 
				denumire, scor).build());
	}
}
