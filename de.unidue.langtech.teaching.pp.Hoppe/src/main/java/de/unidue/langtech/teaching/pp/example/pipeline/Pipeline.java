package de.unidue.langtech.teaching.pp.example.pipeline;

import org.apache.uima.fit.component.CasDumpWriter;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;

import de.tudarmstadt.ukp.dkpro.core.arktools.ArktweetTokenizer;
import de.tudarmstadt.ukp.dkpro.core.snowball.SnowballStemmer;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.unidue.langtech.teaching.pp.example.EvaluatorExample;
import de.unidue.langtech.teaching.pp.example.newType.OpinionFinder;
import de.unidue.langtech.teaching.pp.example.pipeline.Reader_Twitter;

public class Pipeline {

	public static void main(String[] args)
	        throws Exception
	    {
	        SimplePipeline.runPipeline(
	                CollectionReaderFactory.createReader(
	                		Reader_Twitter.class, 
	                        Reader_Twitter.PARAM_INPUT_FILE, "src/test/resources/test/Trainingsdata+Devdata-SemEval2013.txt"
	                ),
	         
	         
	                //AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class),
	                //AnalysisEngineFactory.createEngineDescription(EvaluatorExample.class),
	                //AnalysisEngineFactory.createEngineDescription(SnowballStemmer.class, SnowballStemmer.PARAM_LANGUAGE, "en"),
	                AnalysisEngineFactory.createEngineDescription(ArktweetTokenizer.class),
	                //AnalysisEngineFactory.createEngineDescription(CasDumpWriter.class),
	                AnalysisEngineFactory.createEngineDescription(OpinionFinder.class),
	                AnalysisEngineFactory.createEngineDescription(EvaluatorExample.class)
	                
	        );
	    }
	
}
