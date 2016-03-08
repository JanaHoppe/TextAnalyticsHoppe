package de.unidue.langtech.teaching.pp.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class WoerterbuchWoerter2Test {

	@Test
	public void test() {
		
		String[] words = WoerterbuchWoerter2.erstelle("src/test/resources/test/subjclueslen1-HLTEMNLP05.txt"); 
		String s = "abandoned";
		int i = 0; 
		
		assertEquals(s, words[i]); 
		
	}

}
