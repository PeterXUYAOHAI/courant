package siat.courant.stream;

import java.util.ArrayList;

import siat.courant.event.Event;

public class StreamHub implements StreamSubject {
	ArrayList<Streamizable> outputStreams;
	
	public StreamHub(){
		outputStreams=new ArrayList<Streamizable>();
	}
	public void registerStream(Streamizable stream){
		outputStreams.add(stream);
	}
	
	public void receiveEvent(Event event){
		notifyStreams(event);
	}
	
	public void notifyStreams(Event event){
		for(Streamizable s: outputStreams){
			s.addEvent(event);
		}
	}
}
