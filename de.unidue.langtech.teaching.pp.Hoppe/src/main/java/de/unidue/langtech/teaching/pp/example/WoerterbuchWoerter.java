package de.unidue.langtech.teaching.pp.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WoerterbuchWoerter {
	
	public static String[] erstelle(String fileName) {
		
		FileReader fr;
		try {
			fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
	    
			//String[] parts = br.readLine().split("\t");
	    
			//String words = parts[0];
			//int bewertung = Integer.parseInt(parts[1]); 
			String[] woerterArray = new String[2476]; 
			
			for (int i = 0; i < 2476; i++) { 
				
				String[] parts = br.readLine().split("\t");
			    String words = parts[0];
				
				woerterArray[i] = words; 
				
				//System.out.println(woerterArray[i]);

				
			}
			
			
			
			br.close(); 
			
			return woerterArray; 
			
			
		} catch  (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
		return null; 
		
	}

}
