package siat.courant.event;

public abstract class EventFactory {

	abstract Event createEvent();
	abstract Event createEvent(String EventType);
}
