package siat.courant.stream;

import siat.courant.event.Event;
import siat.courant.event.Geo3in;
import siat.courant.event.Rfid3in;
import siat.courant.event.StockEvent;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by asus on 2015/6/15.
 */
public class StreamHubTest {
    StreamHub streamHub;
    Streamizable stream1;
    Streamizable stream2;
    Streamizable stream3;
    Event event1;
    Event event2;

    @org.junit.Before
    public void setUp() throws Exception {
        streamHub=new StreamHub();
        stream1=new BlockingQueueStream();
        stream2=new BlockingQueueStream();
        stream3=new BlockingQueueStream();
        event1=new StockEvent();
        event2=new StockEvent();

    }

    @org.junit.Test
    public void testRegisterStream() throws Exception {
        assertEquals(0, streamHub.getCountOfOutputStreams());
       streamHub.registerStream(stream1);
        streamHub.registerStream(stream2);
        streamHub.registerStream(stream3);
        assertEquals(3, streamHub.getCountOfOutputStreams());
    }

    @org.junit.Test
    public void testNotifyStreams() throws Exception {
        streamHub.registerStream(stream1);
        streamHub.registerStream(stream2);
        ArrayList<Streamizable> outputstreams = streamHub.getOutputStreams();
        for(Streamizable e:outputstreams)
            assertEquals(0,e.getSize());
        streamHub.notifyStreams(event1);
        streamHub.notifyStreams(event2);
        for(Streamizable e:outputstreams)
            assertEquals(2,e.getSize());
    }


    @org.junit.Test
    public void testReceiveEvent() throws Exception {
        streamHub.registerStream(stream1);
        streamHub.registerStream(stream2);
        ArrayList<Streamizable> outputstreams = streamHub.getOutputStreams();
        for(Streamizable e:outputstreams)
            assertEquals(0,e.getSize());
        streamHub.receiveEvent(event1);
        streamHub.receiveEvent(event2);
        for(Streamizable e:outputstreams)
            assertEquals(2,e.getSize());
    }
}