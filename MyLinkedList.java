/** 
 * TODO: Add file header here 
 * Author:
 * Email: 
 * References: 
 */

import java.util.AbstractList;
import java.util.NoSuchElementException;

/** 
 * TODO: Add class header here 
 */
public class MyLinkedList<E> extends AbstractList<E> {

	int size;
	Node head;
	Node tail;

	/**
     * A Node class that holds data and references to previous and next Nodes
	 * This class is used for both MyLinkedList and MyListIterator.
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
			//TODO Initialize the instance variables
		}

		/** 
		 * Set the node p on the previous position
		 * @param p new previous node
		 */
		public void setPrev(Node p) {
			//TODO 
		}

		/** 
		 * //Set the node n on the next position
		 * @param n new next node
		 */
		public void setNext(Node n) {
			// TODO
		}

		/** 
		 * Set the element 
		 * @param e new element 
		 */
		public void setElement(E e) {
			//TODO
		}

		/** 
		 * Accessor to get the next Node in the list 
		 * @return the next node
		 */
		public Node getNext() {
			return (Node)null; //TODO
		}
		/** 
		 * Accessor to get the prev Node in the list
		 * @return the previous node  
		 */
		public Node getPrev() {
			return (Node)null; //TODO
		} 
		/** 
		 * Accessor to get the Nodes Element 
		 * @return this node's data
		 */
		public E getElement() {
			return null; //TODO
		} 
	}

	//  Implementation of the MyLinkedList Class
	/** Only 0-argument constructor is defined */
	public MyLinkedList() {
		/* Add your implementation here */
		// TODO
	}

	@Override
	public int size() {
		// need to implement the size method
		return 0; // TODO
	}

	@Override
	public E get(int index) {
		return (E) null;  // TODO
	}

	@Override
	public void add(int index, E data) {
		/* Add your implementation here */
		// TODO
	}

	public boolean add(E data) {
		return true; // TODO
	}

	public E set(int index, E data) {
		return (E) null; // TODO
	}

	public E remove(int index) {
		return (E) null; // TODO
	}

	public void clear() {
		/* Add your implementation here */
	}

	public boolean isEmpty() {
		return true;  // TODO
	}

	protected Node getNth(int index) {
		return (Node) null;  // TODO
	}
}