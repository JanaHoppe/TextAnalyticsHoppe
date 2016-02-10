package de.unidue.langtech.teaching.pp.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class WoerterbuchBewertung {
	
	public static int[] erstelle(String fileName) {
		
		FileReader fr;
		try {
			
			File file = new File(fileName);
			int length = FileUtils.readLines(file).size();
			
			fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			//String[] parts = br.readLine().split("\t");
	    
			//String words = parts[0];
			//int bewertung = Integer.parseInt(parts[1]); 
			int[] bewertungArray = new int[length]; 
			
			for (int i = 0; i < length; i++) { 
				
				String[] parts = br.readLine().split("\t");
				int bewertung = Integer.parseInt(parts[1]); 
				
				bewertungArray[i] = bewertung; 
				
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
