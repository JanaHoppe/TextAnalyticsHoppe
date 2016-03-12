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

	private int actualPos; 
	private int actualNeg; 
	private int actualNeu; 
	
	private float precisionPos; 
	private float recallPos;
	private float measurePos;
	
	private float precisionNeg; 
	private float recallNeg;
	private float measureNeg;
	
	private float precisionNeu; 
	private float recallNeu;
	private float measureNeu;
	
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
    
    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
        super.initialize(context);
        
        actualPos = 0; 
        actualNeg = 0; 
        actualNeu = 0; 
        
        precisionPos = 0; 
    	recallPos = 0;
    	measurePos = 0;
    	
    	precisionNeg = 0; 
    	recallNeg = 0;
    	measureNeg = 0;
    	
    	precisionNeu = 0; 
    	recallNeu = 0;
    	measureNeu = 0;
        
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
    
    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
        
    	OpinionFinding detected = JCasUtil.selectSingle(jcas, OpinionFinding.class);
        TweetOpinion actual = JCasUtil.selectSingle(jcas, TweetOpinion.class);
        
        if (actual.getOpinion().equals("positive")) {
        	actualPos++; 
        }
        else if (actual.getOpinion().equals("negative")) {
        	actualNeg++; 
        }
        else if (actual.getOpinion().equals("neutral")) {
        	actualNeu++; 
        }
        
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
    }

    @Override
    public void collectionProcessComplete()
        throws AnalysisEngineProcessException
    {
        super.collectionProcessComplete();
        
        precisionPos = (float) correctPositiv / ( (float) correctPositiv + (float) falseNegativPositiv +  (float) falseNeutralPositiv) * 100; 
    	recallPos = ((float) correctPositiv / (float) actualPos) * 100;
    	measurePos = (2 * precisionPos * recallPos) / (precisionPos + recallPos);
    	
    	precisionNeg = (float) correctNegativ / ( (float) correctNegativ + (float) falsePositivNegativ + (float) falseNeutralNegativ) * 100; 
    	recallNeg = ((float) correctNegativ / (float) actualNeg) * 100;
    	measureNeg = (2 * precisionNeg * recallNeg) / (precisionNeg + recallNeg);
    	
    	precisionNeu = (float) correctNeutral / ( (float) correctNeutral + (float) falseNegativNeutral + (float) falsePositivNeutral) * 100; 
    	recallNeu = ((float) correctNeutral / (float) actualNeu) * 100;
    	measureNeu = (2 * precisionNeu * recallNeu) / (precisionNeu + recallNeu);
        
        percent = (float) correct/(float) nrOfDocuments*100f; 
        
        System.out.println("Die Trainingsdaten umfassen " + nrOfDocuments + " Tweets.");
        System.out.println("Von diesen sind " + actualPos + " positive Tweets, " + actualNeg + " negative Tweets und " + actualNeu + " neutrale Tweets.");
        System.out.println("-------------------------------------------------------------------------------------" + "\n");
        System.out.println("Die Berechnung mit diesem Programm ergab folgende Ergebnisse:" + "\n"); 
        System.out.println("Von den " + nrOfDocuments + " wurden " + correct + " richtig erkannt.");
        System.out.println("Dies sind " + percent + " % aller Tweets." + "\n");
        System.out.println("Es wurden " + positiv + " als positiv erkannt");
        System.out.println("Davon wurden " + correctPositiv + " richtigerweise als positiv erkannt, " + falseNegativPositiv + " waren eigentlich negativ und " + falseNeutralPositiv + " waren eigentlich neutral");
        System.out.println("Precision: " + precisionPos + " %, Recall: " + recallPos + " %, F-Measure: " + measurePos + " %." + "\n"); 
        System.out.println("Es wurden " + negativ + " als negativ erkannt");
        System.out.println("Davon wurden " + correctNegativ + " richtigerweise als negativ erkannt, " + falsePositivNegativ + " waren eigentlich positiv und " + falseNeutralNegativ + " waren eigentlich neutral");
        System.out.println("Precision: " + precisionNeg + " %, Recall: " + recallNeg + " %, F-Measure: " + measureNeg + " %." + "\n"); 
        System.out.println("Es wurden " + neutral + " als neutral erkannt");
        System.out.println("Davon wurden " + correctNeutral + " richtigerweise als neutral erkannt, " + falsePositivNeutral + " waren eigentlich positiv und " + falseNegativNeutral + " waren eigentlich negativ");
        System.out.println("Precision: " + precisionNeu + " %, Recall: " + recallNeu + " %, F-Measure: " + measureNeu + " %."); 
    }
}