package siat.courant.engine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import siat.courant.event.Event;
import siat.courant.event.StockEvent;

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
        event2 = new StockEvent();
        event3 = new StockEvent();
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
        assertEquals("ID = 0\tTimestamp = 0\tSymbol = 0\tStockMarketTBD\tPrice = 0\tVolume = 0\n",tuple.toString() );
        tuple.addEvent(event2);
        tuple.addEvent(event3);
        assertEquals("ID = 0\tTimestamp = 0\tSymbol = 0\tStockMarketTBD\tPrice = 0\tVolume = 0\nID = 0\tTimestamp = 0\tSymbol = 0\tStockMarketTBD\tPrice = 0\tVolume = 0\nID = 0\tTimestamp = 0\tSymbol = 0\tStockMarketTBD\tPrice = 0\tVolume = 0\n",tuple.toString() );
    }
}