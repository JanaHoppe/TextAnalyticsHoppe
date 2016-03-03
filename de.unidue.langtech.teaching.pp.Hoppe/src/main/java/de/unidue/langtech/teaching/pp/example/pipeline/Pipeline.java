package de.unidue.langtech.teaching.pp.example.pipeline;

import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;

import de.tudarmstadt.ukp.dkpro.core.arktools.ArktweetTokenizer;
import de.unidue.langtech.teaching.pp.example.EvaluatorExample;
import de.unidue.langtech.teaching.pp.example.newType.OpinionFinder;
import de.unidue.langtech.teaching.pp.example.newType.ScoreDetector1;
import de.unidue.langtech.teaching.pp.example.newType.ScoreDetector2;
import de.unidue.langtech.teaching.pp.example.pipeline.Reader_Twitter;

public class Pipeline {

	public static void main(String[] args)
	        throws Exception
	    {
	        SimplePipeline.runPipeline(
	                CollectionReaderFactory.createReader(
	                		Reader_Twitter.class, 
	                        Reader_Twitter.PARAM_INPUT_FILE, "src/test/resources/test/Daten.txt"
	                ),
	         
	         
	                AnalysisEngineFactory.createEngineDescription(ArktweetTokenizer.class),
	                AnalysisEngineFactory.createEngineDescription(ScoreDetector1.class),
	                AnalysisEngineFactory.createEngineDescription(ScoreDetector2.class),
	                AnalysisEngineFactory.createEngineDescription(OpinionFinder.class),
	                AnalysisEngineFactory.createEngineDescription(EvaluatorExample.class)
	                
	        );
	    }
	
}
