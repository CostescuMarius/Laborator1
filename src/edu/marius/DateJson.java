package edu.marius;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DateJson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void scriere_date_persoana(Persoana persoane[])
	{
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create(); 
		
		 try(FileWriter fw = new FileWriter("info.json")){
			gson.toJson(persoane, fw);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Persoana[] citire_date_persoana()
	{
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		Persoana[] persoane = new Persoana[2];
		
		try(FileReader fr = new FileReader("info.json")) {
			persoane = gson.fromJson(fr, Persoana[].class);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return persoane;
	}
}
