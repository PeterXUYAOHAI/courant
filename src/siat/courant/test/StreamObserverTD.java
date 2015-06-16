package siat.courant.test;

import siat.courant.event.Event;
import siat.courant.event.Class3EventFactory;
//import siat.courant.event.StockEvent;
//import.siat.courant.event.Class3EventFactory;
import siat.courant.engine.PseudoEngine;
import siat.courant.event.Geo3in;
import siat.courant.event.Rfid3in;
import siat.courant.stream.StreamHub;
import java.util.ArrayList;
import java.lang.Math;

public class StreamObserverTD {
	public static void main(String args[]){
            System.out.println("test");
		Class3EventFactory c3f=new Class3EventFactory();
 //               StockEventFwwactory c3f=new StockEventFactory();
                ArrayList<Event> GeoinEvenet1 = new ArrayList<Event>();
                ArrayList<Event> GeoinEvenet0 = new ArrayList<Event>();
                ArrayList<Event> RfidEvenet1 = new ArrayList<Event>();
                ArrayList<Event> RfidEvenet0 = new ArrayList<Event>();
//		Event event3,event4;
		
        StreamHub streamHub=new StreamHub();
        PseudoEngine pe1=new PseudoEngine();
        PseudoEngine pe2=new PseudoEngine();
        PseudoEngine pe3=new PseudoEngine();
        PseudoEngine pe4=new PseudoEngine();
        
        pe1.setInputStream(streamHub);
        pe2.setInputStream(streamHub);
        pe3.setInputStream(streamHub);
        pe4.setInputStream(streamHub);
        
        
//        public ParkEvent createEvent(String type,long location, long existTag, long devId)
//        public ParkEvent createEvent(String type,long location, long existTag, long devId, long rfidCardNo)
            for(int i=0; i<100 ;i++ ){
                String type = "ing";
                long location =  new Double(Math.round(1000 * Math.random())).longValue();
                long devId = new Double(Math.round(100 * Math.random())).longValue();
                GeoinEvenet1.add((Geo3in) c3f.createEvent("ing", location, 1, devId ));
            }
            
            for(int i=0; i<100 ;i++ ){
                String type = "inr";
                long location =  new Double(Math.round(1000 * Math.random())).longValue();
                long devId = new Double(Math.round(100 * Math.random())).longValue();
                long rfidCardNo = new Double(Math.round(500 * Math.random())).longValue();
                RfidEvenet1 .add((Rfid3in) c3f.createEvent("inr", location, 1, devId,rfidCardNo ));
            }
            
            for(int i=0; i<100 ;i++ ){
                String type = "outg";
                long location =  new Double(Math.round(1000 * Math.random())).longValue();
                long devId = new Double(Math.round(100 * Math.random())).longValue();
                GeoinEvenet0.add((Geo3in) c3f.createEvent("outg", location, 0, devId ));
            }
            
            for(int i=0; i<100 ;i++ ){
                String type = "outr";
                long location =  new Double(Math.round(1000 * Math.random())).longValue();
                long devId = new Double(Math.round(100 * Math.random())).longValue();
                long rfidCardNo = new Double(Math.round(500 * Math.random())).longValue();
                RfidEvenet0 .add((Rfid3in) c3f.createEvent("outr", location, 0, devId,rfidCardNo ));
            }
            
            GeoinEvenet1.add((Geo3in) c3f.createEvent("ing", -5, 1, 344 ));
            GeoinEvenet1.add((Geo3in) c3f.createEvent("ing", 500, -1, 344 ));
            GeoinEvenet1.add((Geo3in) c3f.createEvent("ing", 500, 1, -40 ));
            GeoinEvenet1.add((Geo3in) c3f.createEvent("ing", 500, 1, 999999999 ));
            GeoinEvenet1.add((Geo3in) c3f.createEvent("ing", 999999999, 1, 344 ));
            RfidEvenet1 .add((Rfid3in) c3f.createEvent("inr", -5, 1, 344, 45345 ));
            RfidEvenet1 .add((Rfid3in) c3f.createEvent("inr", 500, -1, 344, 45345 ));
            RfidEvenet1 .add((Rfid3in) c3f.createEvent("inr", 500, 1, -344, 45345 ));
            RfidEvenet1 .add((Rfid3in) c3f.createEvent("inr", 500, 1, 344, -45345 ));
            GeoinEvenet0.add((Geo3in) c3f.createEvent("outg", -5, 0, 500 ));
            GeoinEvenet0.add((Geo3in) c3f.createEvent("outg", 500,-1, 500 ));
            GeoinEvenet0.add((Geo3in) c3f.createEvent("outg", 500, 0, -500 ));
            GeoinEvenet0.add((Geo3in) c3f.createEvent("outg", 500, 0, 500 ));
            RfidEvenet0 .add((Rfid3in) c3f.createEvent("outr", -5, 0, 500,1324 ));
            RfidEvenet0 .add((Rfid3in) c3f.createEvent("outr", 500, -1, 500,1324 ));
            RfidEvenet0 .add((Rfid3in) c3f.createEvent("outr", 500, 0, -500,1324 ));
            RfidEvenet0 .add((Rfid3in) c3f.createEvent("outr", 500, 0, 500,-1324 ));
            
//		event1=(Geo3in) c3f.createEvent("ing");
//		event2=(Rfid3in) c3f.createEvent("inr");
//		event3=(Geo3in) c3f.createEvent("outg");
//		event4=(Rfid3in) c3f.createEvent("outr");
 //               event1= (StockEvent)c3f.createEvent();

            
            for (Event e:GeoinEvenet1)
                streamHub.receiveEvent(e);
            for (Event e:RfidEvenet1)
                streamHub.receiveEvent(e);
            for (Event e:GeoinEvenet0)
                streamHub.receiveEvent(e);
            for (Event e:RfidEvenet0)
                streamHub.receiveEvent(e);
                
//       streamHub.receiveEvent(event1);
//        streamHub.receiveEvent(event2);
//        streamHub.receiveEvent(event3);
//        streamHub.receiveEvent(event4);


        
        System.out.println("PE1 streams::");
        pe1.printStream();

        System.out.println("PE2 streams::");
        pe2.printStream();

        System.out.println("PE3 streams::");
        pe3.printStream();
        
        System.out.println("PE4 streams::");
        pe4.printStream();


	}
}
