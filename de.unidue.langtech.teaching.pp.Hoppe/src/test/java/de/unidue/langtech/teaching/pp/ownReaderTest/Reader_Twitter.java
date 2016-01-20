package de.unidue.langtech.teaching.pp.ownReaderTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.fit.component.JCasCollectionReader_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidue.langtech.teaching.pp.type.TweetOpinion;

public class Reader_Twitter extends JCasCollectionReader_ImplBase
{
	
	 public static final String PARAM_INPUT_FILE = "InputFile";
	    @ConfigurationParameter(name = PARAM_INPUT_FILE, mandatory = true)
	    private File inputFile;

	    private List<String> lines;
	    private int currentLine;
	    
	    @Override 
	    public void initialize(UimaContext context)
	        throws ResourceInitializationException
	    {
	        initialize(context);

	        try {
	            lines = FileUtils.readLines(inputFile);
	            currentLine = 0;
	        }
	        catch (IOException e) {
	            throw new ResourceInitializationException(e);
	        }
	    }

	    public boolean hasNext()
	        throws IOException, CollectionException
	    {
	        return currentLine < lines.size();
	    }

	    public Progress[] getProgress()
	    {
	        return null;
	    }

	    public void getNext(JCas aJCas)
	        throws IOException, CollectionException
	        {
	        
	        String[] parts = lines.get(currentLine).split("\t"); 
	        
	        if (parts.length != 3) {
	            throw new IOException("Wrong line format: " + lines.get(currentLine));
	        }
	        
	        TweetOpinion tweetOpinion = new TweetOpinion (aJCas); 
	        tweetOpinion.setOpinion(parts[2]); 
	        tweetOpinion.addToIndexes(); 
	        
	        aJCas.setDocumentText(parts[3]); 
	    }

}
