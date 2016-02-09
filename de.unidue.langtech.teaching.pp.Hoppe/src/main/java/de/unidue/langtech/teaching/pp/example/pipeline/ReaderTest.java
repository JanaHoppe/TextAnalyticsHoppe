package de.unidue.langtech.teaching.pp.example.pipeline;

import static org.junit.Assert.assertEquals;

import org.apache.uima.UIMAException;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.unidue.langtech.teaching.pp.type.TweetOpinion;


public class ReaderTest {

	@Test
	public void testReader() throws UIMAException, ArrayIndexOutOfBoundsException{
		CollectionReaderDescription reader = CollectionReaderFactory
				.createReaderDescription(Reader_Twitter.class,
						Reader_Twitter.PARAM_INPUT_FILE,
						"src/test/resources/test/Trainingsdata+Devdata-SemEval2013.txt");
		
		int i = 0;
		for (JCas jcas : new JCasIterable(reader)) {
			
			TweetOpinion tweetOpinion = JCasUtil.selectSingle(jcas,TweetOpinion.class);
			
			if (i == 0) {
				assertEquals("Gas by my house hit $3.39!!!! I'm going to Chapel Hill on Sat. :)", jcas.getDocumentText()); 
				assertEquals("positive", tweetOpinion.getOpinion());
			} else if (i == 1) {
				assertEquals("Theo Walcott is still shit, watch Rafa and Johnny deal with him on Saturday.", jcas.getDocumentText()); 
				assertEquals("negative", tweetOpinion.getOpinion());
			} else if (i == 2) {
				assertEquals("its not that I'm a GSP fan, i just hate Nick Diaz. can't wait for february.", jcas.getDocumentText()); 
				assertEquals("negative", tweetOpinion.getOpinion());
			}

			i++;
		}
		
		
		
	}
	
}
