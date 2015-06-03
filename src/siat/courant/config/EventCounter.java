package siat.courant.config;

public class EventCounter {
	public static int eCounter;
	public EventCounter() {
		eCounter=0;
	}
	
	public static int generateEventId(){
		eCounter++;
		return eCounter;
	}

}
