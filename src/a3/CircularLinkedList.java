package a3;


/** An instance is a circular doubly linked list. */
public class CircularLinkedList<E> {
    private Node head; // a node of linked list (null if none)
    private int size;  // Number of nodes in linked list.

    /** Constructor: an empty linked list. */
    public CircularLinkedList() {
    }

    /** Return the number of values in this list. */
    public int size() {
        return size;
    }

    /** Return the first node of the list (null if the list is empty). */
    public Node getFirst() {
        return head;
    }

    /** Return the last node of the list (null if the list is empty). */
    public Node getLast() {
        if (head == null) return null;
        return head.pred;
    }

    /** If this circular list is empty, return null.
     *  Otherwise, move down the list in circular fashion, so that the
     *  first node becomes the last node, the second becomes the first, etc. */
    public Node moveDown() {
        if (head != null) {
            head = head.succ;
        }
        return head;
    }

    /** Return the value of node e of this list.
     * Precondition: e must be a node of this list; it may not be null. */
    public E valueOf(Node e) {
        if (e == null) {
        	return null;
        }
        return e.value;
    }

    /** Return a representation of this list: its values, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * 
     * E.g. for the list containing 6 3 8 in that order, the result it "[6, 3, 8]". */
    public String toString() {
		String str = "[";
		if (size == 0) {
			// do nothing
		} else if (size == 1) {
			str += Integer.toString((int) head.getValue());
		} else {
			Node current = head;
			str += Integer.toString((int) head.getValue()) + ", ";
			while (current.successor() != head) {
				current = current.successor();
				if (current.successor() == head) {
					str += Integer.toString((int) current.getValue());
				} else {
					str += Integer.toString((int)current.getValue()) + ", ";
				}
			}	
		}
		str += "]";
		return str;
    }

    /** Return a representation of this list: its values in reverse, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * 
     * E.g. for the list containing 6 3 8 in that order, the result it "[8, 3, 6]".*/
    public String toStringReverse() {
		String str = "[";
		
		if (size == 0) {
			// do nothing
		} else if (size == 1) {
			str += Integer.toString((int) head.getValue());
		} else {
			Node current = head.predecessor();
			str += Integer.toString((int) current.getValue()) + ", ";
			while (current.predecessor() != head.predecessor()) {
				current = current.predecessor();
				if (current.predecessor() == head.predecessor()) {
					str += Integer.toString((int) current.getValue());
				} else {
					str += Integer.toString((int)current.getValue()) + ", ";
				}
			}	
		}
		str += "]";
		return str;
    }

    /** Append value v to the list. */
    public void append(E v) {
        /* Note: this method views the list as a list with a first and
         * a last value. It adds a new value at the end, not changing any
         * others. */
    	if (size == 0) {
    		head = new Node(null, v, null);
    		head.setPredecessor(head);
    		head.setSuccessor(head);
    	} else {
    		Node current = head.predecessor();
    		Node newNode = new Node(current, v, head);
    		head.setPredecessor(newNode);
    		current.setSuccessor(newNode);
    	}
    	size++;
    }

    /** Prepend value v to the list. */
    public void prepend(E v) {
        /* Note: this method views the list as a list with a first and
         * a last value. It adds a new value at the beginning, so head
         * should end up pointing to the new node. */
    	if (size == 0) {
    		append(v);
    	} else {
	    	Node temp = head;
	    	head = new Node(temp.pred, v, temp);
	    	head.pred.succ = head;
	    	temp.pred = head;
	    	size++;
    	}
    }

    /** Insert value v in a new node before node e of this circular list.
     * Precondition: e must be a node of this list, i.e. it may not be null. */
    public void insertBefore(E v, Node e) {
        /* Note: This method views the list as a circular list, so it doesn't
         * really matter which node head points to when the method is done.
         * However, we require that head does not change. */
    	if (size == 1) {
    		Node newNode = new Node(head, v, head);
    		head.succ = newNode;
    		head.pred = newNode;
    	} else {
    		Node current = head;
    		while (current.succ != e) {
    			current = current.succ;
    		}
    		Node temp = e.pred;
    		Node newNode = new Node(e.pred, v, e);
    		temp.succ = newNode;
    		e.pred = newNode;
    	}
    	size++;
    }

    /** Insert value v in a new node after node e.
     * Precondition: e must be a node of this list, i.e. it may not be null. */
    public void insertAfter(E v, Node e) {
        /* Note: This method views the list as a circular list, so it doesn't
         * really matter which node head points to when the method is done.
         * However, we require that head does not change. */
    	if (size == 1) {
    		Node newNode = new Node(head, v, head);
    		head.succ = newNode;
    		head.pred = newNode;
    	} else {
    		Node current = head;
    		while (current.pred != e) {
    			current = current.succ;
    		}
    		Node temp = e.succ;
    		Node newNode = new Node(e, v, e.succ);
    		temp.pred = newNode;
    		e.succ = newNode;
    	}
    	size++;
    }

    /** Remove node e from this list.
     *  Precondition: e must be a node of this list, i.e. it may not be null. */
    public void remove(Node e) {
        assert e != null;

        Node current = head;
        if (size == 1) {
        	head = null;
        } else if (size == 2) {
        	if (head == e) {
        		head = head.successor();
        	}
    		head.setPredecessor(head);
    		head.setSuccessor(head);
        } else {
        	if (head == e) {
        		head = head.successor();
        	}
            while (current != e) {
            	current = current.successor();
            }
            Node temp = current.predecessor();
	        current.successor().setPredecessor(temp);
	        temp.setSuccessor(current.successor());
        }
        size--;
    }

    /** An instance is a node of this list. */
    public class Node {
        /** Predecessor of this node on the list (null if the list is empty). */
        private Node pred;

        /** The value of this element. */
        private E value; 

        /** Successor of this node on the list. (null if the list is empty). */
        private Node succ; 

        /** Constructor: an instance with     	this.size = 0;
    	this.head = null;predecessor p (p can be null),
         * successor s (s can be null), and value v. */
        private Node(Node p, E v, Node s) {
            pred= p;
            value = v;
            succ= s;
        }

        /** Return the value of this node. */
        public E getValue() {
            return value;
        }
        
        public void setPredecessor(Node n) {
        	pred = n;
        }

        /** Return the predecessor of this node e in the list. */
        public Node predecessor() {
            return pred;
        }
        
        public void setSuccessor(Node n) {
        	succ = n;
        }
        /** Return the successor of this node in this list. */
        public Node successor() {
            return succ;
        }
        
    }

}