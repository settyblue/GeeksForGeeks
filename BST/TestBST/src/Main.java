import java.util.Arrays;

/**
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		BSTree<Integer> bst = new BSTree<Integer>();
		
		bst.insert(10);bst.insert(40);bst.insert(0);bst.insert(5);bst.insert(20);bst.insert(100);
		System.out.println(bst.toString());
		System.out.println(bst.treeOrder());
		System.out.println(bst.toList().toString());
		bst.printKeysInRange(5, 50);
		bst.printKeysInRange(5, 105);
		bst.printKeysInRange(0, 105);
		/*
		//System.out.println(bst.getMax());
		//System.out.println(bst.getMin());
		System.out.println(bst.inOrderSuccessor(0));
		System.out.println(bst.inOrderSuccessor(5));
		System.out.println(bst.inOrderSuccessor(10));
		System.out.println(bst.inOrderSuccessor(20));
		System.out.println(bst.inOrderSuccessor(40));
		System.out.println(bst.inOrderSuccessor(100));
		System.out.println(bst.inOrderSuccessor(30));
		*/
	}

}
