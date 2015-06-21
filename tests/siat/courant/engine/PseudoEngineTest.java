package siat.courant.engine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import siat.courant.query.NFA;

import static org.junit.Assert.assertEquals;

/**
 * Created by asus on 2015/6/16.
 */
public class PseudoEngineTest {
    PseudoEngine engine;
    NFA nfa1;
    NFA nfa2;
    NFA nfa3;

    @Before
    public void setUp() throws Exception {
        engine = new PseudoEngine();
        nfa1 = new NFA("test1.query");
        nfa2 = new NFA("test2.query");
        nfa3 = new NFA("test3.query");
    }

    @After
    public void tearDown() throws Exception {
        engine = new PseudoEngine();
    }

    @Test
    public void testGetTimeWindow() throws Exception{
//        assertEquals(0,engine.getTimeWindow());
//        engine.setNfa(nfa1);
//        assertEquals(345,engine.getTimeWindow());
//        engine.setNfa(nfa2);
//        assertEquals(200,engine.getTimeWindow());
//        engine.setNfa(nfa3);
//        assertEquals(100000,engine.getTimeWindow());

    }

    @Test
    public void testGetSize() throws Exception{
//        assertEquals(0,engine.getSize());
//        engine.setNfa(nfa1);
//        assertEquals(2,engine.getSize());
//        engine.setNfa(nfa2);
//        assertEquals(1,engine.getSize());
//        engine.setNfa(nfa1);
//        assertEquals(2,engine.getSize());

    }



    @Test
    public void testIsHasPartitionAttribute() throws Exception{
//        assertEquals(false,engine.isHasPartitionAttribute());
//        engine.setNfa(nfa1);
//        assertEquals(true,engine.isHasPartitionAttribute());
//        engine.setNfa(nfa2);
//        assertEquals(true,engine.isHasPartitionAttribute());
//        engine.setNfa(nfa3);
//        assertEquals(false,engine.isHasPartitionAttribute());
    }

    @Test
    public void testIsHasNegation() throws Exception {
//        assertEquals(false,engine.isHasNegation());
//        engine.setNfa(nfa1);
//        assertEquals(false,engine.isHasNegation());
//        engine.setNfa(nfa2);
//        assertEquals(true,engine.isHasNegation());
//        engine.setNfa(nfa3);
//        assertEquals(false,engine.isHasNegation());
    }

    @Test
      public void testGetSelectionStrategy() throws Exception{
//        assertEquals(null,engine.getSelectionStrategy());
//        engine.setNfa(nfa1);
//        assertEquals("partition-contiguity", engine.getSelectionStrategy());
//        engine.setNfa(nfa2);
//        assertEquals("skip-till-any", engine.getSelectionStrategy());
//        engine.setNfa(nfa3);
//        assertEquals("skip-till-next-match", engine.getSelectionStrategy());
    }

    @Test
    public void testGetPartitionAttribute() throws Exception{
//        assertEquals("",engine.getPartitionAttribute());
//        engine.setNfa(nfa1);
//        assertEquals("gsdg", engine.getPartitionAttribute());
//        engine.setNfa(nfa2);
//        assertEquals("symbol", engine.getPartitionAttribute());
//        engine.setNfa(nfa3);
//        assertEquals(null, engine.getPartitionAttribute());
    }



}