package siat.courant.engine;

import siat.courant.event.Event;

import java.util.ArrayList;

/**
 * Created by asus on 2015/6/16.
 */
public class RemoteEnd implements RemoteService{
    ArrayList<Event> events = new ArrayList<>();


    @Override
    public void resultsProcess(Event event) {
        events.add(event);
    }

    public ArrayList<Event> getEvents(){
            return events;
    }
}
