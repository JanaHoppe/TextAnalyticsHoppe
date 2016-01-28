package de.unidue.langtech.teaching.pp.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class AdjektivWörterbuch {
	
	public static Set<AdjektivMitBewertung> erstelle(String fileName) throws IOException{
		FileReader fr = new FileReader(fileName);
	    BufferedReader br = new BufferedReader(fr);
	    Set<AdjektivMitBewertung> words = new HashSet<AdjektivMitBewertung>();
	    
	    String[] parts = br.readLine().split("\t"); 
	    
	    String adjektiv = parts[0];
	    int bewertung = Integer.parseInt(parts[1]); 
	    
	   AdjektivMitBewertung next = new AdjektivMitBewertung(adjektiv, bewertung); 
	    
	    while (adjektiv != null) {
	    	if(words.contains(next)) {
	    		
	    	}
	    	else {
	    		words.add(next);
	    	}
	    	parts = br.readLine().split("\t"); 
	    	adjektiv = parts[0]; 
	    	bewertung = Integer.parseInt(parts[1]);
	    	next = new AdjektivMitBewertung(adjektiv, bewertung); 
	    
		}
	    br.close();
	    
		return words;
	 }

}
