package de.unidue.langtech.teaching.pp.example.newType;

import static org.junit.Assert.*;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.junit.Test;

import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.unidu.langtech.pp.teaching.type.OpinionFinding;
import de.unidu.langtech.pp.teaching.type.OpinionScore1;

public class ScoreDetector1Test {

	@Test
	public void test() throws UIMAException {
		
		JCas jcas = JCasFactory.createJCas(); 
		jcas.setDocumentText("");
		
		AnalysisEngine tok = AnalysisEngineFactory.createEngine(BreakIteratorSegmenter.class);
		tok.process(jcas.getCas()); 
		
		AnalysisEngineDescription scoreDetector = AnalysisEngineFactory.createEngineDescription(ScoreDetector1.class); 
		AnalysisEngine letEngine = AnalysisEngineFactory.createEngine(scoreDetector); 
		letEngine.process(jcas);
		
		OpinionScore1 score = JCasUtil.selectSingle(jcas, OpinionScore1.class); 
		float result = score.getOpinionScore();
		
		 
		
	}

}
