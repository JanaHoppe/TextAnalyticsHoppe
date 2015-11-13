package de.unidue.langtech.teaching.pp.example;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidue.langtech.teaching.pp.type.DetectedLanguage;

/**
 * The baseline always identifies "EN" as the document language.
 * 
 * @author zesch
 *
 */
public class BaselineExample
    extends JCasAnnotator_ImplBase
{

    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
        System.out.println("Document is: " + jcas.getDocumentText());
        
        Collection<Token> tokens = JCasUtil.select(jcas, Token.class);
        System.out.println("CAS contains " + tokens.size() + " tokens.");
        
        int deutschScore = 0; 
        int englischScore = 0; 
        int franzScore = 0;
        int spanischScore = 0; 
        
        try {
			Set<String> wordsEN = Woerterbuch.erstelle("src/test/resources/test/woerterbuchEnglisch.txt");
			Set<String> wordsDE = Woerterbuch.erstelle("src/test/resources/test/woerterbuchDeutsch.txt");
			Set<String> wordsFR = Woerterbuch.erstelle("src/test/resources/test/woerterbuchFranz.txt");
			Set<String> wordsES = Woerterbuch.erstelle("src/test/resources/test/woerterbuchSpanisch.txt");
			for (Token t : tokens) {
				for (String w : wordsEN) {
					if(t.getCoveredText().toLowerCase().equals(w.toLowerCase())) {
						englischScore++; 
					}
				}
				for (String w : wordsDE) {
					if(t.getCoveredText().toLowerCase().equals(w.toLowerCase())) {
						deutschScore++; 
					}
				}
				for (String w : wordsFR) {
					if(t.getCoveredText().toLowerCase().equals(w.toLowerCase())) {
						franzScore++; 
					}
				}
				for (String w : wordsES) {
					if(t.getCoveredText().toLowerCase().equals(w.toLowerCase())) {
						spanischScore++; 
					}
				}
			}
				
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        DetectedLanguage languageAnno = new DetectedLanguage(jcas);
        
        if (englischScore > deutschScore && englischScore > franzScore && englischScore > spanischScore) {
        	languageAnno.setLanguage("EN");
        	System.out.println ("Englisch Score: " + englischScore); 
        }
        else if (deutschScore > englischScore && deutschScore > franzScore && deutschScore > spanischScore) {
        	languageAnno.setLanguage("DE");
        	System.out.println ("Deutsche Score: " + deutschScore); 
        }
        else if (franzScore > deutschScore && franzScore > englischScore && franzScore > spanischScore) {
        	languageAnno.setLanguage("FR");
        	System.out.println ("Franzoesisch Score: " + franzScore); 
        }
        else if (spanischScore > deutschScore && spanischScore > englischScore && spanischScore > franzScore) {
        	languageAnno.setLanguage("ES");
        	System.out.println ("Spanisch Score: " + spanischScore); 
        }
        else {
        	languageAnno.setLanguage("EN");
        }
        
        languageAnno.addToIndexes();
    }
}