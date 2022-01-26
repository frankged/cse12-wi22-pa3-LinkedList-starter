/**
 * TODO: Add your file header
 * Name: Frank Drugge
 * Email: fdrugge@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * 
 * Attempting to create our own implementation of Java's Linked List.
 * We did not import Java's implementation and instead wrote our own. 
 */

import java.util.AbstractList;

/** 
 *  Creating our own Linked Lists, we import AbstractList, and use the instance
 * variables, size, head, and tail 
 * to implement the features of our Linked List.
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
		head = new Node(null);
		tail = new Node(null);
		head.setNext(tail);
		tail.setPrev(head);
		this.size = 0;
	}

	@Override
	public int size() {
		//returns the number of elements in the Linked List.
		return this.size; 
	}

	@Override
	public E get(int index) {
		//takes an index and returns the data field of the Node at that index.
		//throws an IndexOutOfBoundsException for index out of bounds.
		if (index >= this.size() && index > 0 || index < 0) {
			throw new IndexOutOfBoundsException("Out of Bounds");
		}
		return (E) getNth(index).data;  
	}

	@Override
	public void add(int index, E data) {
		//Adds a new Node at the given index with the given data in its .data field.
		//Throws exceptions if index is out of bounds or if data is null.
		if (data == null) {
			throw new NullPointerException("Data is Null");
		}
		if (index >= this.size() && index > 0 || index < 0) {
			throw new IndexOutOfBoundsException("Out of Bounds");
		}
		Node curr = getNth(index);
		//set up newNode
		Node newNode = curr.prev;
		newNode.setPrev(curr.prev);
		newNode.setElement(data);
		//update previous node's next field to newNode
		curr.prev.setNext(newNode);
		//update new next node's prev field to newNode
		curr.setPrev(newNode);
		this.size++;
	}

	public boolean add(E data) {
		//Adds a new Node at the end of the Linked List.
		//Throws exception if data is null.
		if (data == null) {
			throw new NullPointerException("Data is Null");
		}
		Node newNode = tail;
		newNode.setElement(data);
		tail.setPrev(newNode);
		newNode.setNext(tail);
		this.size++;
		return true;
	}

	public E set(int index, E data) {
		//Sets the data field of the Node at the given index to data
		//throws both an IndexOutOfBoundsException and a NullPointerException
		if (index < 0 || index >= this.size() && index > 0) {
			throw new IndexOutOfBoundsException("Out of Bounds");
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
		//removes the Node at the given index
		//throws an IndexOutOfBoundsException
		if (index < 0 || index >= this.size() && index > 0) {
			throw new IndexOutOfBoundsException("Out of Bounds");
		}
		Node curr = this.getNth(index);
		curr.next.setPrev(curr.prev);
		curr.prev.setNext(curr.next);
		this.size--;
		return (E) curr.data; 
	}

	public void clear() {
		//removes all Nodes except for the head and tail
		this.head.setNext(tail);
		this.tail.setPrev(head);
		this.size = 0;
	}

	public boolean isEmpty() {
		//returns true if list is empty, false otherwise.
		if (this.size() == 0) {
			return true;
		}
		return false;
	}

	protected Node getNth(int index) {
		//returns the Node at the given index
		//throws an IndexOutOfBoundsException
		if (index < 0 || index >= this.size() && index > 0) {
			throw new IndexOutOfBoundsException("Out of Bounds");
		}
		Node curr = this.head;
		for (int i = 0; i < index + 1; i++) {
			curr = curr.next;
			System.out.println(i);
		}
		return (Node) curr; 
	}
}