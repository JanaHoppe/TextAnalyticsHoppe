package de.unidue.langtech.teaching.pp.example.newType;

import java.util.Collection;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidu.langtech.pp.teaching.type.OpinionFinding;
import de.unidue.langtech.teaching.pp.example.WoerterbuchBewertung;
import de.unidue.langtech.teaching.pp.example.WoerterbuchWoerter;


public class OpinionFinder extends JCasAnnotator_ImplBase{
	
	@Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException, ArrayIndexOutOfBoundsException
        {
		
		//String documentText = jcas.getDocumentText();
		
		Collection<Token> tokens = JCasUtil.select(jcas, Token.class);
        //System.out.println("CAS contains " + tokens.size() + " tokens.");
        
        
        int positiv = 0; 
        int negativ = 0; 
        
        String[] words = WoerterbuchWoerter.erstelle("src/test/resources/test/AFINN-111.txt"); 
        int[] bewertung = WoerterbuchBewertung.erstelle("src/test/resources/test/AFINN-111.txt"); 
        String[] smiley = WoerterbuchWoerter.erstelle("src/test/resources/test/Emoticons.txt"); 
        int[] smileyBewertung = WoerterbuchBewertung.erstelle("src/test/resources/test/Emoticons.txt"); 
			
		for (Token t : tokens) {
				 
		    for (int i=0; i < words.length; i++) {
		    		   
		    	if(words[i].equals(t.getCoveredText())) {
					if (bewertung[i] > 0) {
						positiv+=bewertung[i]; 
					}
					if (bewertung[i] < 0) {
						negativ+=bewertung[i]; 
					}
		    	}
		    }
		    
		    for (int j = 0; j < smiley.length; j++) {
		    	
		    	if(smiley[j].equals(t.getCoveredText())) {
		    		
		    		if (smileyBewertung[j] > 0) {
		    			positiv+=smileyBewertung[j]; 
		    		}
		    		if (smileyBewertung[j] < 0) {
		    			negativ+=smileyBewertung[j]; 
		    		}
		    	}
		    }
		}
			
		OpinionFinding opinionFound = new OpinionFinding (jcas);
		
		int gesamt = positiv+negativ; 
        
        if (gesamt > 1) {
        	opinionFound.setOpinionFound("positiv");
        } 
        else if (gesamt < -1.5f) {
        	opinionFound.setOpinionFound("negativ");
        }
        else {
        	opinionFound.setOpinionFound("neutral");
        }
        
        opinionFound.addToIndexes();
        
    }
	
}
