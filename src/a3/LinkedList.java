/**
 * 
 */
package a3;

public class LinkedList<E> {
	
	private int size;
	private Node<E> head;
	
	public LinkedList() {
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public Node<E> getFirst() {
		return head;
	}
	
	public void prepend(E value) { // Adds a node to the front of the list
		Node<E> temp = new Node(value, head);
		head = temp;
		size++;
	}
	
	public void append(E value) { // Adds a node to the end of the list
		if (size != 0) {
			
			Node<E> current = head;
			
			while (current.getNext() != null) {
				current = current.getNext();
			}
			
			Node<E> temp = new Node(value, null);
			current.setNext(temp);
			size++;
			
		} else { // if the list is empty, adding to the beginning just works
			prepend(value);
		}
	}
	
	public void removeFirst() { // Removes the first node
		if (size == 0) {
			return;
		}
		head = head.getNext();
		size--;
	}
	
	public void removeLast() { // Removes the last node
		if (size == 0) {
			return;
		}
		Node<E> current = head;
		if (size == 1) {
			head = null;
		} else {
			for (int i = 0; i < size - 1; i++) {
				current = current.getNext();
			}
			current.setNext(null);
		}
		size--;
	}
	
	public void remove(E value) {
		//assert size != 0;
		if (size == 0) {
			return;
		}
		Node<E> current = head;
		if (current.getValue() == value) {
			removeFirst();
			return;
		} else {
			while (current.getNext().getValue() != value ) {
				current = current.getNext();
			}
			current.setNext(current.getNext().getNext());
			size--;
		}
	}
	
	public String toString() {
		String str = "[";
		if (size == 0) {
			
		} else {
			Node<E> current = head;
			str += Integer.toString((int) head.getValue()) + ", ";
			while (current.getNext() != null) {
				current = current.getNext();
				if (current.getNext() == null) {
					str += Integer.toString((int) current.getValue());
				} else {
					str += Integer.toString((int)current.getValue()) + ", ";
				}
			}	
		}
		str += "]";
		return str;
	}
	
	public class Node<E> {
		
		private E value;
		private Node<E> succ;
		
		private Node(E value, Node<E> succ) {
			this.value = value;
			this.succ = succ;
		}
		
		public E getValue() {
			return value;
		}
		
		public Node<E> getNext() {
			return succ;
		}
		
		public void setNext(Node<E> node) {
			succ = node;
		}
		
	}
}
