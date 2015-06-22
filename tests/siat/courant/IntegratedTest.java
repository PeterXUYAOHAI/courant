package siat.courant;

import org.junit.Before;
import org.junit.Test;

import siat.courant.engine.PseudoEngine;
import siat.courant.event.*;
import siat.courant.stream.StreamHub;
import java.io.IOException;
/**
 * Created by asus on 2015/6/19.
 */
public class IntegratedTest {
    EventFactory stockEventFactory;
    EventFactory class3EventFactory;
    Event e1;
    Event e2;
    Event e3;
    Event e4;
    PseudoEngine pseudoEngine;
    StreamHub streamHub;
    TextParser tp1;

    @Before
    public void setUp(){

    }

    @Test
    public void testFromFactoryToOutput() throws IOException {
        stockEventFactory = new StockEventFactory();
        class3EventFactory = new Class3EventFactory();
        e1 = stockEventFactory.createEvent();
        e2 = class3EventFactory.createEvent("outg", 888, 0, 1234);
        e3 = class3EventFactory.createEvent("inr", 888, 0, 123, 423432);
        e4 = stockEventFactory.createEvent();
        pseudoEngine = new PseudoEngine();
        streamHub = new StreamHub();
        pseudoEngine.setInputStreamFrom(streamHub);
        streamHub.notifyStreams(e1);
        streamHub.notifyStreams(e2);
        streamHub.notifyStreams(e3);
        streamHub.notifyStreams(e4);
        pseudoEngine.setNfa("test1.query");
        pseudoEngine.runEngine();
        tp1 = new TextParser();
        tp1.readFile("test2");
        System.out.println(tp1.nextParsedEventFromFile().getEventType());
        System.out.println(tp1.nextParsedEventFromFile().getEventType());
        System.out.println(tp1.nextParsedEventFromFile().getEventType());
        System.out.println(tp1.nextParsedEventFromFile().getEventType());
    }

}
