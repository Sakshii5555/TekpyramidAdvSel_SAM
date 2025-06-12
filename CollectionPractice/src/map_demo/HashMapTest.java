package map_demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapTest {

	public static void main(String[] args) {
		new HashMapTest().hashmapDemo(); 
		
	}
	
	void hashmapDemo() {
		HashMap hm = new HashMap();
		hm.put(111, "asss");
		hm.put("java", 111);
		hm.put('v', "sakii");
		hm.put(11,33);
		hm.put(99, 4.5);
		hm.put(null, null);
		//hm.put(111, 88);
		System.out.println(hm);
		
		System.out.println(hm.equals(111));
		System.out.println(hm.get(111));
		System.out.println(hm.putIfAbsent(99, 4.8));
		System.out.println(hm);
		System.out.println(hm.remove(111,"asss"));
		System.out.println(hm);
		
		HashSet hs = new HashSet(hm.entrySet());
		System.out.println("\n\nUsing HashSet: "+hs);
		
		HashSet hss = new HashSet(hm.keySet());
		System.out.println("\n\nUsing HashSet: "+hss);
		
		System.out.println("\n\nUsing Iterator diplaying here Keys And Values -");
		Iterator i = hs.iterator();
		while(i.hasNext()) {
			Entry e = (Entry)i.next();
			System.out.println(e.getKey()+"    "+e.getValue());
		}
	}

}
