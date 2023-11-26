package tuan10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyFIFO_App {
	// method stutter that accepts a queue of integers as
//	a parameter and replaces
	// every element of the queue with two copies of that
//	element
	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back
	public static <E> void stutter(Queue<E> input) {
		Queue<E> q = new LinkedList<>();
		while (!input.isEmpty()) {
			E e = input.poll();
			q.add(e);
			q.add(e);

//			E e=input.peek();
//			E e1=input.poll();
//			q.add(e);
//			q.add(e1);
		}
		while (!q.isEmpty()) {
			input.add(q.poll());
		}
	}

	// front [a, b, c] back
	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		Stack<E> st = new Stack<>();
		for (E e : input) {
			st.push(e);
		}
		while (!st.isEmpty()) {
			input.add(st.pop());
		}

	}

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		stutter(q);
		System.out.println(q);

		Queue<String> q1 = new LinkedList<>();
		q1.add("a");
		q1.add("b");
		q1.add("c");
		mirror(q1);
		System.out.println(q1);
		;
	}
}
