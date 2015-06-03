package siat.courant.event;

import java.util.Date;

public class Class3EventFactory extends EventFactory {
	public ParkEvent createEvent(String type){
		if(type.equals("outg")){
			return new Geo3in(888, 0, 431, new Date().getTime());
		}
		if(type.equals("ing")){
			return new Geo3in(888, 1, 431, new Date().getTime());
		}
		if(type.equals("outr")){
			return new Rfid3in(888, 0, 431, new Date().getTime(),8001);
		}
		if(type.equals("inr")){
			return new Rfid3in(888, 1, 431, new Date().getTime(),8001);
		}
		else return null;
	}
}
