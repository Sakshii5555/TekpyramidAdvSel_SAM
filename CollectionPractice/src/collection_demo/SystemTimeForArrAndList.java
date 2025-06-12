package collection_demo;

import java.util.ArrayList;
import java.util.LinkedList;

public class SystemTimeForArrAndList {

	private static Object arr[];
	static {
		arr = new Object[100000];
		for(int i= 0; i < arr.length; i++) 
		arr[i] = new Object();
	}
	
	void ArrayListTime() {
		long start, end;
		ArrayList al = new ArrayList();
		start = System.currentTimeMillis();
		for(Object obj1: arr) {
			al.add(obj1);
		}
		end = System.currentTimeMillis();
		System.out.println("ArrayList Construction Time is - "+ (end - start));
	}
	
	void LinkedListTime() {
		long start, end;
		LinkedList ll = new LinkedList();
		start = System.currentTimeMillis();
		for(Object obj2: arr) {
			ll.add(obj2);
		}
		end = System.currentTimeMillis();
		System.out.println("LinkedList Construction Time is - "+ (end - start));
	}
	
	public static void main(String[] args) {
		SystemTimeForArrAndList s = new SystemTimeForArrAndList();
		s.ArrayListTime();
		s.LinkedListTime();

	}

}
