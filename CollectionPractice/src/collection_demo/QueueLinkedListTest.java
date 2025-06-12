package collection_demo;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class QueueLinkedListTest {

	public static void main(String[] args) {
		QueueLinkedListTest ql = new QueueLinkedListTest();
		ql.QueueLlDemo();
		
		ql.QueuePqDemo();

	}

	void QueueLlDemo() {
		LinkedList ll = new LinkedList();
		ll.add(22);
		ll.add('d');
		ll.offer(66);
		ll.offer(1111);
		
		System.out.println(ll);
	}
	
	void QueuePqDemo() {
		PriorityQueue pq = new PriorityQueue();
		pq.add(22);
		pq.add(7777);
		pq.offer(333);
		pq.offer(999);
		
		System.out.println("Priority Queue - "+ pq);
		
		System.out.println(pq.poll());
		System.out.println("Priority Queue - "+ pq);
		
		System.out.println(pq.remove());
		System.out.println("Priority Queue - "+ pq);
		
		System.out.println(pq.peek());
		System.out.println("Priority Queue - "+ pq);
		
		pq.clear();
		System.out.println(pq.poll());//This will give output as null 
		System.out.println(pq.remove());//This will give exception
	}
}
