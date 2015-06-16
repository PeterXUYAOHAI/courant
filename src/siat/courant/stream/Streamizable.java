package siat.courant.stream;
import siat.courant.event.Event;

public interface Streamizable {

	Event popEvent();
	void addEvent(Event e);
	void printStream();
	//Event[] getEvents();
	//void setEvents(Event[] es);
	long getSize();
	//void setSize(long size); // really need?
	//long getCounter();
	//void setCounter(long counter);
}