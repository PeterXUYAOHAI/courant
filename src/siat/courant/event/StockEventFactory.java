package siat.courant.event;

public class StockEventFactory extends EventFactory{
	@Override
	public StockEvent createEvent()
	{
			return new StockEvent(1,1,1,1,1,"SH");
	}

	@Override
	Event createEvent(String EventType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	

}
