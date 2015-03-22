/**
 * 
 */
package a3;

public class LinkedList<E> {
	
	private int size;
	private Node head;
	
	public LinkedList() {
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public Node getFirst() {
		return head;
	}
	
	public void prepend(E value) { // Adds a node to the front of the list
		Node temp = new Node(value, head);
		head = temp;
		size++;
	}
	
	public void append(E value) { // Adds a node to the end of the list
		if (size != 0) {
			
			Node current = head;
			
			while (current.getNext() != null) {
				current = current.getNext();
			}
			
			Node temp = new Node(value, null);
			current.setNext(temp);
			size++;
			System.out.println(this.toString());
			
		} else { // if the list is empty, adding to the beginning just works
			prepend(value);
		}
	}
	
	public void removeFirst() { // Removes the first node
		assert size != 0;
		head = head.getNext();
		size--;
	}
	
	public void removeLast() { // Removes the last node
		assert size != 0;
		Node current = head;
		for (int i = 0; i < size - 1; i++) {
			current = current.getNext();
		}
		current.setNext(null);
		size--;
	}
	
	public void remove(E value) {
		assert size != 0;
		Node current = head;
		while (current.getNext().getValue() != value ) {
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		size--;
	}
	
	public String toString() {
		String str = "[";
		Node current = head;
		str += head.getValue() + ", ";
		while (current.getNext() != null) {
			str += current.getNext().getValue() + ", ";
		}
		str += "]";
		return str;
	}
	
	public class Node {
		
		private E value;
		private Node succ;
		
		private Node(E value, Node succ) {
			this.value = value;
			this.succ = succ;
		}
		
		public E getValue() {
			return value;
		}
		
		public Node getNext() {
			return succ;
		}
		
		public void setNext(Node node) {
			succ = node;
		}
		
	}
}
