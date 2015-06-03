package siat.courant.event;

public interface Event {
	public long getTimestamp();
	public long getId();
	public String getEventType();
	
	public long getAttributeByName(String attributeName);
	public String toString();

}
