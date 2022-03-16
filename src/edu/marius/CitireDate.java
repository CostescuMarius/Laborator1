package edu.marius;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CitireDate {

	public ResursaUmana citire_data_persoana(ResursaUmana resursa)
	{
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		try {
			FileReader fr = new FileReader("info.json");
			
			resursa = gson.fromJson(fr, ResursaUmana.class);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resursa;
	}
}
