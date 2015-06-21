package siat.courant.test;

import siat.courant.event.Geo3in;
import siat.courant.event.Rfid3in;

public class GetEventAttrTD {
	public static void main(String [] args){
            System.out.println("test");
		Rfid3in re1=new Rfid3in(888, 1, 222, 333, 444);
		Rfid3in re2=new Rfid3in(888, 1, 222, 333, 444);
		Geo3in ge1=new Geo3in(999, 12, 222, 33434);
		long i=re1.getAttributeByName("timestamp");
		long j=re2.getAttributeByName("id");
		long k=ge1.getAttributeByName("id");
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
	}

}
