package map_demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;

public class LinkedHashMapTest {

		public static void main(String[] args) {
			new LinkedHashMapTest().linkedhashmapDemo(); 
			
		}
		
		void linkedhashmapDemo() {
			LinkedHashMap hm = new LinkedHashMap();
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
			
			LinkedHashSet hs = new LinkedHashSet(hm.entrySet());
			System.out.println("\n\nUsing LinkedHashSet: "+hs);
			
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
