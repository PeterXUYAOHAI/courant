package siat.courant.engine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import siat.courant.query.NFA;
import siat.courant.engine.PseudoEngine;

import java.lang.Exception;

import static org.junit.Assert.*;

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
        assertEquals(null,getTimeWindow());
        engine.setNfa(nfa1);
        assertEquals(500,engine.getTimeWindow());
        engine.setNfa(nfa2);
        assertEquals(200,engine.getTimeWindow());
        engine.setNfa(nfa3);
        assertEquals(100000,engine.getTimeWindow());

    }

    @Test
    public void testGetSize() throws Exception{
        assertEquals(null,getGetSize());
        engine.setNfa(nfa1);
        assertEquals(200,getSize());
        engine.setNfa(nfa2);
        assertEquals(600,getSize());
        engine.setNfa(nfa1);
        assertEquals(100,,getSize());

    }

    @Test
    public void testGetSelectionStrategy() throws Exception{
        assertEquals(null,getSelectionStrategy);
        engine.setNfa(nfa1);
        assertEquals("partition-contiguity", getSelectionStrategy());
        engine.setNfa(nfa2);
        assertEquals("skip-till-any", getSelectionStrategy());
        engine.setNfa(nfa3);
        assertEquals("skip-till-newt-match", getSelectionStrategy());
    }

    @Test
    public void testIsHasPartitionAttribute() throws Exception{
        assertEquals(null,isHasPartitionAttribute());
        engine.setNfa(nfa1);
        assertEquals(true,isHasPartitionAttribute());
        engine.setNfa(nfa2);
        assertEquals(false,isHasPartitionAttribute());
        engine.setNfa(nfa3);
        assertEquals(true,isHasPartitionAttribute());
    }

    @Test
    public void testIsHasNegation() throws Exception {
        assertEquals(null,getSelectionStrategy);
        engine.setNfa(nfa1);
        assertEquals(false,isHasNegation());
        engine.setNfa(nfa2);
        assertEquals(true,isHasNegation());
        engine.setNfa(nfa3);
        assertEquals(false,isHasNegation());
    }




}