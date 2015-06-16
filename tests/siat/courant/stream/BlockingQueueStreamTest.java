package siat.courant.stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import siat.courant.event.Event;
import siat.courant.event.StockEvent;

import static org.junit.Assert.*;

/**
 * Created by asus on 2015/6/15.
 */
public class BlockingQueueStreamTest {
    BlockingQueueStream blockingQueueStream;
    Event event1;
    Event event2;

    @Before
    public void setUp() throws Exception {
        blockingQueueStream=new BlockingQueueStream();
        event1=new StockEvent();
        event2=new StockEvent();
    }

    @After
    public void tearDown() throws Exception{
        event1=new StockEvent();
        event2=new StockEvent();
    }

    @Test
    public void testPopEvent() throws Exception {
        blockingQueueStream.addEvent(event1);
        assertEquals(event1, blockingQueueStream.popEvent());
        blockingQueueStream.addEvent(event1);
        blockingQueueStream.addEvent(event2);
        assertEquals(event1,blockingQueueStream.popEvent());
        assertEquals(event2,blockingQueueStream.popEvent());

    }

    @Test
    public void testAddEvent() throws Exception {
        assertEquals(0,blockingQueueStream.getSize());
        blockingQueueStream.addEvent(event1);
        blockingQueueStream.addEvent(event2);
        assertEquals(2,blockingQueueStream.getSize());
    }
}