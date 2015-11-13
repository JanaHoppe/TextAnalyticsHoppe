package de.unidue.langtech.teaching.pp.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Woerterbuch {

	@SuppressWarnings("null")
	public static Set<String> erstelle(String fileName) throws IOException{
		FileReader fr = new FileReader(fileName);
	    BufferedReader br = new BufferedReader(fr);
	    Set<String> words = new HashSet<String>();
	    
	    String tmp = br.readLine();
	    while (tmp != null) {
	    	if(words.contains(tmp.toLowerCase())) {
	    		
	    	}
	    	else {
	    		words.add(tmp.toLowerCase());
	    	}
	    tmp = br.readLine();
		}
	    br.close();
	    
		return words;
	 }

}
