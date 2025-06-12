package collection_demo;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorTest {

	void vectorDemo() {
		Vector v = new Vector();
		v.add(0, 1 );
		v.add(33);
		v.add("Sakii");
		v.add(3.3);
		v.add('s');
		
		System.out.println(v);
		v.remove(2);
		System.out.println(v);
		v.addElement(5555);
		System.out.println(v);
		System.out.println(v.capacity());
		System.out.println(v.contains(5555));
		System.out.println(v.elementAt(2));
		v.ensureCapacity(20);
		System.out.println(v.equals('s'));
		System.out.println(v.firstElement());
		System.out.println(v.get(4));
		System.out.println(v.indexOf(5555, 4));
		System.out.println(v.getFirst());
		System.out.println(v.getLast());
		System.out.println(v.indexOf('s'));
		System.out.println(v.remove(2));
		
		
		System.out.println("\nImplementation using for-loop - ");
		for(int i=0;i<v.size();i++) {
			System.out.print(" "+ v.get(i));
		}
	
		System.out.println("\n\nImplementation using Foreach-loop - ");
		for(Object n : v) {
			System.out.print(" "+n);
		}
		
		System.out.println("\n\nImplementation using Iterator - ");
		Iterator i = v.iterator();
		while(i.hasNext()) {
			System.out.print(" "+i.next());
		}
		
		System.out.println("\n\nImplementation using Enumeration - ");
		Enumeration e = v.elements();
		while(e.hasMoreElements()) {
			System.out.print(" "+e.nextElement());
		}
		}
	
	public static void main(String[] args) {
		new VectorTest().vectorDemo();

	}

}
