package a3;

public class Test {

	public static void main(String[] args) {
		/**LinkedList<Integer> lst = new LinkedList<Integer>();
		lst.append(2);
		lst.append(3);
		lst.append(50);
		lst.prepend(12);
		System.out.println("List" + lst.toString());
		lst.remove(12);
		lst.remove(3);
		System.out.println("List" + lst.toString());
		System.out.println("Size=" + lst.size());
		lst.removeFirst();
		lst.removeLast();
		System.out.println("List" + lst.toString()); **/
		
		CircularLinkedList<Integer> lst = new CircularLinkedList<Integer>();
		System.out.println(lst.toString());
		System.out.println(lst.toStringReverse());
		lst.append(1);
		System.out.println(lst.toString());
		System.out.println(lst.toStringReverse());
		lst.append(2);
		System.out.println(lst.toString());
		System.out.println(lst.toStringReverse());
		lst.append(3);
		System.out.println(lst.toString());
		System.out.println(lst.toStringReverse());
		lst.remove(lst.getFirst());
		System.out.println("I never make it here!");
		
		
		System.out.println(lst.toString());
		System.out.println("I never make it here?");
		lst.remove(lst.getFirst());
		System.out.println(lst.toString());
	}

}
