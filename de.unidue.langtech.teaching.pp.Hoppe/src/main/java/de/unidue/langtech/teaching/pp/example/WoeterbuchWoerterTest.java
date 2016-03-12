package de.unidue.langtech.teaching.pp.example;

import static org.junit.Assert.*;

import org.apache.uima.UIMAException;
import org.junit.Test;


public class WoeterbuchWoerterTest {

	@Test
	public void test() throws UIMAException {
		
		String[] words = WoerterbuchWoerter.erstelle("src/test/resources/test/AFINN-111.txt"); 
		String s = "abandon";
		String a = "discord"; 
		String b = "inquisitive"; 
		
		assertEquals(s, words[0]); 
		assertEquals(a, words[693]); 
		assertEquals(b, words[1314]); 

	}

}
