package collection_demo;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		new TreeSetTest().treesetDemo();
	}
	
	void treesetDemo() {	
		TreeSet tr = new TreeSet();
		
		tr.add(100);
		tr.add(777);
		tr.add(99);
		tr.add(90);
		tr.add(100);
		tr.add(3333);
		tr.add(3333);
		tr.add(1111);
		
		System.out.print("TreeSet List is: "+tr);
		
		System.out.println("\nGet First Value - "+tr.first());
		System.out.println("Contains - "+tr.contains(3333));
		System.out.println(tr);
		System.out.println("Get First Value - "+tr.getFirst());
		System.out.println("Get Last Value - "+tr.getLast());
		
		System.out.println("\n\nImplementation using Iterator - ");
		Iterator i = tr.iterator();
		while(i.hasNext()) {
			System.out.print(" "+ i.next());
		}
		
		System.out.println("\n\nImpelemtation using DescendingIterator - ");
		Iterator di = tr.descendingIterator();
		while(di.hasNext()) {
			System.out.print(" "+di.next());
		}
		
		System.out.println("\n\nHeadSet - "+tr.headSet(100));
		System.out.println("\n\nTailSet - "+tr.tailSet(100));
	}
	
}
