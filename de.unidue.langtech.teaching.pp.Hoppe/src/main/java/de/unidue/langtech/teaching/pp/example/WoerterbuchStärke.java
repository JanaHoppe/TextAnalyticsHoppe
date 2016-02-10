package de.unidue.langtech.teaching.pp.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class WoerterbuchStärke {

	public static String[] erstelle(String fileName) {
		
		FileReader fr;
		try {
			
			File file = new File(fileName);
			int length = FileUtils.readLines(file).size();
			
			fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			 
			String[] staerkeArray = new String[length]; 
			
			for (int i = 0; i < length; i++) { 
				
				String[] parts = br.readLine().split(" ");
			    String staerke = parts[0];
				String[] parts2 = staerke.split("="); 
				String staerke2 = parts2[parts2.length-1]; 
				
				staerkeArray[i] = staerke2; 
				
			}
			
			br.close(); 
			
			return staerkeArray; 
			
			
		} catch  (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
		return null; 
		
		
	}
	
}
