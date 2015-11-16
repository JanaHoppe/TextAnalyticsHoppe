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
        int niederlaendischScore = 0; 
        int italienischScore = 0; 
        
        
        //Es werden Sets mit den Wörtern aus den unterschiedelichen Wörterbuchern gebildet. 
        //Diese werden durch die Klasse Woerterbuch eingelesen. 
        //Die For-Schliefe geht jedes einzelne Token eines Satzes durch und erhöht den Score einer Sprache, wenn ein Wort des Satzes auch im zur Sprache passenden Wörterbuch steht.
        //Aufgrund der vielen Woerter in den einzelnen Wörterbüchern ist dies serh zuverlässig und kann immer durch weitere Sprachen ergänzt werden. 
        try {
			Set<String> wordsEN = Woerterbuch.erstelle("src/test/resources/test/woerterbuchEnglisch.txt");
			Set<String> wordsDE = Woerterbuch.erstelle("src/test/resources/test/woerterbuchDeutsch.txt");
			Set<String> wordsFR = Woerterbuch.erstelle("src/test/resources/test/woerterbuchFranz.txt");
			Set<String> wordsES = Woerterbuch.erstelle("src/test/resources/test/woerterbuchSpanisch.txt");
			Set<String> wordsNLD = Woerterbuch.erstelle("src/test/resources/test/woerterbuchNiederlaendisch.txt");
			Set<String> wordsIT = Woerterbuch.erstelle("src/test/resources/test/woerterbuchItalienisch.txt");
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
				for (String w : wordsNLD) {
					if(t.getCoveredText().toLowerCase().equals(w.toLowerCase())) {
						niederlaendischScore++; 
					}
				}
				for (String w : wordsIT) {
					if(t.getCoveredText().toLowerCase().equals(w.toLowerCase())) {
						italienischScore++; 
					}
				}
			}
				
        } catch (IOException e) {
			e.printStackTrace();
		} 
        
        DetectedLanguage languageAnno = new DetectedLanguage(jcas);
        
        if (englischScore > deutschScore && englischScore > franzScore && englischScore > spanischScore && englischScore > niederlaendischScore && englischScore > italienischScore) {
        	languageAnno.setLanguage("EN");
        	System.out.println ("Englisch Score: " + englischScore); 
        }
        else if (deutschScore > englischScore && deutschScore > franzScore && deutschScore > spanischScore && deutschScore > niederlaendischScore && deutschScore > italienischScore) {
        	languageAnno.setLanguage("DE");
        	System.out.println ("Deutsche Score: " + deutschScore); 
        }
        else if (franzScore > deutschScore && franzScore > englischScore && franzScore > spanischScore && franzScore > niederlaendischScore && franzScore > italienischScore) {
        	languageAnno.setLanguage("FR");
        	System.out.println ("Franzoesisch Score: " + franzScore); 
        }
        else if (spanischScore > deutschScore && spanischScore > englischScore && spanischScore > franzScore && spanischScore > niederlaendischScore && spanischScore > italienischScore) {
        	languageAnno.setLanguage("ES");
        	System.out.println ("Spanisch Score: " + spanischScore); 
        }
        else if (niederlaendischScore > deutschScore && niederlaendischScore > englischScore && niederlaendischScore > franzScore && niederlaendischScore > spanischScore && niederlaendischScore > italienischScore) {
        	languageAnno.setLanguage("NLD");
        	System.out.println ("Niederlaendisch Score: " + niederlaendischScore); 
        }
        else if (italienischScore > deutschScore && italienischScore > englischScore && italienischScore > franzScore && italienischScore > spanischScore && italienischScore > niederlaendischScore) {
        	languageAnno.setLanguage("IT");
        	System.out.println ("Italienisch Score: " + italienischScore); 
        }
        else {
        	languageAnno.setLanguage("EN");
        }
        
        languageAnno.addToIndexes();
    }
}