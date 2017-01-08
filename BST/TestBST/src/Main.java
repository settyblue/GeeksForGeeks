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
		
		//bst.insert(10);bst.insert(40);bst.insert(0);bst.insert(5);bst.insert(20);bst.insert(100);
		populateBST(bst);
		System.out.println(bst.toString());
		System.out.println(bst.treeOrder());
		System.out.println(bst.toList().toString());
		System.out.println(bst.floor(8));
		System.out.println(bst.floor(9));
		System.out.println(bst.floor(0));
		System.out.println(bst.ceil(8));
		System.out.println(bst.ceil(9));
		System.out.println(bst.ceil(15));
		/*
		bst.printKeysInRange(5, 50);
		bst.printKeysInRange(5, 105);
		bst.printKeysInRange(0, 105);
		*/
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
	
	
	/*
	 *             8
	 *	         /    \
	 *	       3       10
	 *	     /  \        \
	 *	    1     6       14
	 *	        /   \     /
	 *	       4     7   13  
	 */
	private static void populateBST(BSTree<Integer> bst) {
		int[] array = {8, 3, 6, 1, 4, 7, 10, 14, 13};
		
		for(Integer i:array){
			bst.insert(i);
		}
		
	}

}
