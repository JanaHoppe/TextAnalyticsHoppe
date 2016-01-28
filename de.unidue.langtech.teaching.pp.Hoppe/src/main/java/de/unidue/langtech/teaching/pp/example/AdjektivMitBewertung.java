package de.unidue.langtech.teaching.pp.example;


public class AdjektivMitBewertung {
	
	private String wort; 
	private int bewertung; 
	
	public String getWort() {
		return this.wort; 
	}
	
	public int getBewertung() {
		return this.bewertung; 
	}
	
	public AdjektivMitBewertung(String wort, int bewertung) {
		this.wort = wort; 
		this.bewertung = bewertung; 
	}
	
	public boolean equals(String s) {
		
		if(s.equals(this.wort)) {
			return true; 
		}
		else {
			return false; 
		}
	}
	
}
