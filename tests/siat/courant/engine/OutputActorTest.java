package siat.courant.engine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import siat.courant.IO.OutputActor;
import siat.courant.event.Event;
import siat.courant.event.StockEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import static org.junit.Assert.*;
//import static siat.courant.IO.OutputActor.outputToFile;
//import static siat.courant.IO.OutputActor.outputToRemote;

/**
 * Created by asus on 2015/6/16.
 */
public class OutputActorTest {

    Tuple tuple;
    Event event1;
    Event event2;
    Event event3;
    OutputActor outputActor;

    @Before
    public void setUp() throws Exception {
        tuple = new Tuple();
        outputActor = new OutputActor();
        event1 = new StockEvent();
        event2 = new StockEvent();
        event3 = new StockEvent();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testOutput() throws Exception{
        tuple.addEvent(event1);
    }

    @Test
    public void testToSocket() throws Exception{

    }

    @Test
    public void testOutputToFile() throws Exception{
        String filePath = "";
        String fileName = "text.txt";
        tuple.addEvent(event1);
        outputActor.outputToFile(tuple, filePath, fileName);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        assertEquals("ID = 0\tTimestamp = 0\tSymbol = 0\tStockMarketTBD\tPrice = 0\tVolume = 0",br.readLine() );
    }

}