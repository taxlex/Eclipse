package assignment08;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntLinkedListTester {

	@Test
	public void test1a() {
		IntLinkedList alist = new IntLinkedList();
		alist.startList(1);
		alist.appendList(2);
		alist.appendList(3);
		alist.appendList(4);
		alist.appendList(5);
		assertEquals("[1, 2, 3, 4, 5]", alist.toString());
	}
	
	@Test
	public void test1b() {
		IntLinkedList alist = new IntLinkedList();
		alist.startList(1);
		alist.appendList(2);
		alist.appendList(3);
		alist.appendList(4);
		alist.appendList(5);
		alist.remove(1);
		alist.remove(4);
		alist.remove(2);
		assertEquals("[3, 5]", alist.toString());
	}
	@Test
	public void test2a() {
		IntLinkedList2 alist = new IntLinkedList2();
		alist.startList(1);
		alist.appendList(2);
		alist.appendList(3);
		alist.appendList(4);
		alist.appendList(5);
		assertEquals("[1, 2, 3, 4, 5]", alist.toString());
	}
	
	@Test
	public void test2b() {
		IntLinkedList2 alist = new IntLinkedList2();
		alist.startList(1);
		alist.appendList(2);
		alist.appendList(3);
		alist.appendList(4);
		alist.appendList(5);
		alist.remove(1);
		alist.remove(4);
		alist.remove(2);
		assertEquals("[3, 5]", alist.toString());
	}

}
