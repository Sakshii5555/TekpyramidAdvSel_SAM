package collection_demo;
import java.util.*;
public class ArrayListDemo {

	public static void main(String[] args) {
		new ArrayListDemo().arrayL();
	}
	void arrayL() {
		ArrayList a = new ArrayList();
		a.add(11);
		a.add("Sakii");
		a.add('2');
		a.add(200);
		a.add(4.9);
		a.add(null);
		a.addFirst(1111);
		a.addLast(1010);
	
		
		System.out.println("Array List: "+a);
		
		System.out.println(a.contains(1111));
		
		System.out.println(a.containsAll(a));
		System.out.println(a.get(3));
		System.out.println(a.getFirst());
		System.out.println(a.getLast());
		System.out.println(a.indexOf(null));
		System.out.println(a.isEmpty());
		System.out.println(a.lastIndexOf("Sakii"));
		
		System.out.println(a.remove(5));
		System.out.println(a);
		System.out.println(a.remove((Object)200));
		System.out.println(a);
		
		System.out.println("\nIteration using For-Loop");
		for(int i=0; i<a.size();i++) {
			System.out.print(" " +a.get(i));
		}
		
		System.out.println("\n\nIteration using For-each Loop");
		for(Object o:a) {
			System.out.print(" " +o);
		}
		
		System.out.println("Using Iterator");
		Iterator i = a.iterator();
		while(i.hasNext()) {
			System.out.print(" "+i.next());
		}
	}
}
