package de.unidue.langtech.teaching.pp.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WoerterbuchBewertung {
	
	public static int[] erstelle(String fileName) {
		
		FileReader fr;
		try {
			fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			//String[] parts = br.readLine().split("\t");
	    
			//String words = parts[0];
			//int bewertung = Integer.parseInt(parts[1]); 
			int[] bewertungArray = new int[2476]; 
			
			for (int i = 0; i < 2476; i++) { 
				
				String[] parts = br.readLine().split("\t");
				int bewertung = Integer.parseInt(parts[1]); 
				
				bewertungArray[i] = bewertung; 
				
				System.out.println(bewertungArray[i]);
				
				
			}
			
			br.close(); 
			
			return bewertungArray; 
			
			
		} catch  (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
		return null; 
		
		
	}

}
