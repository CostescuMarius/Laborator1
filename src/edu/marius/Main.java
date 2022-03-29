package edu.marius;

import java.util.ArrayList;
import java.util.List;

//import GUI.Fereastra;

public class Main {

	public static void main(String[] args) {
		//Fereastra editor = new Fereastra();
		
		List<Persoana> persoane_temp = new ArrayList<>();
		String denumire1[] = {"C++", "Java", "C#"};
		int scorul1[] = {1, 2, 0};
		persoane_temp.add(new Persoana("Marius", 3, denumire1, scorul1));
		
		String denumire2[] = {"asd", "dsa", "qwe"};
		int scorul2[] = {1, 0, 5};
		persoane_temp.add(new Persoana("Alex", 3, denumire2, scorul2));
		
		DateJson date = new DateJson();
		date.scriere_date_persoana(persoane_temp);
		
		//deserializam datele intr-o instanta a clasei Evidenta
		Evidenta ResurseUmane1 = Evidenta.getInstance();
		ResurseUmane1.deserialziare_date(date);
		
		//afisam datele dintr-o alta instanta a clasei Evidenta
		//observam ca cele doua instante ocupa aceeasi adresa in memorie
		Evidenta ResurseUmane2 = Evidenta.getInstance();
		ResurseUmane2.afisare_date();
	}

}
