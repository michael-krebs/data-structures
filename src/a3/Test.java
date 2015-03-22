package a3;

public class Test {

	public static void main(String[] args) {
		LinkedList<Integer> lst = new LinkedList<Integer>();
		lst.append(2);
		lst.append(3);
		lst.append(50);
		lst.prepend(12);
		System.out.println(lst.toString());
	}

}
