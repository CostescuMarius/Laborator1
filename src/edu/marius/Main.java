package edu.marius;

import GUI.Fereastra;

public class Main {

	public static void main(String[] args) {
		Fereastra editor = new Fereastra();
		ResursaUmana prima_resursa = new ResursaUmana();
		CitireDate date = new CitireDate();
		
		prima_resursa = date.citire_data_persoana(prima_resursa);
		prima_resursa.afisare_date();
	}

}
