package de.unidue.langtech.teaching.pp.example.newType;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidu.langtech.pp.teaching.type.OpinionFinding;
import de.unidue.langtech.teaching.pp.example.AdjektivMitBewertung;
import de.unidue.langtech.teaching.pp.example.AdjektivWörterbuch;


public class OpinionFinder extends JCasAnnotator_ImplBase{
	
	@Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
		String documentText = jcas.getDocumentText();
		
		Collection<Token> tokens = JCasUtil.select(jcas, Token.class);
        System.out.println("CAS contains " + tokens.size() + " tokens.");
        
        int positiv = 0; 
        int negativ = 0; 
        int neutral = 0; 
        
        try {
			Set<AdjektivMitBewertung> words = AdjektivWörterbuch.erstelle("src/test/resources/test/AFINN-111.txt");
			
			 for (Token t : tokens) {
		    	   for (AdjektivMitBewertung w : words) {
						if(w.equals(documentText)) {
							if (w.getBewertung() > 0) {
								positiv+=w.getBewertung(); 
							}
							if (w.getBewertung() < 0) {
								negativ+=w.getBewertung(); 
							}
							if (w.getBewertung() == 0) {
								neutral+=w.getBewertung(); 
							}
						}
		    	   }
		       }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
    }
	
}
