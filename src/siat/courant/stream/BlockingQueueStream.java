package siat.courant.stream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import siat.courant.event.Event;

public class BlockingQueueStream implements Streamizable {
	
	private BlockingQueue<Event> events;
	
	public BlockingQueueStream(){
		events=new LinkedBlockingQueue<Event>();
	}
	
	@Override
	public Event popEvent(){
		Event event=null;
		try{
			event=events.take();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		return event;
	}
	@Override
	public void addEvent(Event event){
		try {
			events.put(event);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void printStream(){
		int i=0;
		for(Event event : events){
			System.out.println(event+"::<--"+i);
			i++;
		}
	}

	@Override
	public long getSize() {
		return events.size();
	}

	public BlockingQueue<Event> getEvents(){
		return events;
	}
	
	public void setEvents(BlockingQueue<Event> events){
		this.events=events;
	}

}
