package tstGIt;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Map<Integer,String> base=new TreeMap();
		base.put(3,"yahya");
		base.put(2, "bitcoin");
		base.putIfAbsent(1,"toto");
		/* SET TO CREATE A LIST OF THE CALLED ELEMENT (OR values()*/
		/*  GET TO HAVE ONE ELEMENT FROM THE LIST -MAP-*/
		System.out.println(base);
//		for(Map.Entry e : base.entrySet()) {
//			System.out.println(e.getValue());
//		}
	    for(Map.Entry<Integer,String> e : base.entrySet()) {
	    	System.out.println(e.getValue()+" ->  "+e.getKey());
	    	
	    }
		
	}
}
