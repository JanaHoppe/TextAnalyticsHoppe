package de.unidue.langtech.teaching.pp.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class WoerterbuchBewertungTest {

	@Test
	public void test() {
		
		int[] words = WoerterbuchBewertung.erstelle("src/test/resources/test/AFINN-111.txt"); 
		int s = -2;
		int a = 1; 
		int b = -4;
		
		assertEquals(s, words[0]); 
		assertEquals(a, words[42]);
		assertEquals(b, words[182]);
		
	}

}
