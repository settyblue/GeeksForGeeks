/**
 * http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 * 
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		String inOrder = "DBEAFC";
		String preOrder = "ABDECF";
		
		BinaryTree<Character> tree = new BinaryTree<Character>();
		
		constructAndPrintBinaryTree(tree,inOrder,preOrder);
	}
	
	public static void constructAndPrintBinaryTree(BinaryTree<Character> tree, String inOrder, String preOrder){
		tree.root = buildTree(inOrder, preOrder);
		tree.printInOrder();
		tree.printPreOrder();
	}

	private static Node<Character> buildTree(String inOrder, String preOrder) {
		if(inOrder.length()==0){
			return null;
		}
		char rootChar = preOrder.charAt(0);
		Node<Character> node = new Node<>(rootChar);
		
		int rootIdxInOrder = inOrder.indexOf(rootChar);
		int leftTreeSize = rootIdxInOrder;
		int rightTreeSize = inOrder.length()-rootIdxInOrder-1;
		if(leftTreeSize != 0){
			node.left = buildTree(inOrder.substring(0, rootIdxInOrder), preOrder.substring(1,1+leftTreeSize));
		}
		if(rightTreeSize != 0){
			node.right = buildTree(inOrder.substring(rootIdxInOrder+1,inOrder.length()), 
					preOrder.substring(preOrder.length()-rightTreeSize,preOrder.length()));
		}
		return node;
	}
	
}
