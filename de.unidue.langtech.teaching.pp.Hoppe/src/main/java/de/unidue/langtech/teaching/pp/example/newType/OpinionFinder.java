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
		
		 System.out.println("Document is: " + jcas.getDocumentText());
		
		Collection<Token> tokens = JCasUtil.select(jcas, Token.class);
        System.out.println("CAS contains " + tokens.size() + " tokens.");
        
        
        int positiv = 0; 
        int negativ = 0; 
        	
		//Set<AdjektivMitBewertung> words = AdjektivWörterbuch.erstelle("src/test/resources/test/AFINN-111.txt");
		//Iterator iter = words.iterator(); 
        
        String[] words = WoerterbuchWoerter.erstelle("src/test/resources/test/AFINN-111.txt"); 
        int[] bewertung = WoerterbuchBewertung.erstelle("src/test/resources/test/AFINN-111.txt"); 
			
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
		       }
			
		OpinionFinding opinionFound = new OpinionFinding (jcas);
        
        if (Math.abs(positiv) > Math.abs(negativ)) {
        	opinionFound.setOpinionFound("positiv");
        } 
        else if (Math.abs(negativ) > Math.abs(positiv)) {
        	opinionFound.setOpinionFound("negativ"); 
        }
        else if (Math.abs(positiv) == Math.abs(negativ)) {
        	opinionFound.setOpinionFound("neutral");
        }
        
        opinionFound.addToIndexes();
        
        System.out.println(jcas.getDocumentText() + " " + opinionFound);
        
    }
	
}
