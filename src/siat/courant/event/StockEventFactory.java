package siat.courant.event;

public class StockEventFactory extends EventFactory{
	@Override
	public StockEvent createEvent()
	{
			return new StockEvent(1,1,1,1,1,"SH");
	}

	@Override
	public Event createEvent(String EventType) {
		return null;
	}

	@Override
	public Event createEvent(String type, int location, int existTag, int devId) {
		return null;
	}

	@Override
	public Event createEvent(String type, int location, int existTag, int devId, int rfidCardNo) {
		return null;
	}


}
