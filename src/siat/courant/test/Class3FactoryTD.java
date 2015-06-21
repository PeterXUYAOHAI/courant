package siat.courant.test;

import siat.courant.event.*;


public class Class3FactoryTD {
	public static void main(String [] args){
            System.out.println("test");
		Class3EventFactory c3f=new Class3EventFactory();
		Rfid3in r1=(Rfid3in) c3f.createEvent("inr");
		Rfid3in r2=(Rfid3in) c3f.createEvent("outr");
		Geo3in g1=(Geo3in) c3f.createEvent("ing");
		Geo3in g2=(Geo3in) c3f.createEvent("outg");
		System.out.println(r1.toString());
		System.out.println(r2.toString());
		System.out.println(g1.toString());
		System.out.println(g2.toString());
		
	}

}
