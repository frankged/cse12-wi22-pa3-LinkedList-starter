/**
 * TODO: Add your file header
 * Name:
 * Email:
 * Sources used: Put "None" if you did not have any external help
 * 
 * 2-4 sentence file description here
 */

import java.util.AbstractList;

/** 
 * TODO: Add class header here 
 */

public class MyLinkedList<E> extends AbstractList<E> {

	int size;
	Node head;
	Node tail;

	/**
	 * A Node class that holds data and references to previous and next Nodes.
	 */
	protected class Node {
		E data;
		Node next;
		Node prev;

		/** 
		 * Constructor to create singleton Node 
		 * @param element Element to add, can be null	
		 */
		public Node(E element) {
			// Initialize the instance variables
			this.data = element;
			this.next = null;
			this.prev = null;
		}

		/** 
		 * Set the parameter prev as the previous node
		 * @param prev - new previous node
		 */
		public void setPrev(Node prev) {
			this.prev = prev;		
		}

		/** 
		 * Set the parameter next as the next node
		 * @param next - new next node
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		/** 
		 * Set the parameter element as the node's data
		 * @param element - new element 
		 */
		public void setElement(E element) {
			this.data = element;
		}

		/** 
		 * Accessor to get the next Node in the list 
		 * @return the next node
		 */
		public Node getNext() {
			return this.next;
		}

		/** 
		 * Accessor to get the prev Node in the list
		 * @return the previous node  
		 */
		public Node getPrev() {
			return this.prev;
		}

		/** 
		 * Accessor to get the Nodes Element 
		 * @return this node's data
		 */
		public E getElement() {
			return this.data;
		}
	}

	//  Implementation of the MyLinkedList Class
	/** Only 0-argument constructor is defined */
	public MyLinkedList() {
		/* Add your implementation here */
		head = new Node(null);
		tail = new Node(null);
		head.setNext(tail);
		tail.setPrev(head);
	}

	@Override
	public int size() {
		// need to implement the size method
		return this.size; 
	}

	@Override
	public E get(int index) {
		if (index >= this.size() && index > 0 || index < 0) {
			throw new IndexOutOfBoundsException("Index out of Bounds For List Size " + this.size());
		}
		Node curr = getNth(index);
		return (E) curr.data;  
	}

	@Override
	public void add(int index, E data) {
		if (data == null) {
			throw new NullPointerException("Data is Null");
		}
		if (index >= this.size() && index > 0 || index < 0) {
			throw new IndexOutOfBoundsException("Index out of Bounds For List Size " + this.size());
		}
		Node curr = getNth(index);
		Node newNode = curr.prev;
		newNode.setPrev(curr.prev);
		newNode.setElement(data);
		curr.prev.setNext(newNode);
		curr.setPrev(newNode);
		this.size++;
	}

	public boolean add(E data) {
		if (data == null) {
			throw new NullPointerException("Data is Null");
		}
		//Potential re-write if tail updates mid-code, Fix would be
		//Node oldTail = tail; //replace tail with oldTail.
		Node newNode = tail;
		newNode.setElement(data);
		tail.setPrev(newNode);
		newNode.setNext(tail);
		this.size++;
		return true;
	}

	public E set(int index, E data) {
		if (index < 0 || index >= this.size() && index > 0) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + this.size());
		}
		if (data == null) {
			throw new NullPointerException("Data is Null");
		}
		Node curr = this.getNth(index);
		E toReturn = curr.data;
		curr.setElement(data);
		return (E) toReturn;
	}

	public E remove(int index) {
		if (index < 0 || index >= this.size() && index > 0) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size" + this.size());
		}
		Node curr = this.getNth(index);
		curr.next.setPrev(curr.prev);
		curr.prev.setNext(curr.next);
		this.size--;
		return (E) curr.data; 
	}

	public void clear() {
		this.head.setNext(tail);
		this.tail.setPrev(head);
		this.size = 0;
	}

	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		}
		return false;
	}

	protected Node getNth(int index) {
		if (index < 0 || index >= this.size() && index > 0) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size" + this.size());
		}
		Node curr = this.head.next;
		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}
		return (Node) curr; 
	}
}