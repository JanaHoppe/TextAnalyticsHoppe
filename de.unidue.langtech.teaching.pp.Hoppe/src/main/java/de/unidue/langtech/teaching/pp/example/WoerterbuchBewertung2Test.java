package de.unidue.langtech.teaching.pp.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class WoerterbuchBewertung2Test {

	@Test
	public void test() {
		
		String[] words = WoerterbuchBewertung2.erstelle("src/test/resources/test/subjclueslen1-HLTEMNLP05.txt"); 
		String s = "negative";
		int i = 0; 
		
		assertEquals(s, words[i]); 
		
	}

}
