package collection_demo;

import java.util.HashSet;
import java.util.Iterator;


public class HashSetTest {

	void hashSetDemo() {
		
		HashSet h = new HashSet();
		//HashSet h = new HashSet();
		h.add("Sakii");
		h.add(100);
		h.add('o');
		h.add(false);
		h.add(null);
		h.add(100);
		h.add(33.33);
		h.add(1111);
		
		System.out.print("HashSet List is: "+h);
		
		System.out.println("\n"+h.contains(100));
		System.out.println("equals - "+h.equals(100));
		System.out.println("is-Empty - "+h.isEmpty());
		System.out.println("remove - "+h.remove(100));
		System.out.println("size - "+h.size());
		//h.clear();
		System.out.println("is-Empty - "+h.isEmpty());

		System.out.println("\n\nImplementation using Iterator - ");
		Iterator i = h.iterator();
		while(i.hasNext()) {
			System.out.print(" "+i.next());
		}
		
	}
	public static void main(String[] args) {
		new HashSetTest().hashSetDemo();
		
	}

}
