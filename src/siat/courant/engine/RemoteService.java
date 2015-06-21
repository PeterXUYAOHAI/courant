package siat.courant.engine;

import siat.courant.event.Event;

import java.util.ArrayList;

/**
 * Created by asus on 2015/6/16.
 */
public interface RemoteService {

   void resultsProcess(Event event);
    ArrayList<Event> getEvents();
}
