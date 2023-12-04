package tuan11;

import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	// Add element e into BST
	public void add(E e) {
		if (root == null) {
			root = new BNode<E>(e);
		} else {
			root.addBNode(e);

		}
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for(E e: col) {
			root.addBNode(e);
		}
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		return root.depthE(node);
	}

	// compute the height of BST
	public int height() {
		if(root==null)
		return -1;
		
		return root.heightB();
	}

	// Compute total nodes in BST
	public int size() {
		if(root==null)
		return -1;
		
		return root.sizeB();
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		if(root==null)
		return false;
		
		return root.containsB(e);
	}

	// Find the minimum element in BST
	public E findMin() {
		
		return root.findMinB();
	}

	// Find the maximum element in BST
	public E findMax() {
		// TODO
		return root.findMaxB();
	}

	// Remove element e from BST
	public boolean remove(E e) {
		
		return root.removeB(e);
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		
		return root.descendantsB(data);
	}

	// get the ancestors of a node
	public List<E> ancestors(E data) {
		// TODO
		
		return root.ancestors(data);
	}
	public void inOrder() {
		root.inorder();
	}
	public void preOrder() {
		root.preorder();
	}
	public void postOrder() {
		root.postorder();
	}
	
	public static void main(String[] args) {
		BST<Integer>b=new BST<Integer>();
		b.add(25);
		b.add(15);
		b.add(50);
		b.add(10);
		b.add(22);
		b.add(4);
		b.add(12);
		b.add(18);
		b.add(24);
		b.add(35);
		b.add(70);
		b.add(31);
		b.add(44);
		b.add(66);
		b.add(90);
		
//		System.out.println(b.depth(50));
//		System.out.println(b.height());
//		System.out.println(b.size());
//		System.out.println(b.contains(770));
//		System.out.println(b.findMin());
//		System.out.println(b.findMax());
//		System.out.println(b.descendants(10));
//		System.out.println(b.ancestors(10));
		b.inOrder();
//		b.preOrder();
//		b.postOrder();
		b.remove(15);
		System.out.println();
		b.inOrder();
		
	}
}
