package tuan6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of
//	elements is full
	public void growSize() {
		if (this.elements.length == size) {
			E[] arr = this.elements;
			this.elements = Arrays.copyOf(arr, size * 2);
		}
	}

	// Returns the number of elements in this list.
	public int size() {
		return this.size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {

		return this.size == 0;
	}

	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > this.size - 1) {
			throw new ArrayIndexOutOfBoundsException("index khong hop le");
		} else {
			return elements[i];
		}
	}

//	turns the replaced element. ∗/
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > this.size - 1) {
			throw new ArrayIndexOutOfBoundsException("index khong hop le");
		} else {
			return elements[i] = e;
		}
	}

	// It is used to append the specified element at the
//	end of a list.
	public boolean add(E e) {
		if (this.elements.length == size) {
			growSize();
			elements[size / 2] = e;
		} else {
			elements[size] = e;
			size++;
		}
		return true;
	}

	// Inserts element e to be at index i, shifting all
//	subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > this.size - 1) {
			throw new ArrayIndexOutOfBoundsException("index khong hop le");
		} else {
			if (this.elements.length == size) {
				growSize();
				elements[size / 2] = e;
			} else {
				size++;
				for (int j =i; j <size; j++) {
					elements[j+1]=elements[j];
				}
				elements[i]=e;
			}
		}
	}

	// It is used to clear all elements in the list.
	public void clear() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	// It is used to return the index in this list of the
//	last occurrence of the specified element, or -1 if the 
//	list does not contain this element.
	public int lastIndexOf(Object o) {
		int result=-1;
		for(int i=0;i<size;i++) {
			if(elements[i].equals(o)) {
				result= i;
			}
		}
		return result;
	}

	// Removes and returns the element at index i,
//	shifting subsequent elements earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > this.size - 1) {
			throw new ArrayIndexOutOfBoundsException("index khong hop le");
		}else {
			size--;
			for (int j =i; j <size; j++) {
				elements[j]=elements[j+1];
			}
		}
		return elements[i];
	}

	public E[] toArray() {

		return this.elements;
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		return null;
	}

	// It returns true if the list contains the specified
//		element
	public boolean contains(E o) {
		return false;
	}

	// It is used to return the index in this list of the
//		 first occurrence of the specified element, or -1 if the 
//		List does not contain this element.
	public int indexOf(E o) {
		return -1;
	}

	// It is used to remove the first occurrence of the
//		specified element.
	public boolean remove(E e) {

		return false;
	}

	// It is used to sort the elements of the list on the
//		basis of specified comparator.
	public void sort(Comparator<E> c) {
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < size; i++) {
			if (elements[i] != null) {
				result += elements[i] + " ";
			}
		}

		return result;
	}

	public static void main(String[] args) {
		MyArrayList<Integer> test = new MyArrayList<>();
		test.add(1);
		test.add(0);
		test.add(0);
		test.add(0);
//		test.add(1, 2);
//		test.set(0,1);
//		test.clear();
		System.out.println("Remove "+test.remove(0));
		System.out.println("LastIndexOf "+test.lastIndexOf(0));
		System.out.println(test.toString());
	}
}
