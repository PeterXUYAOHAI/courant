package siat.courant.stream;

import siat.courant.event.Event;


public interface StreamSubject {
	void registerStream(Streamizable stream);
	void notifyStreams(Event event);
}
