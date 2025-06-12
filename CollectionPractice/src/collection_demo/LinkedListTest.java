package collection_demo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {

	public static void main(String[] args) {
		new LinkedListTest().linkedlistDemo();

	}
	void linkedlistDemo() {
		LinkedList l = new LinkedList();
		l.add(0, 1 );
		l.add(33);
		l.add("Sakii");
		l.add(3.3);
		l.add('s');
		l.add(3000);
		
		System.out.println(l);
		
		System.out.println(l.get(3));
		System.out.println(l.getFirst());
		System.out.println(l.getLast());
		System.out.println(l.remove(3));
		
		System.out.println("\nImplementation using Iterator - ");
		Iterator i = l.iterator();
		while(i.hasNext())
		{
			System.out.print(" "+i.next());
		}
		
		System.out.println("\n\nImplementation using ListIterator Forward - ");
		ListIterator n = l.listIterator();
		while(n.hasNext()) {
			System.out.print(" "+n.next());
		}
		
		System.out.println("\n\nImplementation using ListIterator Backward - ");
		while(n.hasPrevious()) {
			System.out.print(" "+n.previous());
		}
	}

}
