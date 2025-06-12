package collection_demo;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetTest {

		void linkedhashSetDemo() {
			
			LinkedHashSet lh = new LinkedHashSet();

			lh.add("Sakii");
			lh.add(100);
			lh.add('o');
			lh.add(false);
			lh.add(null);
			lh.add(100);
			lh.add(33.33);
			lh.add(1111);
			
			System.out.print("LinkedHashSet List is: "+lh);
			
			System.out.println("\n"+lh.contains(100));
			System.out.println("equals - "+lh.equals(100));
			System.out.println("is-Empty - "+lh.isEmpty());
			System.out.println("remove - "+lh.remove(100));
			System.out.println("size - "+lh.size());
			//h.clear();
			System.out.println("is-Empty - "+lh.isEmpty());

			System.out.println("\n\nImplementation using Iterator - ");
			Iterator i = lh.iterator();
			while(i.hasNext()) {
				System.out.print(" "+i.next());
			}
			
		}
		
		public static void main(String[] args) {
			new LinkedHashSetTest().linkedhashSetDemo();
			
		}

}



