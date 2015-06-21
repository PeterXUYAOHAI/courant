package siat.courant.event;

public abstract class EventFactory {

	public abstract Event createEvent();
	public abstract Event createEvent(String EventType);
	public abstract Event createEvent(String type,int location, int existTag, int devId);
	public abstract Event createEvent(String type,int location, int existTag, int devId, int rfidCardNo);
}
