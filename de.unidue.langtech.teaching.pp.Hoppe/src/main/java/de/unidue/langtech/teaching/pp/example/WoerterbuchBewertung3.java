package de.unidue.langtech.teaching.pp.example;

public class WoerterbuchBewertung3 {
		 
	public static int[] erstelle() {
			
			String[] bewertung2 = WoerterbuchBewertung2.erstelle("src/test/resources/test/subjclueslen1-HLTEMNLP05.txt");
	        String[] staerke = WoerterbuchStärke.erstelle("src/test/resources/test/subjclueslen1-HLTEMNLP05.txt");
	        int [] bewertungArray = new int[bewertung2.length]; 
	   
			
			for (int i = 0; i < bewertungArray.length; i++) { 
				
				if ((bewertung2[i].equals("positive")) && (staerke[i].equals("strongsubj"))) {
					bewertungArray[i]=2; 
				} 
				else if ((bewertung2[i].equals("positive")) && (staerke[i].equals("weaksubj"))) {
					bewertungArray[i]=1; 
				} 
				else if ((bewertung2[i].equals("negative")) && (staerke[i].equals("strongsubj"))) {
					bewertungArray[i]=-3; 
				} 
				else if ((bewertung2[i].equals("negative")) && (staerke[i].equals("weaksubj"))) {
					bewertungArray[i]=-1; 
				} 
				else if (bewertung2[i].equals("neutral")) {
					bewertungArray[i]=0; 
				}
			}
			
			return bewertungArray; 
		
	}
	
}
