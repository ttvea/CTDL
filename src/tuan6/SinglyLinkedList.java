package tuan6;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
	}

	// Returns the number of elements in the list.
	public int size() {

		return this.size;
	}

	// Returns true if the list is empty, and false
//	otherwise.
	public boolean isEmpty() {

		return this.size == 0 ? true : false;
	}

	// Returns (but does not remove) the first element in
//	the list.
	public E first() {

		return head.getData();
	}

	// Returns (but does not remove) the last element in
//	the list.
	public E last() {
		return tail.getData();
	}

//	DS - LAB - NLU
//	(Semester 1, 2023/2024)5 }
	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		size++;
//		Node<E>newest=new Node<E>(e);
//		newest.setNext(head);
//		head=newest;
		head = new Node<E>(e, head);
		if(head.getNext()==null) {
			head.setNext(tail);//gắn head đầu tiên thành đứa đứng cuối
			tail=head;
		}
	}

	// Adds a new element to the end of the list.
	public void addLast(E e) {
		size++;
		
		Node<E> newest = new Node<E>(e, null);
		tail.setNext(newest);
		tail = newest;
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
//		Node<E>newest=head.getNext();
//		head=newest;
		Node<E>newest=head;
		head=head.getNext();
		newest.setData(null);
		newest.setNext(null);
		return head.getData();
	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		
		Node<E> block = head;// 1 block chứa 1 data e và 1 Node
		while (block != null) {
			if(block.getNext()!=null&&block.getNext().getNext()==null) {
				tail=block;
			}
			block = block.getNext();
		}
		tail.setNext(null);
		return tail.getData();
	}

	public String toString() {
		String result = "";
		Node<E> block = head;// 1 block chứa 1 data e và 1 Node
		while (block != null) {
			result += block.getData();
			if (block.getNext() != null) {
				result += " ";
			}
			block = block.getNext();
		}
		return result;
	}

	public static void main(String[] args) {
		
		SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
		linkedList.addFirst("A");
		linkedList.addLast("D");
		linkedList.addFirst("B");
		linkedList.addFirst("C");
		linkedList.addLast("E");
//		System.out.println("RemoveFirst "+linkedList.removeFirst());
		System.out.println("RemoveLast "+linkedList.removeLast());
		System.out.println(linkedList.toString());
	}
}
