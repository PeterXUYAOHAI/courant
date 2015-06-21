package siat.courant.event;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import siat.courant.IO.OutputActor;
import siat.courant.engine.Tuple;


import java.io.IOException;
import java.lang.Exception;import java.lang.String;
import java.util.ArrayList;

public class TextParserTest {
	String lineString;
	TextParser tp1;
	Event e1;
	Event e2;
	Event e3;//e can be instantiated as StockEvent
	Event e4;
	Tuple tuple = new Tuple();
	OutputActor outputActor = new OutputActor();
	ArrayList<Event> events = new ArrayList<>();
;
	@Before
	public void setUp() throws Exception {
		tp1=new TextParser();
		e1 = new StockEvent();
		e2 = new Geo3in(123,456,789,1000);
		e3 = new Rfid3in(324,213,434,232,434);
		e4 = new StockEvent();
		tuple.addEvent(e2);
		tuple.addEvent(e3);
		tuple.addEvent(e1);
		tuple.addEvent(e4);
		lineString=e1.toString();


	}

	@After
	public void tearDown() throws Exception {
	}



	@Test
	public void testTextParserWithFileInout() throws IOException {
		try {
			outputActor.outputToFile(tuple,"","test.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		tp1.readFile("test.txt");
		System.out.println(tp1.nextParsedEventFromFile().getEventType());
		System.out.println(tp1.nextParsedEventFromFile().getEventType());
		System.out.println(tp1.nextParsedEventFromFile().getEventType());
		System.out.println(tp1.nextParsedEventFromFile().getEventType());
//		tp1.nextParsedEvent().getEventType();
//		assertTrue(e1.equals(tp1.nextParsedEvent()));
//		assertTrue(e2.equals(tp1.nextParsedEvent()));
//		assertTrue(e3.equals(tp1.nextParsedEvent()));
//		assertTrue(e4.equals(tp1.nextParsedEvent()));

	}

}
