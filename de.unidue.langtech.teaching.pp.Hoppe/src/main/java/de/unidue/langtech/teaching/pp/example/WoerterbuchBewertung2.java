package de.unidue.langtech.teaching.pp.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class WoerterbuchBewertung2 {
	
	public static String[] erstelle(String fileName) {
		
		FileReader fr;
		try {
			
			File file = new File(fileName);
			int length = FileUtils.readLines(file).size();
			
			fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			 
			String[] bewertungArray = new String[length]; 
			
			for (int i = 0; i < length; i++) { 
				
				String[] parts = br.readLine().split(" ");
			    String bewertung = parts[5];
				String[] parts2 = bewertung.split("="); 
				String bewertung2 = parts2[parts2.length-1]; 
				
				bewertungArray[i] = bewertung2; 
				
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


