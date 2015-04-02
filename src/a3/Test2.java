package a3;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test2 {

	@Test
	public void testSize() {
		CircularLinkedList<Integer> lst = new CircularLinkedList<Integer>();
		assertEquals(0, lst.size());
		lst.append(1);
		lst.append(2);
		assertEquals(2, lst.size());
		lst.remove(lst.getFirst());
		assertEquals(1, lst.size());
	}
	
	@Test
	public void testAppend() {
		CircularLinkedList<Integer> lst = new CircularLinkedList<Integer>();
		lst.append(1);
		assertEquals(1, (int)lst.getFirst().getValue());
		assertEquals("[1]", lst.toString());
		lst.append(2);
		assertEquals(2, (int)lst.getLast().getValue());
	}
	
	@Test
	public void testMoveDown() {
		CircularLinkedList<Integer> lst = new CircularLinkedList<Integer>();
		lst.append(1);
		assertEquals(1, (int)lst.moveDown().getValue());
		lst.append(2);
		assertEquals(2, (int)lst.moveDown().getValue());
		System.out.println(lst.toString());
		lst.append(3);
		System.out.println(lst.toString());
		lst.append(4);
		lst.append(5);
		assertEquals(1, (int)lst.moveDown().getValue());
		System.out.println(lst.toString());
		assertEquals(3, (int)lst.moveDown().getValue());
		System.out.println(lst.toString());
		
	}
	
	@Test
	public void prepend() {
		CircularLinkedList<Integer> lst = new CircularLinkedList<Integer>();
		lst.prepend(2);
		lst.prepend(1);
		assertEquals("[1, 2]", lst.toString());
	}
}
