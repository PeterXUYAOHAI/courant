package siat.courant.event;

import java.util.Date;

public class Class3EventFactory extends EventFactory {

	public Event createEvent(){
		return null;
	}
        
        public Event createEvent(String type){
		return null;
	}
	public ParkEvent createEvent(String type,long location, long existTag, long devId){
		if(type.equals("outg")){
			//return new Geo3in(888, 0, 431, new Date().getTime());
                        return new Geo3in(location, 0, devId, new Date().getTime());
		}
		if(type.equals("ing")){
			//return new Geo3in(888, 1, 431, new Date().getTime());
                        return new Geo3in(location, 1, devId, new Date().getTime());
		}
		else return null;
	}
        
        public ParkEvent createEvent(String type,long location, long existTag, long devId, long rfidCardNo){
		if(type.equals("outr")){
			return new Rfid3in(location, 0, devId, new Date().getTime(),rfidCardNo);
		}
		if(type.equals("inr")){
			return new Rfid3in(location, 1, devId, new Date().getTime(),rfidCardNo);
		}
		else return null;
	}
}
