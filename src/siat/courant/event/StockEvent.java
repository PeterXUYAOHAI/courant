package siat.courant.event;

public class StockEvent implements Event{
	
	long timestamp;
	long id;
	String eventType="stock";
	long volume;
	long price;
	long symbol;
	String stockMarket;
	
	public StockEvent(){
		this.timestamp=0;
		this.id=0;
		this.volume=0;
		this.price=0;
		this.symbol=0;
		stockMarket="TBD";
	}
	
	public StockEvent(long timestamp, long id, long volume, long price, long symbol, String stockMarket){
		this.timestamp=timestamp;
		this.id=id;
		this.volume=volume;
		this.price=price;
		this.symbol=symbol;
		this.stockMarket=stockMarket;
	}
	
	public long getTimestamp(){
		return timestamp;
	}
	
	public long getId(){
		return id;
	}
	
	public String getEventType(){
		return eventType;
	}
	
	public void setId(long id){
		this.id=id;
	}
	
	public void setTimestamp(long timestamp){
		this.timestamp=timestamp;
	}
	
	public void setVolume(long volume){
		this.volume=volume;
	}
	
	public void setPrice(long price){
		this.price=price;
	}
	
	public void setSymbol(long symbol){
		this.symbol=symbol;
	}
	
	public void setStockMarket(String stockMarket){
		this.stockMarket=stockMarket;
	}
	
	public long getAttributeByName(String attributeName){
		//if(attributeName.equals('volume'))
			//return volume;
		//else if(attributeName.equals('price'))
			//return price;
		//else if(attributeName.equals('symbol'))
			//return symbol;
		//else if(attributeName.equals('Timestamp'))
			//return timestamp;
		//else if(attributeName.equals('id'))
			//return id;
		//return null;
		return -1L;
	}
	
	public String toString(){
		return "ID = "+ id + 
			"\tTimestamp = " + timestamp
				+ "\tSymbol = " + symbol + 
				"\tStockMarket" + stockMarket + 
				"\tPrice = " + price + 
				"\tVolume = " + volume;
	}
}
