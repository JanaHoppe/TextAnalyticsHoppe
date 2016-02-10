package de.unidue.langtech.teaching.pp.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class WoerterbuchWoerter2 {
	
	public static String[] erstelle(String fileName) {
		
		FileReader fr;
		try {
			
			File file = new File(fileName);
			int length = FileUtils.readLines(file).size();
			
			fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String[] woerterArray = new String[length]; 
			
			for (int i = 0; i < length; i++) { 
				
				String[] parts = br.readLine().split(" ");
			    String words = parts[2];
				String[] parts2 = words.split("="); 
				String words2 = parts2[1]; 
				
				woerterArray[i] = words2; 
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
