package edu.marius;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

public class DateJson implements Serializable{
	final String FileName = "info.json";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void scriere_date_persoana(List<Persoana> persoane)
	{
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.setPrettyPrinting().create();
		
		 try(FileWriter fw = new FileWriter(FileName)){
			gson.toJson(persoane, fw);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Persoana> citire_date_persoana()
	{
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		List<Persoana> persoane = new ArrayList<>();
		
		try(FileReader fr = new FileReader(FileName)) {
			Type listType = new TypeToken<ArrayList<Persoana>>(){}.getType();
			persoane = gson.fromJson(fr, listType);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return persoane;
	}
}
