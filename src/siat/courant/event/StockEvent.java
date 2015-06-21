package siat.courant.event;

import java.util.Objects;

public class StockEvent implements Event{
	
	long timestamp;
	int id;
	String eventType="stock";
	int volume;
	int price;
	int symbol;
	String stockMarket;
	
	public StockEvent(){
		this.timestamp=0;
		this.id=0;
		this.volume=0;
		this.price=0;
		this.symbol=0;
		stockMarket="TBD";
	}
	
	public StockEvent(long timestamp, int id, int volume, int price, int symbol, String stockMarket){
		this.timestamp=timestamp;
		this.id=id;
		this.volume=volume;
		this.price=price;
		this.symbol=symbol;
		this.stockMarket=stockMarket;
	}
	
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSymbol() {
		return symbol;
	}

	public void setSymbol(int symbol) {
		this.symbol = symbol;
	}

	public String getStockMarket() {
		return stockMarket;
	}

	public void setStockMarket(String stockMarket) {
		this.stockMarket = stockMarket;
	}

	public int getAttributeByName(String attributeName){
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
		return -1;
	}
	
	public String toString(){
		return  "StockEvent" +
				"\t" +id +
			"\t" + timestamp
				+ "\t" + symbol +
				"\t" + stockMarket +
				"\t" + price +
				"\t" + volume;
	}

	@Override
	public boolean equals(Object obj){
		if (obj == null) return false ;
		else{
			if (obj instanceof StockEvent){
				StockEvent s = (StockEvent) obj;
				if(s.timestamp== this.timestamp && s.id == this.id && s.volume == this.volume&& s.price==this.price&& s.symbol==this.symbol&& s.stockMarket.equals(this.stockMarket)  ){
					return true ;
				}
			}
		}
		return false ;
	}
}

