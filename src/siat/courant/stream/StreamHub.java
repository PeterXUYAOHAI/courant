package siat.courant.stream;

import java.util.ArrayList;

import siat.courant.event.Event;

public class StreamHub implements StreamSubject {
	ArrayList<Streamizable> outputStreams;
	
	public StreamHub(){

		outputStreams=new ArrayList<Streamizable>();
	}
	@Override
	public void registerStream(Streamizable stream){
		outputStreams.add(stream);
	}
	
	public void receiveEvent(Event event){
		notifyStreams(event);
	}
	
	@Override
	public void notifyStreams(Event event){
		for(Streamizable s: outputStreams){
			s.addEvent(event);
		}
	}
        
        public int getCountOfOutputStreams(){
            return outputStreams.size();
        }
		public ArrayList<Streamizable> getOutputStreams(){return outputStreams;}
}
