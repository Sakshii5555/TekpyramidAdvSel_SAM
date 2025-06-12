package map_demo;

import java.util.Hashtable;

public class HashTableTest {

	public static void main(String[] args) {
		new HashTableTest().hashtable();
		
	}
	void hashtable() {
		Hashtable hm = new Hashtable();
		hm.put(111, "asss");
		hm.put("java", 111);
		hm.put('v', "sakii");
		hm.put(11,33);
		hm.put(99, 4.5);
		//hm.put(null, null);
		hm.put(111, 88);
		
		System.out.println(hm);
	}
}
