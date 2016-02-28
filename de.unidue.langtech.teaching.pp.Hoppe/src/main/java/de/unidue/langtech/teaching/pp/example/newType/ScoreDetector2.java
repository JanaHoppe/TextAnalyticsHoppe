package de.unidue.langtech.teaching.pp.example.newType;

import java.util.Collection;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidu.langtech.pp.teaching.type.OpinionScore2;
import de.unidue.langtech.teaching.pp.example.WoerterbuchBewertung3;
import de.unidue.langtech.teaching.pp.example.WoerterbuchWoerter2;

public class ScoreDetector2 extends JCasAnnotator_ImplBase {
	
	private String [] words; 
	private int [] bewertung; 

	@Override 
	public void initialize(final UimaContext context) throws ResourceInitializationException {
		
		super.initialize(context);
		
		words = WoerterbuchWoerter2.erstelle("src/test/resources/test/subjclueslen1-HLTEMNLP05.txt");
		bewertung = WoerterbuchBewertung3.erstelle(); 
		
	}

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		Collection<Token> tokens = JCasUtil.select(aJCas, Token.class);
		        
		int positiv = 0; 
		int negativ = 0; 
		int neutral = 0; 
		   
		for (Token t : tokens) {
						 
			for (int i=0; i < words.length; i++) {
				    		   
				if(words[i].equals(t.getCoveredText())) {
					if (bewertung[i] > 0) {
						positiv+=bewertung[i]; 
					}
					if (bewertung[i] < 0) {
						negativ+=bewertung[i]; 
					}
					if (bewertung[i] == 0) {
						neutral+=bewertung[i]; 
					}
				}
			}
				   
		}
		
		OpinionScore2 score = new OpinionScore2 (aJCas);
		
		float gesamt = positiv+negativ+neutral;
		
		score.setOpinionScore(gesamt);
		score.addToIndexes();
			
	}
	
}
