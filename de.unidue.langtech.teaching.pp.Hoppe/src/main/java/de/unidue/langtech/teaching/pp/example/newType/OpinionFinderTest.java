package de.unidue.langtech.teaching.pp.example.newType;

import static org.junit.Assert.assertEquals;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.unidu.langtech.pp.teaching.type.OpinionFinding;

public class OpinionFinderTest {

	@Test
	public void testOpinionFinder() throws UIMAException, ArrayIndexOutOfBoundsException{
		
		JCas jcas = JCasFactory.createJCas(); 
		jcas.setDocumentText("Theo Walcott is still shit, watch Rafa and Johnny deal with him on Saturday."); 
		//jcas.setDocumentLanguage("en");
		
		
		AnalysisEngine tok = AnalysisEngineFactory.createEngine(BreakIteratorSegmenter.class);
		tok.process(jcas.getCas());
		
		
		AnalysisEngineDescription opinionFinder = AnalysisEngineFactory.createEngineDescription(OpinionFinder.class); 
		AnalysisEngine letEngine = AnalysisEngineFactory.createEngine(opinionFinder); 
		letEngine.process(jcas); 
		
		OpinionFinding opinionFound = JCasUtil.selectSingle(jcas, OpinionFinding.class); 
		String result = opinionFound.getOpinionFound(); 
		
		assertEquals("negativ", result); 
		
	}
	
}
