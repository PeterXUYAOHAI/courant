package siat.courant.test;

import siat.courant.event.*;
public class StockEventFactoryTD {
	public static void main(String [] args){
		
	
		StockEventFactory c3f=new StockEventFactory();
		StockEvent r1=(StockEvent) c3f.createEvent();
		
		System.out.println(r1.toString());
		
	}

}
 