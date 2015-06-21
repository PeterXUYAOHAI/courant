package siat.courant.event;

public interface Event {
	
	public long getTimestamp();
	public int getId();
	public String getEventType();
	
	public int getAttributeByName(String attributeName);
	public String toString();

}
