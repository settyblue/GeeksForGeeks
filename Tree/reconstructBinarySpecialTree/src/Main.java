/**
 * http://www.geeksforgeeks.org/construct-binary-tree-from-inorder-traversal/
 * 
 */

/**
 * @author Rakshith Kunchum
 *
 */

public class Main {

	public static void main(String[] args) {
		//int[] inOrder = {5, 10, 40, 30, 28};
		int[] inOrder = {1, 5, 10, 40, 30, 15, 28, 20};
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		constructAndPrintBinarySpecialTree(tree,inOrder);

	}

	/**
	 * @param tree
	 * @param inOrder
	 */
	private static void constructAndPrintBinarySpecialTree(BinaryTree<Integer> tree, int[] inOrder) {
		tree.root = buildSpecialTree(inOrder, 0, inOrder.length);
		tree.printInOrder();
		tree.printLevelOrder();
	}

	/**
	 * @param tree
	 * @param inOrder
	 * @return Node<Integer>
	 */
	private static Node<Integer> buildSpecialTree(int[] inOrder, int fromIndex, int toIndex) {
		if(inOrder.length == 0){
			return null;
		}
		int maxValue = inOrder[fromIndex];
		int maxIndex = fromIndex;
		for(int i=fromIndex+1; i<toIndex; i++){
			if(inOrder[i] > maxValue){
				maxValue = inOrder[i];
				maxIndex = i;
			}
		}
		Node<Integer> node = new Node<>(maxValue);
		if(maxIndex-fromIndex > 0){
			node.left = buildSpecialTree(inOrder,fromIndex,maxIndex);
		}
		
		if(toIndex-maxIndex > 1){
			node.right = buildSpecialTree(inOrder,maxIndex+1,toIndex);
		}
		
		return node;
	}
	
	
}
