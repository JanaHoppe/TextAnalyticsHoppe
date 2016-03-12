package de.unidue.langtech.teaching.pp.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class WoerterbuchBewertung3Test {

	@Test
	public void test() {
		 
		int[] bewertung = WoerterbuchBewertung3.erstelle(); 
		int a = 0; 
		int b = 1; 
		int c = 2; 
		int d= -2; 
		int i = -1; 
		
		assertEquals(i, bewertung[0]);
		assertEquals(a, bewertung[46]); 
		assertEquals(b, bewertung[24]); 
		assertEquals(c, bewertung[18]); 
		assertEquals(d, bewertung[3]); 
		
	}

}
