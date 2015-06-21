package siat.courant.td;

import java.io.IOException;

import siat.courant.engine.PseudoEngine;
import siat.courant.event.TextParser;
import siat.courant.event.Event;
import siat.courant.stream.StreamHub;

public class PseudoProcessorTD {
	public static void main(String[] args){
        StreamHub streamHub = new StreamHub();
        PseudoEngine pseudoEngine = new PseudoEngine();
        pseudoEngine.setNfa("test1.query");
        pseudoEngine.setInputStreamFrom(streamHub);
        TextParser textParser = new TextParser();
        try {
			textParser.readFile("test123");
			Event event;
			while((event=textParser.nextParsedEventFromFile())!=null){
        		streamHub.receiveEvent(event);
        	}
        	pseudoEngine.setOutputLevel(0);
        	pseudoEngine.runEngine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }


}
