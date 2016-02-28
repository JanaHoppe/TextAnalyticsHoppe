package de.unidue.langtech.teaching.pp.example.newType;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.unidu.langtech.pp.teaching.type.OpinionFinding;
import de.unidu.langtech.pp.teaching.type.OpinionScore1;
import de.unidu.langtech.pp.teaching.type.OpinionScore2;


public class OpinionFinder extends JCasAnnotator_ImplBase{
	
	@Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException, ArrayIndexOutOfBoundsException
        {
		
		float score1 = JCasUtil.selectSingle(jcas, OpinionScore1.class).getOpinionScore(); 
		float score2 = JCasUtil.selectSingle(jcas, OpinionScore2.class).getOpinionScore(); 
		
		float gesamt = (score1 + score2)/2; 
			
		OpinionFinding opinionFound = new OpinionFinding (jcas); 
        
        if (gesamt > 1) {
        	opinionFound.setOpinionFound("positive");
        } 
        else if (gesamt < -1.5f) {
        	opinionFound.setOpinionFound("negative");
        }
        else {
        	opinionFound.setOpinionFound("neutral");
        }
        
        opinionFound.addToIndexes();
        
    }
	
}
