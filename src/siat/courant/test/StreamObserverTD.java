package siat.courant.test;

import siat.courant.engine.PseudoEngine;
import siat.courant.event.Class3EventFactory;
import siat.courant.event.Event;
import siat.courant.event.Geo3in;
import siat.courant.event.Rfid3in;
import siat.courant.stream.StreamHub;

public class StreamObserverTD {
	public static void main(String args[]){
		Class3EventFactory c3f=new Class3EventFactory();
		Event event1,event2, event3,event4;
		
        StreamHub streamHub=new StreamHub();
        PseudoEngine pe1=new PseudoEngine();
        PseudoEngine pe2=new PseudoEngine();
        PseudoEngine pe3=new PseudoEngine();

        pe1.setInputStreamFrom(streamHub);
        pe2.setInputStreamFrom(streamHub);
        pe3.setInputStreamFrom(streamHub);

		event1=(Geo3in) c3f.createEvent("ing");
		event2=(Rfid3in) c3f.createEvent("inr");
		event3=(Geo3in) c3f.createEvent("outg");
		event4=(Rfid3in) c3f.createEvent("outr");

        streamHub.receiveEvent(event1);
        streamHub.receiveEvent(event2);
        streamHub.receiveEvent(event3);
        streamHub.receiveEvent(event4);


        
        System.out.println("PE1 streams::");
        pe1.printStream();

        System.out.println("PE2 streams::");
        pe2.printStream();

        System.out.println("PE3 streams::");
        pe3.printStream();


	}
}
