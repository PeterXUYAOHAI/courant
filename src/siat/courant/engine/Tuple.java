package siat.courant.engine;

import siat.courant.event.Event;

import java.util.ArrayList;

/**
 * Created by asus on 2015/6/16.
 */
public class Tuple {
    ArrayList<Event> events;

    public Tuple(){
        events = new ArrayList<>();
    }

    public void addEvent(Event event){
        events.add(event);
    }

    @Override
    public String toString(){
        String temp = "";
        if (events!=null)
            for (Event e : events)
                temp += e.toString()+'\n';
        return temp;
    }

    public ArrayList<Event> getEvents(){
        return events;
    }

}


