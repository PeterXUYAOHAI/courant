package siat.courant.engine;

import siat.courant.stream.BlockingQueueStream;
import siat.courant.stream.StreamHub;
import siat.courant.stream.Streamizable;

public class PseudoEngine {
	Streamizable stream;
	public PseudoEngine(){
		stream=new BlockingQueueStream();
	}
	
	public void setInputStream(StreamHub streamHub){
		streamHub.registerStream(stream);
	}
		
	
	public void printStream(){
		stream.printStream();
	}

}
