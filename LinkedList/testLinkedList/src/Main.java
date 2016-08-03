/**
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>(10); 
		list.addEnd(20);
		list.addEnd(30);
		list.addEnd(40);
		list.addEnd(50);
		list.add(60);
		list.addBegin(0);
		list.addBegin(-10);
		list.printLinkedList();
		System.out.println("count = "+list.getCount());
		list.remove(40);
		list.printLinkedList();
		list.removeAt(3);
		list.printLinkedList();
		list.insert(3, 40);
		list.printLinkedList();
		list.set(3, 400);
		list.printLinkedList();
	}

}
