package it.polito.tdp.parole.model;


import java.util.LinkedList;
import java.util.List;

public class Parole {
	List<String> parole;

	

	
	public Parole() {
		
		parole = new LinkedList<String> ();
	}

	public void addParola(String p) {
		
		this.parole.add(p);
		
	}
	
	public List<String> getElenco() {
		
		return this.parole;
	}
	
	public void reset() {
	 
		this.parole.clear();
	
	}

	public void cancella(String s) {
		
			this.parole.remove(s);
	}

	
	
	
	
	
	
	
}
