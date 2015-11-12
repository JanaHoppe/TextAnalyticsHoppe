package de.unidue.langtech.teaching.pp.example;

import java.util.Collection;

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
        
        for (Token t : tokens) {
        	if (t.getCoveredText().toLowerCase().equals("der")) {
        		deutschScore++;
        	}
        	if (t.getCoveredText().toLowerCase().equals("die")) {
        		deutschScore++;
        	}
        	if (t.getCoveredText().toLowerCase().equals("und")) {
        		deutschScore++;
        	}
        	if (t.getCoveredText().toLowerCase().equals("in")) {
        		deutschScore++;
        	}
        	if (t.getCoveredText().toLowerCase().equals("den")) {
        		deutschScore++;
        	}
        	if (t.getCoveredText().toLowerCase().equals("von")) {
        		deutschScore++;
        	}
        	if (t.getCoveredText().toLowerCase().equals("zu")) {
        		deutschScore++;
        	}
        	if (t.getCoveredText().toLowerCase().equals("das")) {
        		deutschScore++;
        	}
        	if (t.getCoveredText().toLowerCase().equals("mit")) {
        		deutschScore++;
        	}
        	if (t.getCoveredText().toLowerCase().equals("sich")) {
        		deutschScore++;
        	}
        	if (t.getCoveredText().toLowerCase().equals("the")) {
        		englischScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("be")) {
        		englischScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("to")) {
        		englischScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("of")) {
        		englischScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("and")) {
        		englischScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("a")) {
        		englischScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("in")) {
        		englischScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("that")) {
        		englischScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("have")) {
        		englischScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("i")) {
        		englischScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("le")) {
        		franzScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("de")) {
        		franzScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("un")) {
        		franzScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("a")) {
        		franzScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("etre")) {
        		franzScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("et")) {
        		franzScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("en")) {
        		franzScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("avoir")) {
        		franzScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("que")) {
        		franzScore++; 
        	}
        	if (t.getCoveredText().toLowerCase().equals("pour")) {
        		franzScore++; 
        	}
        	
        }
        
        
        DetectedLanguage languageAnno = new DetectedLanguage(jcas);
        
        if (englischScore > deutschScore && englischScore > franzScore) {
        	languageAnno.setLanguage("EN");
        }
        else if (deutschScore > englischScore && deutschScore > franzScore) {
        	languageAnno.setLanguage("DE");
        }
        else if (franzScore > deutschScore && franzScore > englischScore) {
        	languageAnno.setLanguage("FR");
        }
        else {
        	languageAnno.setLanguage("EN");
        }
        
        languageAnno.addToIndexes();
    }
}