package map_demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		new TreeMapTest().treemapDemo();

	}
	void treemapDemo() {
		TreeMap tr = new TreeMap();
		tr.put(111, "asss");
		tr.put(55, 111);
		tr.put(11,33);
		tr.put(99, 4.5);
		tr.put(66, 9.0);
		
		System.out.println(tr);
		
		System.out.println("\n\nUsing Iterator - ");
		HashSet hs = new HashSet(tr.entrySet());
		Iterator i = hs.iterator();
		while(i.hasNext())
		{
			System.out.println(" "+i.next());
		}
				
	}
}
