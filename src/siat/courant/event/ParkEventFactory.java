package siat.courant.event;

public abstract class ParkEventFactory {

	abstract ParkEvent createEvent(String type);
}
