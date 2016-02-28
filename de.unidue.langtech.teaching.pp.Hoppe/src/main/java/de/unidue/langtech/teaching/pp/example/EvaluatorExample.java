package de.unidue.langtech.teaching.pp.example;



import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.unidu.langtech.pp.teaching.type.OpinionFinding;
import de.unidue.langtech.teaching.pp.type.TweetOpinion;

public class EvaluatorExample
    extends JCasAnnotator_ImplBase
{

    private int correct;
    private int nrOfDocuments;
    private int positiv; 
    private int negativ; 
    private int neutral; 
    private float percent; 
    
    private int correctPositiv; 
    private int falseNegativPositiv; 
    private int falseNeutralPositiv; 
    
    private int correctNegativ; 
    private int falsePositivNegativ; 
    private int falseNeutralNegativ; 
    
    private int correctNeutral; 
    private int falsePositivNeutral; 
    private int falseNegativNeutral; 
    
    /* 
     * This is called BEFORE any documents are processed.
     */
    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
        super.initialize(context);
        correct = 0;
        nrOfDocuments = 0;
        positiv = 0; 
        negativ = 0; 
        neutral = 0; 
        percent = 0;
        
        correctPositiv = 0; 
        falseNegativPositiv = 0; 
        falseNeutralPositiv = 0;
        
        correctNegativ = 0; 
        falsePositivNegativ = 0; 
        falseNeutralNegativ = 0; 
        
        correctNeutral = 0; 
        falsePositivNeutral = 0; 
        falseNegativNeutral = 0; 
    }
    
    
    /* 
     * This is called ONCE for each document
     */
    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
        
    	OpinionFinding detected = JCasUtil.selectSingle(jcas, OpinionFinding.class);
        TweetOpinion actual = JCasUtil.selectSingle(jcas, TweetOpinion.class);
        
        if (detected.getOpinionFound().equals(actual.getOpinion())) {
    		correct++; 
    	}
        
        if(detected.getOpinionFound().equals("positive")) {
    		positiv+=1; 
    		switch(actual.getOpinion()) {
    		case "positive": correctPositiv++; break; 
    		case "negative": falseNegativPositiv++; break; 
    		case "neutral": falseNeutralPositiv++; break; 
    		}
    	}
    	else if(detected.getOpinionFound().equals("negative")) {
    		negativ+=1; 
    		switch(actual.getOpinion()) {
    		case "positive": falsePositivNegativ++; break; 
    		case "negative": correctNegativ++; break;
    		case "neutral": falseNeutralNegativ++; break; 
    		}
    	}
    	else if(detected.getOpinionFound().equals("neutral")) {
    		neutral+=1; 
    		switch(actual.getOpinion()) {
    		case "positive": falsePositivNeutral++; break;
    		case "negative": falseNegativNeutral++; break; 
    		case "neutral": correctNeutral++; break; 
 
    		}
    	}
        
        nrOfDocuments++; 
        
        // FIXME: Keep track of correctly classified documents! 
    }


    /* 
     * This is called AFTER all documents have been processed.
     */
    @Override
    public void collectionProcessComplete()
        throws AnalysisEngineProcessException
    {
        super.collectionProcessComplete();
        
        percent = (float) correct/(float) nrOfDocuments*100f; 
        
        System.out.println(correct + " out of " + nrOfDocuments + " are correct.");
        System.out.println("Dies sind " + percent + " % aller Tweets.");
        System.out.println("Es wurden " + positiv + " als positiv erkannt");
        System.out.println("Davon wurden " + correctPositiv + " richtigerweise als positiv erkannt, " + falseNegativPositiv + " waren eigentlich negativ und " + falseNeutralPositiv + " waren eigentlich neutral");
        System.out.println("Es wurden " + negativ + " als negativ erkannt");
        System.out.println("Davon wurden " + correctNegativ + " richtigerweise als negativ erkannt, " + falsePositivNegativ + " waren eigentlich positiv und " + falseNeutralNegativ + " waren eigentlich neutral");
        System.out.println("Es wurden " + neutral + " als neutral erkannt");
        System.out.println("Davon wurden " + correctNeutral + " richtigerweise als neutral erkannt, " + falsePositivNeutral + " waren eigentlich positiv und " + falseNegativNeutral + " waren eigentlich negativ");
    }
}