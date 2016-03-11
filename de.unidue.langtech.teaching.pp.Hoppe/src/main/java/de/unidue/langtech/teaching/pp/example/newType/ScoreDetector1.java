package de.unidue.langtech.teaching.pp.example.newType;

import java.util.Collection;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidu.langtech.pp.teaching.type.OpinionScore1;
import de.unidue.langtech.teaching.pp.example.WoerterbuchBewertung;
import de.unidue.langtech.teaching.pp.example.WoerterbuchWoerter;

public class ScoreDetector1 extends JCasAnnotator_ImplBase{
	
	private String [] words; 
	private int [] bewertung; 
	private String [] smiley; 
	private int [] smileyBewertung; 

	@Override 
	public void initialize(final UimaContext context) throws ResourceInitializationException {
		
		super.initialize(context);
		
		 words = WoerterbuchWoerter.erstelle("src/test/resources/test/AFINN-111.txt"); 
	     bewertung = WoerterbuchBewertung.erstelle("src/test/resources/test/AFINN-111.txt"); 
	     smiley = WoerterbuchWoerter.erstelle("src/test/resources/test/Emoticons.txt"); 
	     smileyBewertung = WoerterbuchBewertung.erstelle("src/test/resources/test/Emoticons.txt"); 
		
	}

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		Collection<Token> tokens = JCasUtil.select(aJCas, Token.class);
		        
		int positiv = 0; 
		int negativ = 0; 
		   
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
		
		OpinionScore1 score = new OpinionScore1 (aJCas);
		
		float gesamt = positiv+negativ;
		
		score.setOpinionScore(gesamt);
		score.addToIndexes();
			
	}
	
}
