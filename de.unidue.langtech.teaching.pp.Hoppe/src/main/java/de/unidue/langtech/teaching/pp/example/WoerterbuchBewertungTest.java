package de.unidue.langtech.teaching.pp.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class WoerterbuchBewertungTest {

	@Test
	public void test() {
		
		int[] words = WoerterbuchBewertung.erstelle("src/test/resources/test/AFINN-111.txt"); 
		int s = -2;
		int i = 0; 
		
		assertEquals(s, words[i]); 
		
	}

}
