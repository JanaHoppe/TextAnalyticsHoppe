package de.unidue.langtech.teaching.pp.example;

public class WoerterbuchBewertung3 {
		 
	public static int[] erstelle() {
			
			String[] bewertung2 = WoerterbuchBewertung2.erstelle("src/test/resources/test/subjclueslen1-HLTEMNLP05.txt");
	        String[] staerke = WoerterbuchStärke.erstelle("src/test/resources/test/subjclueslen1-HLTEMNLP05.txt");
	        int [] bewertungArray = new int[bewertung2.length]; 
	   
			
			for (int i = 0; i < bewertungArray.length; i++) { 
				
				if (bewertung2[i] == "positive" && staerke[i] == "strongsubj") {
					bewertungArray[i]=4; 
				} 
				else if (bewertung2[i] == "positive" && staerke[i] == "weaksubj") {
					bewertungArray[i]=1; 
				} 
				else if (bewertung2[i] == "negative" && staerke[i] == "strongsubj") {
					bewertungArray[i]=-4; 
				} 
				else if (bewertung2[i] == "negative" && staerke[i] == "weaksubj") {
					bewertungArray[i]=-1; 
				} 
				else if (bewertung2[i] == "neutral") {
					bewertungArray[i]=0; 
				}
			}
			
		
			
			return bewertungArray; 
		
	}
	
}
