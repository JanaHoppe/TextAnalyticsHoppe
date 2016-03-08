package de.unidue.langtech.teaching.pp.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class WoerterbuchStärkeTest {

	@Test
	public void test() {
		
		String[] words = WoerterbuchStärke.erstelle("src/test/resources/test/subjclueslen1-HLTEMNLP05.txt"); 
		String s = "weaksubj";
		int i = 0; 
		
		assertEquals(s, words[i]); 
		
	}

}
