package de.unidue.langtech.teaching.pp.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class WoerterbuchBewertung2Test {

	@Test
	public void test() {
		
		String[] words = WoerterbuchBewertung2.erstelle("src/test/resources/test/subjclueslen1-HLTEMNLP05.txt"); 
		String s = "negative";
		String a = "positive"; 
		String b = "neutral"; 
		
		assertEquals(s, words[0]);
		assertEquals(a, words[18]); 
		assertEquals(b, words[45]); 
		
	}

}
