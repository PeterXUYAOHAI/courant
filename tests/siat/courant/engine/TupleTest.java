package siat.courant.engine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import siat.courant.event.Event;
import siat.courant.event.Geo3in;
import siat.courant.event.Rfid3in;
import siat.courant.event.StockEvent;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by asus on 2015/6/16.
 */
public class TupleTest {
    Tuple tuple;
    Event event1;
    Event event2;
    Event event3;
    @Before
    public void setUp() throws Exception {
        tuple = new Tuple();
        event1 = new StockEvent();
        event2 = new Geo3in(888, 0, 1234, 2314);
        event3 = new Rfid3in( 888, 0, 123, 2341, 42343);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetTuple(){
        //remoteMessageService.add();
    }

    @Test
    public void testTupleToString(){
        assertEquals("",tuple.toString() );
        tuple.addEvent(event1);
        assertEquals("StockEvent\t0\t0\t0\tTBD\t0\t0\n",tuple.toString() );
        tuple.addEvent(event2);
        tuple.addEvent(event3);
        assertEquals("StockEvent\t0\t0\t0\tTBD\t0\t0\n" +
                "Geo3in\t 888\t 0\t 1234\t 2314\n" +
                "Rfid3in\t 888\t 0\t 123\t 2341\t 42343\n",tuple.toString() );
    }
}