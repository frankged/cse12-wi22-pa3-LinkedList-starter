/**
 * TODO: Add your file header
 * Name: Frank Drugge
 * Email: fdrugge@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * 
 * 2-4 sentence file description here
 * This is my tester for my Linked List that was made without importing 
 * the Linked Lists from Java.
 */

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.*;

/**
 * TODO: Add your class header
 * 
 * IMPORTANT: Do not change the method headers and points are awarded 
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class MyLinkedListCustomTester {
	private MyLinkedList<Integer> integerList;
	private MyLinkedList<String> stringList;
	private MyLinkedList<Object> objectList;
	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test.
	 */
	@Before
	public void setUp() throws Exception {
		integerList = new MyLinkedList<Integer>();
		stringList = new MyLinkedList<String>();
		objectList = new MyLinkedList<Object>();
	}

	/**
	 * TODO: test the add method when [fill in a possible edge case here]
	 */
	@Test
	public void testAdd() {
		boolean testVal = false;
		try {
			integerList.add(null);
		} catch (NullPointerException e) {
			testVal = true;
		}
		assertEquals("testNullPointerException", true, testVal);
	}

	/**
	 * TODO: test the add with index method when [...]
	 */
	@Test
	public void testAddWithIndexTestOne() {
		boolean testVal = false;
		try {
			integerList.add(1, 2);
		} catch (IndexOutOfBoundsException e) {
			testVal = true;
		}
		assertEquals("testIndexOutofBoundsException", true, testVal);
	}

	/**
	 * TODO: test the add with index method when [fill in another one here]
	 */	
	@Test
	public void testAddWithIndexTestTwo() {
		boolean testVal = false;
		try {
			integerList.add(0, null);
		} catch (NullPointerException e) {
			testVal = true;
		}
		assertEquals("testNullPointerException", true, testVal);
	}

	/**
	 * TODO: test the get method when [...]
	 */
	@Test
	public void testGet() {
		boolean testVal = false;
		try {
			integerList.get(-1);
		} catch (IndexOutOfBoundsException e) {
			testVal = true;
		}
		assertEquals("testIndexOutofBoundsException", true, testVal);
	}

	/**
	 * TODO: test the getNth method when [...]
	 */
	@Test
	public void testGetNth() {
		boolean testVal = false;
		try {
			integerList.getNth(-1);
		} catch (IndexOutOfBoundsException e) {
			testVal = true;
		}
		assertEquals("testIndexOutofBoundsException", true, testVal);
	}

	/**
	 * TODO: test the set method when [...]
	 */
	@Test
	public void testSet() {
		boolean testVal = false;
		try {
			integerList.set(0, null);
		} catch (NullPointerException e) {
			testVal = true;
		}
		assertEquals("testNullPointerException", true, testVal);
	}

	/**
	 * TODO: test the remove method when [...]
	 */
	@Test
	public void testRemoveTestOne() {
		boolean testVal = false;
		try {
			integerList.remove(-1);
		} catch (IndexOutOfBoundsException e) {
			testVal = true;
		}
		assertEquals("testIndexOutofBoundsException", true, testVal);
	}
	
	/**
	 * TODO: test the remove method when [fill in another one here]
	 */
	@Test
	public void testRemoveTestTwo() {
		boolean testVal = false;
		try {
			integerList.remove(99);
		} catch (IndexOutOfBoundsException e) {
			testVal = true;
		}
		assertEquals("testIndexOutofBoundsException", true, testVal);
	}

	/**
	 * TODO: test the clear method when [...]
	 */
	@Test
	public void testClear() {
		stringList.add("12");
		stringList.add("11");
		stringList.add("12");
		stringList.clear();
		assertEquals("clear test", 0, stringList.size());
	}

	/**
	 * TODO: test the size method when [...]
	 */
	@Test
	public void testSize() {
		stringList.add("12");
		stringList.add("11");
		stringList.add("12");
		stringList.add("12");
		stringList.add("11");
		stringList.add("12");
		assertEquals("Size test", 6, stringList.size());
	}
}