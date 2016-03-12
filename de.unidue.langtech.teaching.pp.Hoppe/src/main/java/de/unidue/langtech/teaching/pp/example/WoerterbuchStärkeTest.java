package de.unidue.langtech.teaching.pp.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class WoerterbuchStärkeTest {

	@Test
	public void test() {
		
		String[] words = WoerterbuchStärke.erstelle("src/test/resources/test/subjclueslen1-HLTEMNLP05.txt"); 
		String s = "weaksubj";
		String i = "strongsubj";  
		
		assertEquals(s, words[0]); 
		assertEquals(i, words[22]);
		
	}

}
