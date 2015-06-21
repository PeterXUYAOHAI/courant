import siat.courant.engine.NFA;
import siat.courant.engine.PseudoEngine;
import siat.courant.event.Event;
import siat.courant.event.TextParser;
import siat.courant.stream.BlockingQueueStream;
import siat.courant.stream.StreamHub;
import siat.courant.stream.Streamizable;

import java.io.IOException;

/**
 * Created by asus on 2015/6/21.
 */
public class PseudoProcessorTD {
    public static void main(String[] args){
        StreamHub streamHub = new StreamHub();
        PseudoEngine pseudoEngine = new PseudoEngine();
        pseudoEngine.setNfa("test1.query");
        pseudoEngine.setInputStreamFrom(streamHub);
        TextParser textParser = new TextParser();
        textParser.readFile("test123");
        while(Event event=textParser.nextParsedEventFromFile()!=null){
        	streamHub.receiveEvent(event);
        }

        pseudoEngine.setOutputLevel(0);
        pseudoEngine.runEngine();

    }



}
