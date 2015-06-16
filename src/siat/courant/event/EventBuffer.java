package siat.courant.event;

import java.util.HashMap;

public class EventBuffer {
	HashMap<Integer, Event> eventBuffer;

	public EventBuffer(){
		eventBuffer = new HashMap<Integer, Event>();
		
	}

	public Event getEvent(int id){
		return eventBuffer.get(id);
	}

	public void bufferEvent(Event event){
		if(eventBuffer.get(event.getId()) == null){
			eventBuffer.put(event.getId(), event);
			}
	}

}
