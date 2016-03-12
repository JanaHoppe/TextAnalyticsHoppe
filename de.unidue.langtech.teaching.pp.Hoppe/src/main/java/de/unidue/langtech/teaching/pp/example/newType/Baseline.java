package de.unidue.langtech.teaching.pp.example.newType;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

import de.unidu.langtech.pp.teaching.type.OpinionFinding;

public class Baseline extends JCasAnnotator_ImplBase {
	
	@Override 
    public void process(JCas jcas)  throws AnalysisEngineProcessException, ArrayIndexOutOfBoundsException
        {
			
		OpinionFinding opinionFound = new OpinionFinding (jcas); 
		
		opinionFound.setOpinionFound("neutral");
        
        opinionFound.addToIndexes();
        
    }

}
