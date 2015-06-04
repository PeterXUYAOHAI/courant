package siat.courant.event;

public class StockEventFactory extends EventFactory{
	public StockEvent createEvent()
	{
			return new StockEvent();
	}

	@Override
	Event createEvent(String EventType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	

}
