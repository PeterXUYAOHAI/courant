package siat.courant.event;import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ac.siat.parkdetect.stream.Event;

import com.sun.java.util.jar.pack.Package.File;import java.lang.Exception;import java.lang.String;

public class TextParserTest {
	String lineString;
	TextParser tp1;
	Event e;//e can be instantiated as StockEvent
	

	@Before
	public void setUp() throws Exception {
		tp1=new TextParser();
		e=new StockEvent(...);
		lineString=e.toString();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTextParserShouldParseTextSuccessfully() {
		tp1.parse(e);
		tp1.readLine(lineString);
		assertEquals(e.getPrice(), tp1.getAttributeByParseLinea("price"));


	}

}
