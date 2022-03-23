package edu.marius;

import GUI.Fereastra;

public class Main {

	public static void main(String[] args) {
		Fereastra editor = new Fereastra();
		Persoana persoane[] = new Persoana[2];
		
		String denumire1[] = {"C++", "Java", "C#"};
		int scorul1[] = {1, 2, 0};
		persoane[0] = new Persoana("Marius", 3, denumire1, scorul1);
		
		String denumire2[] = {"asd", "dsa", "qwe"};
		int scorul2[] = {1, 0, 5};
		persoane[1] = new Persoana("Alex", 3, denumire2, scorul2);
		
		DateJson date = new DateJson();
		date.scriere_date_persoana(persoane);
		
		Persoana ResurseUmane[] = new Persoana[2];
		ResurseUmane = date.citire_date_persoana();
		ResurseUmane[0].afisare_date();
		System.out.println("\n");
		ResurseUmane[1].afisare_date();
	}

}
